package com.example.atlanta

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

enum class AtlantaScreen/*(*//*@StringRes val title: Int*//*)*/ {
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
) {

    NavHost(
        navController = navController,
        startDestination = AtlantaScreen.HOME.name
    ) {
        composable(route = AtlantaScreen.HOME.name) {
            HomeScreen(onClick = { category ->
                run {
                    when (category) {
                        Category.COFFEE -> navController.navigate(AtlantaScreen.COFFEE.name)
                        Category.DOG_PARK -> navController.navigate(AtlantaScreen.DOG_PARK.name)
                        Category.MUSEUM -> navController.navigate(AtlantaScreen.MUSEUM.name)
                        Category.PIZZA -> navController.navigate(AtlantaScreen.PIZZA.name)
                        Category.SHOPPING_CENTER -> navController.navigate(AtlantaScreen.SHOPPING_CENTER.name)
                    }
                }
            })
        }
        composable(route = AtlantaScreen.COFFEE.name) {
            RecommendationScreen(selectedCategory = Category.COFFEE,
                onClick = { navController.navigate(AtlantaScreen.DETAILS.name) })
        }
        composable(route = AtlantaScreen.DOG_PARK.name) {
            RecommendationScreen(selectedCategory = Category.DOG_PARK,
                onClick = { AtlantaScreen.DETAILS.name })
        }
        composable(route = AtlantaScreen.MUSEUM.name) {
            RecommendationScreen(selectedCategory = Category.MUSEUM,
                onClick = { AtlantaScreen.DETAILS.name })
        }
        composable(route = AtlantaScreen.PIZZA.name) {
            RecommendationScreen(selectedCategory = Category.PIZZA,
                onClick = { AtlantaScreen.DETAILS.name })
        }
        composable(route = AtlantaScreen.SHOPPING_CENTER.name) {
            RecommendationScreen(selectedCategory = Category.SHOPPING_CENTER,
                onClick = { AtlantaScreen.DETAILS.name })
        }
//        composable(route = AtlantaScreen.DETAILS.name) {
//            DetailsScreen(recommendation = )
//        }
    }
}