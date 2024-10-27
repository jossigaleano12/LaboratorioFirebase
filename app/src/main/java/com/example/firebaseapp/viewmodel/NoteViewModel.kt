package com.example.firebaseapp.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class NoteViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
        fun signOut(){
            auth.signOut()
        }
    }