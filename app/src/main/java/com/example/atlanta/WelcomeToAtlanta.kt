package com.example.atlanta

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.atlanta.data.Category
import com.example.atlanta.ui.HomeScreen
import com.example.atlanta.ui.RecommendationScreen
import com.example.atlanta.ui.ScreenCategories

//enum class AtlantaScreen(@StringRes val title: Int) {
//    Home(title = R.string.app_name),
//    Coffee(title = R.string.coffee),
//    DogPark(title = R.string.dog_park),
//    Museum(title = R.string.museum),
//    Pizza(title = R.string.pizza),
//    ShoppingCenter(title = R.string.shopping)
//}

@Composable
fun AtlantaApp(
    selectedCategory: Category,
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = ScreenCategories.HOME.name,
        modifier = modifier
    ) {
        composable(route = ScreenCategories.HOME.name) {
            HomeScreen()
        }
        composable(route = ScreenCategories.COFFEE.name) {
           RecommendationScreen(selectedCategory = selectedCategory)
        }
        composable(route = ScreenCategories.DOG_PARK.name) {
            RecommendationScreen(selectedCategory = selectedCategory)
        }
        composable(route = ScreenCategories.MUSEUM.name) {
            RecommendationScreen(selectedCategory = selectedCategory)
        }
        composable(route = ScreenCategories.PIZZA.name) {
            RecommendationScreen(selectedCategory = selectedCategory)
        }
        composable(route = ScreenCategories.SHOPPING_CENTER.name) {
            RecommendationScreen(selectedCategory = selectedCategory)
        }
    }
}