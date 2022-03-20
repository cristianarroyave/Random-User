package com.example.cleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint

object Destinations {
    const val LIST_SCREEN = "LIST_SCREEN"
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colors.background) {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Destinations.LIST_SCREEN
                ){
                    composable(Destinations.LIST_SCREEN){
                        Screen(navController = navController)
                    }
                }
            }
        }
    }
}


