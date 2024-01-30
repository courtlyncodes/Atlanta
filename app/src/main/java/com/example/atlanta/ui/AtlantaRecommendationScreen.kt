package com.example.atlanta.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.lifecycle.viewmodel.compose.viewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendationScreen(
    viewModel: RecommendationViewModel = viewModel(),
    selectedCategory: Category,
    onClick: (Recommendation?) -> Unit,
//    modifier: Modifier = Modifier
) {

    val filteredRecommendations =
        LocalRecommendationsDataProvider.allRecommendations.filter { it.category == selectedCategory }
//    Scaffold(topBar =
//    {
//        CenterAlignedTopAppBar(title = {
//            Text(stringResource(LocalRecommendationsDataProvider.allRecommendations.first { it.category == selectedCategory }.categoryName))
//        })
//    }
//    ) {
        LazyColumn(/*modifier = Modifier.padding(it)*/) {
            items(filteredRecommendations) { recommendation ->
                RecommendationCard(
                    recommendation = recommendation,
                    onClick = onClick,
//                    viewModel = viewModel
                    onViewModelClick = { viewModel.updateRecommendation(recommendation) }
                )
            }
        }
    }
//}

@Composable
fun RecommendationCard(
//    viewModel: RecommendationViewModel,
    onViewModelClick: (Recommendation?) -> Unit,
    recommendation: Recommendation,
    onClick: (Recommendation?) -> Unit,
    modifier: Modifier = Modifier
) {

    Card(modifier = Modifier.clickable {
//        viewModel.updateRecommendation(recommendation)
        onViewModelClick(recommendation)
        onClick(recommendation)
    }

    ) {
        Row(modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
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
