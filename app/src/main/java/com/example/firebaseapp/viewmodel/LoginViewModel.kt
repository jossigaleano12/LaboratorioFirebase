package com.example.firebaseapp.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebaseapp.model.User
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private var auth: FirebaseAuth = Firebase.auth
    var showAlert by mutableStateOf(false)

    fun login(email: String, password: String, onSuccess: () -> Unit){
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            onSuccess()
                        } else {
                            Log.w("Login", "signInWithEmail:failure", task.exception)
                            showAlert = true
                        }
                    }
            }catch (e: Exception){
                Log.e("LoginViewModel", "Error al iniciar sesión", e)
            }
        }
    }

    fun register(email: String, password: String, userName: String ,onSuccess: () -> Unit){
        viewModelScope.launch {
            try {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            saverUser(userName)
                            onSuccess()
                        } else {
                            Log.w("Login", "Register failed", task.exception)
                            showAlert = true
                        }
                    }
            }catch (e: Exception){
                Log.e("LoginViewModel", "Register failed", e)
            }
        }
    }

    private fun saverUser(userName: String) {
        val id = auth.currentUser?.uid
        val email = auth.currentUser?.email

        viewModelScope.launch(Dispatchers.IO) {
            val user = User(userId = id.toString(), name = userName, email = email.toString())
            FirebaseFirestore.getInstance().collection("users").add(user.toMap())
                .addOnCompleteListener(){ task ->
                    if(task.isSuccessful){
                        Log.d("LoginViewModel", "User saved successfully")
                    } else {
                        Log.w("LoginViewModel", "Error saving user", task.exception)
                    }
                }
        }

    }

    fun closeAler(){
        showAlert = false
    }

}