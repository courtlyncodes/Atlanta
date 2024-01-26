package com.example.atlanta.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.atlanta.data.Category
import com.example.atlanta.data.Recommendation
import com.example.atlanta.data.local.LocalRecommendationsDataProvider
import com.example.atlanta.ui.theme.AtlantaTheme

@Composable
fun DetailsScreen(
    recommendation: Recommendation,
    modifier: Modifier = Modifier){

    val viewModel: RecommendationViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    LazyColumn {
        item {
            Text(stringResource(uiState.currentRecommendation.name))
        }
        item {
            Image(
                painter = painterResource(uiState.currentRecommendation.avatar),
                contentDescription = stringResource(uiState.currentRecommendation.name))
        }
        item { Spacer(modifier = modifier.height(32.dp)) }
        item {
            Text(stringResource(uiState.currentRecommendation.description))
        }
    }
}

@Preview
@Composable
fun DetailsScreenPreview(){
    AtlantaTheme {
        val selectedCategory = Category.COFFEE
        val recommendation = LocalRecommendationsDataProvider.allRecommendations.first { it.category == selectedCategory }
        DetailsScreen(recommendation = recommendation)
    }
}