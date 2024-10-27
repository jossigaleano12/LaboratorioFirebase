package com.example.firebaseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firebaseapp.navigation.NavManager
import com.example.firebaseapp.ui.theme.FirebaseAPPTheme
import com.example.firebaseapp.viewmodel.LoginViewModel
import com.example.firebaseapp.viewmodel.NoteViewModel
import com.example.firebaseapp.view.login.TabsView


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val loginViewModel : LoginViewModel by viewModels()
        val notesViewModel : NoteViewModel by viewModels()
        setContent {
            FirebaseAPPTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavManager(loginViewModel=loginViewModel,
                        notesViewModel = notesViewModel)
                }
            }
        }
    }
}

