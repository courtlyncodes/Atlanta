package com.example.atlanta

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.atlanta.data.Category
import com.example.atlanta.data.Recommendation
import com.example.atlanta.ui.DetailsScreen
import com.example.atlanta.ui.HomeScreen
import com.example.atlanta.ui.RecommendationScreen

enum class AtlantaScreen(/*@StringRes val title: Int*/) {
    HOME/*(title = R.string.app_name)*/,
    COFFEE/*(title = R.string.coffee)*/,
    DOG_PARK/*(title = R.string.dog_park)*/,
    MUSEUM/*(title = R.string.museum)*/,
    PIZZA/*(title = R.string.pizza)*/,
    SHOPPING_CENTER/*(title = R.string.shopping)*/,
    DETAILS
}

@Composable
fun AtlantaApp(
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = AtlantaScreen.HOME.name
    ) {
        composable(route = AtlantaScreen.HOME.name) {
            HomeScreen(navController = navController)
        }
        composable(route = AtlantaScreen.COFFEE.name) {
           RecommendationScreen(navController = navController, selectedCategory = Category.COFFEE)
        }
        composable(route = AtlantaScreen.DOG_PARK.name) {
            RecommendationScreen(navController = navController, selectedCategory = Category.DOG_PARK)
        }
        composable(route = AtlantaScreen.MUSEUM.name) {
            RecommendationScreen(navController = navController, selectedCategory = Category.MUSEUM)
        }
        composable(route = AtlantaScreen.PIZZA.name) {
            RecommendationScreen(navController = navController, selectedCategory = Category.PIZZA)
        }
        composable(route = AtlantaScreen.SHOPPING_CENTER.name) {
            RecommendationScreen(navController = navController, selectedCategory = Category.SHOPPING_CENTER)
        }
        composable(route = AtlantaScreen.DETAILS.name) {
            DetailsScreen(recommendation = recommendation)
        }
    }
}