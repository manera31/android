package com.joanmanera.listadelacomprafirebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.joanmanera.listadelacomprafirebase.Adapters.AdapterListas;
import com.joanmanera.listadelacomprafirebase.Fragments.FragmentCategorias;
import com.joanmanera.listadelacomprafirebase.Fragments.FragmentListas;
import com.joanmanera.listadelacomprafirebase.Fragments.FragmentProductoLista;
import com.joanmanera.listadelacomprafirebase.Fragments.FragmentProductos;
import com.joanmanera.listadelacomprafirebase.Interfaces.ICategoryListListener;
import com.joanmanera.listadelacomprafirebase.Interfaces.IListListener;
import com.joanmanera.listadelacomprafirebase.Interfaces.IProductListListener;
import com.joanmanera.listadelacomprafirebase.Interfaces.IProductoComprado;
import com.joanmanera.listadelacomprafirebase.Models.Categoria;
import com.joanmanera.listadelacomprafirebase.Models.CategoriaProducto;
import com.joanmanera.listadelacomprafirebase.Models.ProductoLista;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IListListener, View.OnClickListener, ICategoryListListener, IProductListListener, IProductoComprado {

    private static final int SIGN_IN_REQUEST_CODE = 1001;
    private DocumentSnapshot documentCurrentList;
    private FirebaseFirestore db;
    private CollectionReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.GoogleBuilder().build());

        if(FirebaseAuth.getInstance().getCurrentUser() == null) {
            // Iniciamos Activity para Login/Registro
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(providers)
                            .build(),
                    SIGN_IN_REQUEST_CODE
            );
        } else {
            // El usuario ya se ha autenticado.
            Toast.makeText(this,
                    "Bienvenido " + FirebaseAuth.getInstance().getCurrentUser().getDisplayName(), Toast.LENGTH_LONG).show();

            mostrarListas();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Comprobamos si se ha logeado correctamente.
        if(requestCode == SIGN_IN_REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                Toast.makeText(this,
                        "Acceso autorizado. ¡Bienvenido!",
                        Toast.LENGTH_LONG)
                        .show();

                mostrarListas();
            } else {
                Toast.makeText(this,
                        "Acceso denegado. Inténtalo de nuevo más tarde.",
                        Toast.LENGTH_LONG)
                        .show();

                // Close the app
                finish();
            }
        }
    }

    public void mostrarListas() {
        // Mostramos las listas.
        db = FirebaseFirestore.getInstance();
        FragmentListas fragmentListas = new FragmentListas(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragmentListas).addToBackStack(null).commit();
    }

    @Override
    public void onListSelected(DocumentSnapshot documentSnapshot, int position) {
        // Cuando se selecciona una lista la guardará y cargaralos ptroductos de esa lista.
        documentCurrentList = documentSnapshot;
        FragmentProductoLista fragmentProductoLista = new FragmentProductoLista(documentSnapshot.getString("name"), this, this);
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragmentProductoLista).addToBackStack(null).commit();
    }

    @Override
    public void onClick(View v) {
        // Controla el boton de Añadir Productos. Cuando se pulsa se carga el fragment de las categorías.
        FragmentCategorias fragmentCategorias = new FragmentCategorias(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragmentCategorias).addToBackStack(null).commit();
    }

    @Override
    public void onCategoryListSelected(DocumentSnapshot documentSnapshot, int position) {
        // Listener para controlar cuando se selecciona una categoría. Cargara los productos de esta categoría.
        FragmentProductos fragmentProductos = new FragmentProductos(this, documentSnapshot.getString("nombreCategoria"));
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragmentProductos).addToBackStack(null).commit();
    }

    @Override
    public void onProductListSelected(final DocumentSnapshot documentSnapshot, int position) {
        // Listener para controlar cuando se pulse un producto.
        Toast.makeText(this, documentSnapshot.getString("nombreProducto"), Toast.LENGTH_SHORT).show();

        ref = db.collection("producto_lista");
        ref.whereEqualTo("nombreLista", documentSnapshot.getString("nombreLista"))
                .whereEqualTo("nombreProducto", documentSnapshot.getString("nombreProducto"))
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    boolean exist = false;
                    for (DocumentSnapshot documentSnapshot1: task.getResult()){
                        if(documentSnapshot1.getString("nombreProducto").equals(documentSnapshot.getString("nombreProducto"))){
                            exist = true;
                        }
                    }

                    // Si el producto no se encuentra en la lista se añade. De lo contrario no.
                    if (!exist){
                        ProductoLista pl = new ProductoLista(documentCurrentList.getString("name"), documentSnapshot.getString("nombreProducto"), false);
                        ref.add(pl);
                    }
                }
            }
        });
    }

    @Override
    public void onProductoComprado(DocumentSnapshot documentSnapshot, boolean comprado) {
        // Controla cuando un producto de la lista es comprado. Lo busca en la base de datos y modifica su valor.
        db.collection("producto_lista").document(documentSnapshot.getId()).update("estaComprada", comprado);
    }
}
