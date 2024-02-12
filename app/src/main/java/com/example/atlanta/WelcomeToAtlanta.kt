package com.example.atlanta

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.atlanta.data.Category
import com.example.atlanta.ui.AtlantaViewModel
import com.example.atlanta.ui.CategoryList
import com.example.atlanta.ui.DetailsScreen
import com.example.atlanta.ui.HomeAndRecommendationView
import com.example.atlanta.ui.RecommendationList


enum class AtlantaScreen(@StringRes val title: Int) {
    LIST_AND_RECOMMENDATIONS(title = R.string.coffee),
    HOME(title = R.string.app_name),
    COFFEE(title = R.string.coffee),
    DOG_PARK(title = R.string.dog_park),
    MUSEUM(title = R.string.museum),
    PIZZA(title = R.string.pizza),
    SHOPPING_CENTER(title = R.string.shopping),
    DETAILS(title = R.string.more_info)
}

@Composable
fun AtlantaApp(
    windowSize: WindowWidthSizeClass,
    viewModel: AtlantaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.uiState.collectAsState()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AtlantaScreen.valueOf(
        backStackEntry?.destination?.route ?: AtlantaScreen.HOME.name
    )

    Scaffold(
        topBar = {
            AtlantaAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { it ->
        NavHost(
            navController = navController,
            modifier = Modifier.padding(it),
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
                                navController.navigate(AtlantaScreen.DOG_PARK.name)
                            }

                            Category.MUSEUM -> {
                                viewModel.updateCategory(Category.MUSEUM)
                                navController.navigate(AtlantaScreen.MUSEUM.name)
                            }

                            Category.PIZZA -> {
                                viewModel.updateCategory(Category.PIZZA)
                                navController.navigate(AtlantaScreen.PIZZA.name)
                            }

                            Category.SHOPPING_CENTER -> {
                                viewModel.updateCategory(Category.SHOPPING_CENTER)
                                navController.navigate(AtlantaScreen.SHOPPING_CENTER.name)
                            }
                        }
                    }
                })
            }
            composable(route = AtlantaScreen.COFFEE.name) {
                RecommendationList(selectedCategory = Category.COFFEE,
                    onClick = {
                        if (it != null) {
                            viewModel.updateRecommendation(it)
                        }
                        navController.navigate(AtlantaScreen.DETAILS.name)
                    })
            }
            composable(route = AtlantaScreen.DOG_PARK.name) {
                RecommendationList(selectedCategory = Category.DOG_PARK,
                    onClick = {
                        if (it != null) {
                            viewModel.updateRecommendation(it)
                        }
                        navController.navigate(AtlantaScreen.DETAILS.name)
                    })
            }
            composable(route = AtlantaScreen.MUSEUM.name) {
                RecommendationList(selectedCategory = Category.MUSEUM,
                    onClick = {
                        if (it != null) {
                            viewModel.updateRecommendation(it)
                        }
                        navController.navigate(AtlantaScreen.DETAILS.name)
                    })
            }
            composable(route = AtlantaScreen.PIZZA.name) {
                RecommendationList(selectedCategory = Category.PIZZA,
                    onClick = {
                        if (it != null) {
                            viewModel.updateRecommendation(it)
                        }
                        navController.navigate(AtlantaScreen.DETAILS.name)
                    })
            }
            composable(route = AtlantaScreen.SHOPPING_CENTER.name) {
                RecommendationList(selectedCategory = Category.SHOPPING_CENTER,
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
                    onClick = {
                        viewModel.updateCategory(it)
                        viewModel.updateRecommendation(null)
                    },
                    recommendation = uiState.recommendation,
                    selectedCategory = uiState.category,
                    onCardClick = {
                        if (it != null) {
                            viewModel.updateRecommendation(it)
                        }
                    }
                )
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AtlantaAppBar(
    currentScreen: AtlantaScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.Red
        ),
        modifier = modifier.padding(bottom = 5.dp),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.TwoTone.ArrowBack,
                        contentDescription = "back",
                        tint = Color.Red
                    )
                }
            }
        }
    )
}