package com.example.atlanta.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.atlanta.data.Recommendation

@Composable
fun DetailsScreen(
    recommendation: Recommendation?,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        item {
            if (recommendation != null) {
                Text(stringResource(recommendation.name))
            }
        }
        item {
            if (recommendation != null) {
                Image(
                    painter = painterResource(recommendation.avatar),
                    contentDescription = stringResource(recommendation.name)
                )
            }
        }
        item { Spacer(modifier = modifier.height(32.dp)) }
        item {
            if (recommendation != null) {
                Text(stringResource(recommendation.description))
            }
        }
    }
}