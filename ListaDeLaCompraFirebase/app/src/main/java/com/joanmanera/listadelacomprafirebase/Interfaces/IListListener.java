package com.joanmanera.listadelacomprafirebase.Interfaces;

import com.google.firebase.firestore.DocumentSnapshot;


public interface IListListener{
    void onListSelected(DocumentSnapshot documentSnapshot, int position);
}
