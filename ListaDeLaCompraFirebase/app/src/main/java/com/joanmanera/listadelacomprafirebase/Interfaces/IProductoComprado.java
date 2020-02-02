package com.joanmanera.listadelacomprafirebase.Interfaces;

import com.google.firebase.firestore.DocumentSnapshot;

public interface IProductoComprado {
    void onProductoComprado(DocumentSnapshot documentSnapshot, boolean comprado);
}
