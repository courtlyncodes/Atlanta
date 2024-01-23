package com.example.atlanta.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.atlanta.R
import com.example.atlanta.data.Category
import com.example.atlanta.data.Recommendation
import com.example.atlanta.data.local.LocalRecommendationsDataProvider
import com.example.atlanta.ui.theme.AtlantaTheme

@Composable
fun DetailsScreen(
    recommendation: Recommendation,
    modifier: Modifier = Modifier){
    LazyColumn() {
        item {
            Image(
                painter = painterResource(recommendation.avatar),
                contentDescription = stringResource(recommendation.name))
        }
        item { Spacer(modifier = modifier.height(32.dp)) }
        item {
            Text(stringResource(recommendation.description))
        }
    }
}

@Preview
@Composable
fun DetailsScreenPreview(){
    AtlantaTheme {
        val selectedCategory = Category.COFFEE
        val recommendation = LocalRecommendationsDataProvider.allRecommendations.first() { it.category == selectedCategory }
        DetailsScreen(recommendation = recommendation)
    }
}