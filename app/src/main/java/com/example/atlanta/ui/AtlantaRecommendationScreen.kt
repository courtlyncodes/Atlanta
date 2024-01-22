package com.example.atlanta.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.atlanta.data.Recommendation
import com.example.atlanta.data.local.Category
import com.example.atlanta.data.local.LocalCategoryDataProvider
import com.example.atlanta.data.local.LocalRecommendationsDataProvider
import com.example.atlanta.ui.theme.AtlantaTheme

//@Composable
//fun HomeScreen(categories: List<Category>) {
//    Scaffold(topBar = {
//        TopAppBar()
//    }
//    ) {
////        val categoryList = LocalCategoryDataProvider.allCategories
//        Column(modifier = Modifier.padding(it)) {
//            CategoryList(categories = categories)
//        }
//    }
//}

@Composable
fun RecommendationCard(recommendation: Recommendation, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.clickable { /*todo*/ }) {
        Row(modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
            Image(
                painter = painterResource(recommendation.avatar),
                contentDescription = "${recommendation.name} icon",
                modifier = modifier.size(32.dp)
            )
            Spacer(modifier = modifier.width(20.dp))
            Text(text = stringResource(recommendation.name))
        }
    }
}

//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun TopAppBar(modifier: Modifier = Modifier) {
//    CenterAlignedTopAppBar(
//        title = {
//            Text(text = "Welcome to Atlanta")
//        }
//    )
//}
//
@Composable
fun RecommendationList(recommendations: List<Recommendation>) { //filter the recommendations by category
    LazyColumn() {
        item{

        }
    }
//            (categories: List<Category>, modifier: Modifier = Modifier) {
//    categories.forEach { category ->
//        CategoryCard(category = category, modifier = Modifier)
//    }
}

//@Preview(showBackground = true)
//@Composable
//fun RecommendationScreenPreview() {
//    AtlantaTheme {
//        val recommendationList = LocalRecommendationsDataProvider.coffeeRecommendations
//        RecommendationScreen(categories = recommendationList)
//    }
//}

