package com.example.atlanta.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.atlanta.data.local.Category
import com.example.atlanta.data.local.LocalCategoryDataProvider
import com.example.atlanta.ui.theme.AtlantaTheme

@Composable
fun CategoryCard(category: Category, modifier: Modifier = Modifier) {
        Card {
            Row {
                Image(
                    painter = painterResource(category.icon),
                    contentDescription = category.name + " icon",
                    modifier = modifier.size(32.dp)
                )
                Text(text = category.name)
            }
    }
}

@Composable
fun CategoryList(categories: List<Category>, modifier: Modifier = Modifier){
    Column {
        categories.forEach { category ->
            CategoryCard(category = category, modifier = Modifier)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CategoryCardPreview() {
    AtlantaTheme {
        val categoryList = LocalCategoryDataProvider.allCategories
        CategoryList(categories = categoryList, modifier = Modifier)
    }
}