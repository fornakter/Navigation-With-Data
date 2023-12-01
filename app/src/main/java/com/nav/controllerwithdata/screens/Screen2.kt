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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun Screen2(navController: NavController) {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        var text by remember {
            mutableStateOf("") }
        Text(text = "Screen2")
        OutlinedTextField(value = text,
            onValueChange = {text = it})
        Button(onClick = {
            navController.navigate("Screen1")
            navController.currentBackStackEntry
                ?.savedStateHandle
                ?.set("my_text", text)}) {

            Text(text = "Apply")
        }
    }
}