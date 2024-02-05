package com.example.atlanta

import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.atlanta.ui.AtlantaViewModel
import com.example.atlanta.ui.CategoryList
import com.example.atlanta.ui.DetailsScreen
import com.example.atlanta.ui.HomeAndRecommendationView
import com.example.atlanta.ui.RecommendationAndDetailsView
import com.example.atlanta.ui.RecommendationScreen

enum class AtlantaScreen/*(*//*@StringRes val title: Int*//*)*/ {
    LIST_AND_RECOMMENDATIONS,
    RECOMMENDATIONS_AND_DETAILS,
    HOME/*(title = R.string.app_name)*/,
    COFFEE/*(title = R.string.coffee)*/,
    DOG_PARK/*(title = R.string.dog_park)*/,
    MUSEUM/*(title = R.string.museum)*/,
    PIZZA/*(title = R.string.pizza)*/,
    SHOPPING_CENTER/*(title = R.string.shopping)*/,
    DETAILS
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AtlantaApp(
    windowSize: WindowWidthSizeClass,
    viewModel: AtlantaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = if (windowSize == WindowWidthSizeClass.Expanded) AtlantaScreen.LIST_AND_RECOMMENDATIONS.name else AtlantaScreen.HOME.name
    ) {
        composable(route = AtlantaScreen.HOME.name) {
            CategoryList(onClick = { category ->
                run {
                    when (category) {
                        Category.COFFEE -> {
                            viewModel.updateCategory(Category.COFFEE)
                            navController.navigate(AtlantaScreen.COFFEE.name)
                        }

                        Category.DOG_PARK -> {
                            viewModel.updateCategory(Category.DOG_PARK)
                            navController.navigate(AtlantaScreen.COFFEE.name)
                        }

                        Category.MUSEUM -> {
                            viewModel.updateCategory(Category.MUSEUM)
                            navController.navigate(AtlantaScreen.COFFEE.name)
                        }

                        Category.PIZZA -> {
                            viewModel.updateCategory(Category.PIZZA)
                            navController.navigate(AtlantaScreen.COFFEE.name)
                        }

                        Category.SHOPPING_CENTER -> {
                            viewModel.updateCategory(Category.SHOPPING_CENTER)
                            navController.navigate(AtlantaScreen.COFFEE.name)
                        }
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
            DetailsScreen(recommendation = uiState.recommendation)
        }
        composable(route = AtlantaScreen.LIST_AND_RECOMMENDATIONS.name) {
            HomeAndRecommendationView(
                windowSize = windowSize,
                onClick = { viewModel.updateCategory(it) },
                selectedCategory = uiState.category,
                onCardClick = {
                    if (it != null) {
                        viewModel.updateRecommendation(it)
                    }
                    navController.navigate(AtlantaScreen.RECOMMENDATIONS_AND_DETAILS.name)
                }
            )
        }
        composable(route = AtlantaScreen.RECOMMENDATIONS_AND_DETAILS.name) {
            RecommendationAndDetailsView(
                onClick = {
                    if (it != null) {
                        viewModel.updateRecommendation(it)
                    }
                },
                selectedCategory = uiState.category,
                recommendation = uiState.recommendation
            )
        }
    }
}

