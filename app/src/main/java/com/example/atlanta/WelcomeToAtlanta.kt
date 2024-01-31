package com.example.atlanta

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.atlanta.data.Category
import com.example.atlanta.ui.CategoryList
import com.example.atlanta.ui.DetailsScreen
import com.example.atlanta.ui.HomeScreen
import com.example.atlanta.ui.RecommendationScreen
import com.example.atlanta.ui.RecommendationViewModel
import com.example.atlanta.utils.AtlantaContentType

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
    windowSize: WindowWidthSizeClass,
    viewModel: RecommendationViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val contentType: AtlantaContentType
    when(windowSize) {
        WindowWidthSizeClass.Compact -> contentType = AtlantaContentType.ListOnly
        WindowWidthSizeClass.Expanded -> contentType = AtlantaContentType.ListAndDetail
    }

    HomeScreen(
        windowSize = ,
        contentType = ,
        onClick = ,
        selectedCategory = ,
        onCardClick =
    )

    NavHost(
        navController = navController,
        startDestination = AtlantaScreen.HOME.name
    ) {
        composable(route = AtlantaScreen.HOME.name) {
            CategoryList(onClick = { category ->
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
                onClick = {
                    if (it != null) {
                        viewModel.updateRecommendation(it)
                    }
                    navController.navigate(AtlantaScreen.DETAILS.name)
                })
        }
        composable(route = AtlantaScreen.DOG_PARK.name) {
            RecommendationScreen(selectedCategory = Category.DOG_PARK,
                onClick = {
                    if (it != null) {
                        viewModel.updateRecommendation(it)
                    }
                    navController.navigate(AtlantaScreen.DETAILS.name)
                })
        }
        composable(route = AtlantaScreen.MUSEUM.name) {
            RecommendationScreen(selectedCategory = Category.MUSEUM,
                onClick = {
                    if (it != null) {
                        viewModel.updateRecommendation(it)
                    }
                    navController.navigate(AtlantaScreen.DETAILS.name)
                })
        }
        composable(route = AtlantaScreen.PIZZA.name) {
            RecommendationScreen(selectedCategory = Category.PIZZA,
                onClick = {
                    if (it != null) {
                        viewModel.updateRecommendation(it)
                    }
                    navController.navigate(AtlantaScreen.DETAILS.name)
                })
        }
        composable(route = AtlantaScreen.SHOPPING_CENTER.name) {
            RecommendationScreen(selectedCategory = Category.SHOPPING_CENTER,
                onClick = {
                    if (it != null) {
                        viewModel.updateRecommendation(it)
                    }
                    navController.navigate(AtlantaScreen.DETAILS.name)
                })
        }
        composable(route = AtlantaScreen.DETAILS.name) {
            val selectedRecommendation by viewModel.recommendation.collectAsState()
            DetailsScreen(recommendation = selectedRecommendation)
        }
    }
}
