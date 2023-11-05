package com.nav.controllerwithdata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nav.controllerwithdata.ui.theme.NavControllerWithDataTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavControllerWithDataTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "Screen1"){
                    composable("Screen1"){
                            entry -> val text = entry.savedStateHandle.get<String>("my_text")
                        
                        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            text?.let { Text(text = text) }
                            Text(text = "Screen1")
                            Button(onClick = {navController.navigate("Screen2")}) {
                                Text(text = "Go to secound screen")
                            }
                        }
                    }

                    composable("Screen2"){
                        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                            var text by remember {
                                mutableStateOf("")
                            }
                            Text(text = "Screen2")
                            OutlinedTextField(value = text, 
                                onValueChange = {text = it})
                            Button(onClick = { navController.navigate("Screen1")
                                                navController.currentBackStackEntry
                                                    ?.savedStateHandle
                                                    ?.set("my_text", text)}) {

                                Text(text = "Apply")
                            }
                    }}
                }
            }
        }
    }
}