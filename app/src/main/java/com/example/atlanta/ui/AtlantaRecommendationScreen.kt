package com.example.atlanta.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.atlanta.data.Category
import com.example.atlanta.data.Recommendation
import com.example.atlanta.data.local.LocalRecommendationsDataProvider
import com.example.atlanta.ui.theme.AtlantaTheme


@Composable
fun RecommendationList(
    viewModel: AtlantaViewModel = viewModel(),
    selectedCategory: Category,
    onClick: (Recommendation?) -> Unit,
    modifier: Modifier = Modifier
) {
    val filteredRecommendations =
        LocalRecommendationsDataProvider.allRecommendations.filter { it.category == selectedCategory }

    LazyColumn {
        items(filteredRecommendations) { recommendation ->
            RecommendationCard(
                recommendation = recommendation,
                onClick = onClick,
                onViewModelClick = { viewModel.updateRecommendation(recommendation) }
            )
        }
    }
}

@Composable
fun RecommendationCard(
    onViewModelClick: (Recommendation?) -> Unit,
    recommendation: Recommendation,
    onClick: (Recommendation?) -> Unit,
    modifier: Modifier = Modifier
) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black),
        modifier = Modifier
            .padding(bottom = 24.dp)
            .fillMaxWidth()
            .clickable {
        onViewModelClick(recommendation)
        onClick(recommendation)
    }

    ) {
        Row(modifier = modifier
            .padding(horizontal = 5.dp, vertical = 20.dp)
            .height(56.dp)
        ) {
            Image(
                painter = painterResource(recommendation.avatar),
                contentScale = ContentScale.FillBounds,
                contentDescription = stringResource(recommendation.name),
                modifier = modifier
                    .aspectRatio(16f/9f)
                    .width(20.dp)
            )
            Spacer(modifier = modifier.width(20.dp))
            Text(
                stringResource(recommendation.name),
                fontSize = 20.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier
//                    Modifier.fillMaxWidth() ensures that the text takes up the full width of its container, and Modifier.wrapContentHeight() makes the text take only the necessary vertical space. Finally, Modifier.align(Alignment.CenterVertically) centers the text vertically within its container.
                    .fillMaxWidth()
                    .wrapContentHeight().then(Modifier.align(Alignment.CenterVertically))

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecommendationScreenPreview() {
    AtlantaTheme {
        RecommendationList(selectedCategory = Category.MUSEUM, onClick = {Category.COFFEE})
    }
}