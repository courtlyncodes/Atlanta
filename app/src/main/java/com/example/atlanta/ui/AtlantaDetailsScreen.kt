package com.example.atlanta.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.atlanta.data.Category
import com.example.atlanta.data.Recommendation
import com.example.atlanta.data.local.LocalRecommendationsDataProvider
import com.example.atlanta.ui.theme.AtlantaTheme

@Composable
fun DetailsScreen(
    recommendation: Recommendation?,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        item {
            if (recommendation != null) {
                Text(
                    stringResource(recommendation.name),
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 16.dp)
                    )
            }
        }
        item {
            if (recommendation != null) {
                Image(
                    painter = painterResource(recommendation.avatar),
                    contentDescription = stringResource(recommendation.name),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .aspectRatio(16f/9f)
                        .padding(horizontal = 20.dp)
                )
            }
        }
        item { Spacer(modifier = modifier.height(32.dp)) }
        item {
            if (recommendation != null) {
                Text(
                    stringResource(recommendation.description),
                    textAlign = TextAlign.Center,
                    fontSize = 17.sp,
                    lineHeight = 1.5.em,
                    modifier = modifier
                        .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    AtlantaTheme {
        DetailsScreen(recommendation = LocalRecommendationsDataProvider.allRecommendations.firstOrNull() { it.id == 17 })
    }
}