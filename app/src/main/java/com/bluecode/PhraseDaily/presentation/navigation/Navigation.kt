package com.bluecode.PhraseDaily.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bluecode.PhraseDaily.presentation.homeScreen.HomeScreen
import com.bluecode.PhraseDaily.presentation.mainScreen.MainScreen
import kotlinx.serialization.Serializable


//Argumentos
@Serializable
object SplashScreen

@Serializable
object MainScreenObj

@Serializable
object LoginScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainScreenObj
    ) {

        composable<MainScreenObj> {
           MainScreen()
        }


    }
}