package com.nav.controllerwithdata.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun Screen1(navController: NavController) {
    val text = remember {
        mutableListOf("") }
    val savedStateHandle = navController.currentBackStackEntry?.savedStateHandle
    val savedText = savedStateHandle?.get<String>("my_text")

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        savedText?.let { Text(text = it) }

        Text(text = "Screen2")
        Button(onClick = {
            navController.navigate("Screen1")
        }){
            Text(text = "Go to first screen")
        }
    }
}