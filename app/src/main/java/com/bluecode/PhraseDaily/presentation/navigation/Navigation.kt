package com.bluecode.PhraseDaily.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bluecode.PhraseDaily.presentation.homeScreen.HomeScreen
import com.bluecode.PhraseDaily.presentation.mainScreen.MainScreen
import com.bluecode.PhraseDaily.presentation.startScreen.StartScren
import kotlinx.serialization.Serializable


//Argumentos
@Serializable
object SplashScreen

@Serializable
object MainScreenObj

@Serializable
object StartScreenObj

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = StartScreenObj
    ) {

        composable<StartScreenObj> {
           StartScren {
               navController.navigate(MainScreenObj)
           }
        }

        composable<MainScreenObj> {
            MainScreen()
        }


    }
}