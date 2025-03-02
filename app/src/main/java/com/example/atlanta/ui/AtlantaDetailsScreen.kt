package com.example.atlanta.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.atlanta.R
import com.example.atlanta.data.Category
import com.example.atlanta.data.Recommendation

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
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxWidth().padding(top = 10.dp)
                )
            }
        }
        item {
            if (recommendation != null) {
                Image(
                    painter = painterResource(recommendation.avatar),
                    contentDescription = stringResource(recommendation.name),
                    alignment = Alignment.Center,
                    modifier = modifier.padding(10.dp).size(500.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
        item {
            if (recommendation != null) {
                Text(stringResource(recommendation.description),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    modifier = modifier.padding(vertical = 10.dp, horizontal = 5.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(
        Recommendation(
            id = 1,
            category = Category.COFFEE,
            R.string.cafe_comma,
            R.string.cafe_comma_description,
            R.drawable.coffee_cafe_comma,
            R.string.coffee
        )
    )
}