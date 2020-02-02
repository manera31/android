package com.joanmanera.listadelacomprafirebase.Interfaces;


import com.google.firebase.firestore.DocumentSnapshot;

public interface ICategoryListListener {
    void onCategoryListSelected(DocumentSnapshot documentSnapshot, int position);
}
