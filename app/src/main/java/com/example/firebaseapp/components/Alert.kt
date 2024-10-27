package com.example.firebaseapp.components

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign


@Composable
fun Alert(title: String, message: String, confirm: String, onConfirm : () -> Unit, onDismis : () -> Unit){
    val scroll = rememberScrollState(0)
    AlertDialog(
        onDismissRequest = onDismis,
        title = { Text(text = title) },
        text = { Text(text = message, textAlign = TextAlign.Justify, modifier = Modifier.verticalScroll(scroll)) },
        confirmButton = {
            Button(onClick = onConfirm) {
                Text(text = confirm)
            }
        }
    )
}