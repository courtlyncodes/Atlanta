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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.atlanta.data.Category
import com.example.atlanta.data.Recommendation
import com.example.atlanta.data.local.LocalRecommendationsDataProvider


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendationScreen(
    selectedCategory: Category,
    onClick: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
){
    Scaffold (topBar =
    { CenterAlignedTopAppBar(title = {
        Text(stringResource(LocalRecommendationsDataProvider.allRecommendations.first { it.category == selectedCategory }.categoryName))
    }) }
    ) {
        Column(modifier = Modifier.padding(it)) {
            RecommendationList(/*navController = navController,*/ selectedCategory = selectedCategory, onClick = onClick)
        }
    }

}
@Composable
fun RecommendationList(
    selectedCategory: Category,
    onClick: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
) {
    val filteredRecommendations =
        LocalRecommendationsDataProvider.allRecommendations.filter { it.category == selectedCategory }
    LazyColumn{
        items(filteredRecommendations) { recommendation ->
                RecommendationCard(/*navController = navController*/ recommendation = recommendation, onClick = onClick)
        }
    }
}
@Composable
fun RecommendationCard(
    recommendation: Recommendation,
    onClick: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
){
//    var selectedRecommendation by remember { mutableStateOf(recommendation) }

    Card(modifier = Modifier.clickable { onClick(recommendation)
    /*navController.navigate(AtlantaScreen.DETAILS.name)*/ }) {
        Row (modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)){
            Image(
                painter = painterResource(recommendation.avatar),
                contentDescription = stringResource(recommendation.name),
                modifier = modifier.size(76.dp)
            )
            Spacer(modifier = modifier.width(20.dp))
            Text(stringResource(recommendation.name))
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun RecommendationScreenPreview() {
    AtlantaTheme {
        val selectedCategory = Category.COFFEE
        val navController = rememberNavController()
        RecommendationScreen(navController = navController, selectedCategory = selectedCategory)
    }
}*/

