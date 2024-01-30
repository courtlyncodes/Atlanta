package com.example.atlanta.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.atlanta.data.Category
import com.example.atlanta.data.Recommendation
import com.example.atlanta.data.local.LocalRecommendationsDataProvider
import com.example.atlanta.ui.theme.AtlantaTheme

@Composable
fun HomeAndRecommendationView(
    windowSize: WindowWidthSizeClass,
    onClick: (Category) -> Unit,
    selectedCategory: Category,
    onCardClick: (Recommendation?) -> Unit,
    modifier: Modifier = Modifier
){
    Row {
        HomeScreen(onClick = onClick)
//        Spacer(modifier = modifier.weight(1f))
        RecommendationScreen(selectedCategory = selectedCategory, onClick = onCardClick)
    }
}

@Preview(showBackground = true, widthDp = 840)
@Composable
fun HomeAndRecommendationViewPreview(){
    AtlantaTheme {
        Surface {
            HomeAndRecommendationView(windowSize = WindowWidthSizeClass.Expanded, onClick = { Category.COFFEE }, selectedCategory = Category.COFFEE, onCardClick = { LocalRecommendationsDataProvider.allRecommendations.find { it.id == 1 }}, )
        }

    }
}