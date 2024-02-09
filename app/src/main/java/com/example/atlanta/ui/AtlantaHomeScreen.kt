package com.example.atlanta.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.atlanta.R
import com.example.atlanta.data.AtlantaUiState
import com.example.atlanta.data.Category
import com.example.atlanta.data.Recommendation

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
    atlantaUiState: AtlantaUiState,
    onClick: (Category) -> Unit,
    selectedCategory: Category,
    recommendation: Recommendation? = null,
    onCardClick: (Recommendation?) -> Unit,
    modifier: Modifier = Modifier
) {
    val navigationItemContentList = listOf(
        NavigationItemContent(
            category = Category.COFFEE,
            icon = painterResource(id = R.drawable.coffee_icon),
            label = stringResource(id = R.string.coffee),
        ),
        NavigationItemContent(
            category = Category.DOG_PARK,
            icon = painterResource(id = R.drawable.dog_icon),
            label = stringResource(id = R.string.dog_park),
        ),
        NavigationItemContent(
            category = Category.MUSEUM,
            icon = painterResource(id = R.drawable.museum_icon),
            label = stringResource(id = R.string.museum),
        ),
        NavigationItemContent(
            category = Category.PIZZA,
            icon = painterResource(id = R.drawable.pizza_icon),
            label = stringResource(id = R.string.pizza),
        ),
        NavigationItemContent(
            category = Category.SHOPPING_CENTER,
            icon = painterResource(id = R.drawable.mall_icon),
            label = stringResource(id = R.string.shopping),
        ),

        )
    PermanentNavigationDrawer(
        drawerContent = {
            PermanentDrawerSheet(Modifier.width(240.dp)) {
                Spacer(Modifier.height(12.dp))
                NavigationDrawerContent(
                    selectedDestination = atlantaUiState.category,
                    onClick = onClick,
                    navigationItemContentList = navigationItemContentList
                )
            }
        },
        content =
        {
            if (recommendation != null) {
                DetailsScreen(recommendation = recommendation)
            } else {
                RecommendationScreen(
                    selectedCategory = selectedCategory,
                    onClick = onCardClick
                )
            }
        })
}

@Composable
private fun NavigationDrawerContent(
    selectedDestination: Category,
    onClick: ((Category) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    for (navItem in navigationItemContentList) {
        NavigationDrawerItem(
            selected = selectedDestination == navItem.category,
            label = {
                Text(
                    text = navItem.label,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            },
            icon = {
                Icon(painter = navItem.icon, contentDescription = "category icon")
            },
            onClick = { onClick(navItem.category) }
        )
    }
}

private data class NavigationItemContent(
    val category: Category,
    val icon: Painter,
    val label: String
)