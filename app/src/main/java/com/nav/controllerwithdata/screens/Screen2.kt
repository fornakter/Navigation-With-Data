@file:OptIn(ExperimentalMaterial3Api::class)

package com.nav.controllerwithdata.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun Screen2(navController: NavController) {
    val text = remember {
        mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = "Screen2")
        OutlinedTextField(value = text.value, onValueChange = {text.value = it})
        Button(onClick = {
            navController.navigate("Screen1")
            navController.currentBackStackEntry
                ?.savedStateHandle
                ?.set("my_text", text.value)
        }) {
            Text(text = "Apply")
            
        }

    }

}