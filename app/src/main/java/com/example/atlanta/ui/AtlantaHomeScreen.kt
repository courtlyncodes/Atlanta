package com.example.atlanta.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.atlanta.AtlantaScreen
import com.example.atlanta.R
import com.example.atlanta.data.AtlantaUiState
import com.example.atlanta.data.Category
import com.example.atlanta.data.Recommendation


@Composable
fun NavigationContent(modifier: Modifier = Modifier) {

}

@Composable
fun CategoryList(
    onClick: (Category) -> Unit, modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        CategoryCard(
            onClick,
            Category.COFFEE,
            painterResource(R.drawable.coffee_icon),
            stringResource(R.string.coffee_icon),
            stringResource(id = R.string.coffee)
        )
        CategoryCard(
            onClick,
            Category.DOG_PARK,
            painterResource(R.drawable.dog_icon),
            stringResource(R.string.dog_icon),
            stringResource(R.string.dog_park)
        )
        CategoryCard(
            onClick,
            Category.MUSEUM,
            painterResource(R.drawable.museum_icon),
            stringResource(R.string.museum_icon),
            stringResource(R.string.museum)
        )
        CategoryCard(
            onClick,
            Category.PIZZA,
            painterResource(R.drawable.pizza_icon),
            stringResource(R.string.pizza_icon),
            stringResource(R.string.pizza)
        )
        CategoryCard(
            onClick,
            Category.SHOPPING_CENTER,
            painterResource(R.drawable.mall_icon),
            stringResource(R.string.shopping_icon),
            stringResource(R.string.shopping)
        )
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
//    PermanentNavigationDrawer(
//        drawerContent = {
//            PermanentDrawerSheet(Modifier.width(240.dp)) {
//                Spacer(Modifier.height(12.dp))
//                NavigationDrawerContent(
//                    selectedDestination = atlantaUiState.category,
//                    onClick = onClick,
//                    navigationItemContentList = navigationItemContentList
//                )
//            }
//        },
//        content =
//        {
//            if (recommendation != null) {
//                DetailsScreen(recommendation = recommendation)
//            } else {
//                RecommendationScreen(
//                    selectedCategory = selectedCategory,
//                    onClick = onCardClick
//                )
//            }
//        })
}

//@Composable
//private fun NavigationDrawerContent(
//    selectedDestination: Category,
//    onClick: ((Category) -> Unit),
//    navigationItemContentList: List<NavigationItemContent>,
//    modifier: Modifier = Modifier
//) {
//    for (navItem in navigationItemContentList) {
//        NavigationDrawerItem(
//            selected = selectedDestination == navItem.category,
//            label = {
//                Text(
//                    text = navItem.label,
//                    modifier = Modifier.padding(horizontal = 16.dp)
//                )
//            },
//            icon = {
//                Icon(painter = navItem.icon, contentDescription = "category icon")
//            },
//            onClick = { onClick(navItem.category) }
//        )
//    }
//}

@Composable
fun CategoryCard(
    onClick: (Category) -> Unit,
    category: Category,
    image: Painter,
    imageDescription: String,
    text: String,
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
            .clickable { onClick(category) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(horizontal = 10.dp, vertical = 10.dp)
        ) {
            Image(
                painter = image,
                contentDescription = imageDescription,
                modifier = modifier.size(64.dp)
            )
            Spacer(modifier = modifier.width(20.dp))
            Text(
                text = text,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                lineHeight = 24.sp
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AtlantaAppBar(
    currentScreen: AtlantaScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.Red
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.TwoTone.ArrowBack,
                        contentDescription = "back"
                    )
                }
            }
        }
    )
}

private data class NavigationItemContent(
    val category: Category, val icon: Painter, val label: String
)