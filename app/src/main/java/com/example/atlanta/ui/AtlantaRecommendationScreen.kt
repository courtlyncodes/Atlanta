package com.example.atlanta.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.atlanta.data.Category
import com.example.atlanta.data.Recommendation
import com.example.atlanta.data.local.LocalRecommendationsDataProvider


@Composable
fun RecommendationScreen(
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
    Spacer(modifier = modifier.height(10.dp))
    Card(
        colors = CardDefaults.cardColors(
            Color(152, 190, 245, 255)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
        onViewModelClick(recommendation)
        onClick(recommendation)
    }

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
            Image(
                painter = painterResource(recommendation.avatar),
                contentDescription = stringResource(recommendation.name),
                modifier = modifier.size(76.dp)
            )
            Spacer(modifier = modifier.width(20.dp))
            Text(
                stringResource(recommendation.name),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                lineHeight = 24.sp)
        }
    }
}

//@Composable
//fun CategoryCard(
//    onClick: (Category) -> Unit,
//    category: Category,
//    image: Painter,
//    imageDescription: String,
//    text: String,
//    modifier: Modifier = Modifier
//) {
//    Spacer(modifier = modifier.height(10.dp))
//    Card(
//        colors = CardDefaults.cardColors(
//            Color(152, 190, 245, 255)
//        ),
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp)
//            .clickable { onClick(category) }
//    ) {
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = modifier
//                .padding(horizontal = 10.dp, vertical = 10.dp)
//        ) {
//            Image(
//                painter = image,
//                contentDescription = imageDescription,
//                modifier = modifier.size(64.dp)
//            )
//            Spacer(modifier = modifier.width(20.dp))
//            Text(
//                text = text,
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
//                fontFamily = FontFamily.Monospace,
//                textAlign = TextAlign.Center,
//                lineHeight = 24.sp
//            )
//        }
//    }
//}