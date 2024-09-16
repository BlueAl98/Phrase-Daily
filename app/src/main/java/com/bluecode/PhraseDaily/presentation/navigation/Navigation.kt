package com.bluecode.PhraseDaily.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bluecode.PhraseDaily.presentation.homeScreen.HomeScreen
import kotlinx.serialization.Serializable


//Argumentos
@Serializable
object SplashScreen

@Serializable
object HomeScreen

@Serializable
object LoginScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeScreen
    ) {

        composable<HomeScreen> {
           HomeScreen()
        }


    }
}