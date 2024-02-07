package com.example.atlanta.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.atlanta.AtlantaScreen
import com.example.atlanta.R
import com.example.atlanta.data.Category
import com.example.atlanta.data.Recommendation
import com.example.atlanta.ui.theme.AtlantaTheme
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.ui.res.stringResource

@Composable
fun CategoryList(
    onClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        Card(modifier = Modifier.clickable {
            onClick(Category.COFFEE)
        }) {
            Row(modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
                Image(
                    painter = painterResource(R.drawable.coffee_icon),
                    contentDescription = "coffee icon",
                    modifier = modifier.size(32.dp)
                )
                Spacer(modifier = modifier.width(20.dp))
                Text(text = "Coffee Shops")
            }
        }
        Card(modifier = Modifier.clickable {
            onClick(Category.DOG_PARK)
        }) {
            Row(modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
                Image(
                    painter = painterResource(R.drawable.dog_icon),
                    contentDescription = "dog icon",
                    modifier = modifier.size(32.dp)
                )
                Spacer(modifier = modifier.width(20.dp))
                Text(text = "Dog Parks")
            }
        }
        Card(modifier = Modifier.clickable {
            onClick(Category.MUSEUM)
        }) {
            Row(modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
                Image(
                    painter = painterResource(R.drawable.museum_icon),
                    contentDescription = "museum icon",
                    modifier = modifier.size(32.dp)
                )
                Spacer(modifier = modifier.width(20.dp))
                Text(text = "Museums")
            }
        }
        Card(modifier = Modifier.clickable {
            onClick(Category.PIZZA)
        }) {
            Row(modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
                Image(
                    painter = painterResource(R.drawable.pizza_icon),
                    contentDescription = "Pizza icon",
                    modifier = modifier.size(32.dp)
                )
                Spacer(modifier = modifier.width(20.dp))
                Text(text = "Pizza Restaurants")
            }
        }
        Card(modifier = Modifier.clickable {
            onClick(Category.SHOPPING_CENTER)
        }) {
            Row(modifier = modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
                Image(
                    painter = painterResource(R.drawable.mall_icon),
                    contentDescription = "shopping icon",
                    modifier = modifier.size(32.dp)
                )
                Spacer(modifier = modifier.width(20.dp))
                Text(text = "Shopping Centers")
            }
        }
    }
}


@Composable
fun HomeAndRecommendationView(
    onClick: (Category) -> Unit,
    selectedCategory: Category,
    recommendation: Recommendation? = null,
    onCardClick: (Recommendation?) -> Unit,
    modifier: Modifier = Modifier
) {
    PermanentNavigationDrawer(
        drawerContent = {
            PermanentDrawerSheet(Modifier.width(240.dp)) {
                Spacer(Modifier.height(12.dp))
                NavigationDrawerItem(
                    icon = { R.drawable.coffee_icon },
                    label = { Text(stringResource(R.string.coffee)) },
                    selected = false,
                    onClick = { Category.COFFEE }
                )
                NavigationDrawerItem(
                    icon = {R.drawable.dog_icon},
                    label = { Text(stringResource(R.string.dog_park)) },
                    selected = false,
                    onClick = { Category.DOG_PARK })
                NavigationDrawerItem(
                    icon = {R.drawable.museum_icon},
                    label = { Text(stringResource(R.string.museum)) },
                    selected = false,
                    onClick = { Category.MUSEUM })
                NavigationDrawerItem(
                    icon = {R.drawable.pizza_icon},
                    label = { Text(stringResource(R.string.pizza)) },
                    selected = false,
                    onClick = { Category.PIZZA })
                NavigationDrawerItem(
                    icon = {R.drawable.mall_icon},
                    label = { Text(stringResource(R.string.shopping)) },
                    selected = false,
                    onClick = { Category.SHOPPING_CENTER })
            }
        },
content =
{
    Row() {
        CategoryList(onClick = onClick)
        if (recommendation != null) {
            DetailsScreen(recommendation = recommendation)
        } else {
            RecommendationScreen(
                selectedCategory = selectedCategory,
                onClick = onCardClick
            )
        }
    }
})
    }
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AtlantaTheme {
        val onClick: (Category) -> Unit = {}
        CategoryList(onClick = onClick)
    }
}
