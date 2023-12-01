package com.nav.controllerwithdata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nav.controllerwithdata.screens.Screen1
import com.nav.controllerwithdata.screens.Screen2
import com.nav.controllerwithdata.ui.theme.NavControllerWithDataTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavControllerWithDataTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "Screen1") {
                    composable("Screen1") {
                        entry -> val text = entry.savedStateHandle.get<String>("my_text")
                        Screen1(navController = navController, text)
                    }
                    composable("Screen2") {
                        Screen2(navController = navController)
                    }
                }
            }
        }
    }
}

