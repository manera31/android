package com.joanmanera.listadelacomprafirebase.Interfaces;


import com.google.firebase.firestore.DocumentSnapshot;

public interface IProductListListener {
    void onProductListSelected(DocumentSnapshot documentSnapshot, int position);
}
