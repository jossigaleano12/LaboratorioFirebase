package com.example.firebaseapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firebaseapp.view.login.BlackView
import com.example.firebaseapp.view.login.TabsView
import com.example.firebaseapp.view.notas.HomeView
import com.example.firebaseapp.viewmodel.LoginViewModel
import com.example.firebaseapp.viewmodel.NoteViewModel

@Composable
fun NavManager(loginViewModel: LoginViewModel, notesViewModel: NoteViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login"){
        composable("blank"){
            BlackView(navController = navController)
        }
        composable("login"){
            TabsView(navController = navController, loginViewModel = LoginViewModel())
        }
        composable("home"){
            HomeView(navController = navController, viewModel = NoteViewModel())
        }
    }
}