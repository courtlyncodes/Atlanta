package com.example.atlanta.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
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
fun HomeScreen(categories: List<Category>) {
    Scaffold(topBar = {
        TopAppBar()
    }
    ) {
//        val categoryList = LocalCategoryDataProvider.allCategories
        Column( modifier = Modifier.padding(it)) {
            CategoryList(categories = categories)
        }
    }
}

@Composable
fun CategoryCard(category: Category, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.clickable { /*todo*/ }) {
        Row(modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
            Image(
                painter = painterResource(category.icon),
                contentDescription = category.name + " icon",
                modifier = modifier.size(32.dp)
            )
            Spacer(modifier = modifier.width(20.dp))
            Text(text = category.name)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = "Welcome to Atlanta")
        }
    )
}

@Composable
fun CategoryList(categories: List<Category>, modifier: Modifier = Modifier) {
            categories.forEach { category ->
                CategoryCard(category = category, modifier = Modifier)
            }
    }

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AtlantaTheme {
        val categoryList = LocalCategoryDataProvider.allCategories
        HomeScreen(categories = categoryList)
    }
}