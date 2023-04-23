package com.yanyan.github_user

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yanyan.github_user.domain.User
import com.yanyan.github_user.presentation.DetailScreen
import com.yanyan.github_user.presentation.HomeScreen
import com.yanyan.github_user.ui.theme.GithubuserTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubuserTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
                        composable(route= Screen.HomeScreen.route){
                            HomeScreen(navController)
                        }
                        composable(route= Screen.DetailScreen.route+"/{id}/{name}",
                        arguments = listOf(
                            navArgument("id"){type= NavType.StringType},
                            navArgument("name"){type= androidx.navigation.NavType.StringType}
                        )
                            ){
                            val id = it.arguments?.getString("id")
                            val name = it.arguments?.getString("name")
                            DetailScreen(
                                navController,
                                User("",name,"")
                            )
                        }
                    }
                }
            }
        }
    }
}

sealed class Screen(val route:String){
    object HomeScreen:Screen("home_screen")
    object DetailScreen:Screen("detail_screen")
}