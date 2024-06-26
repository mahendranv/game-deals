package com.ex2.game_deals.common.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import coil.compose.rememberAsyncImagePainter
import com.ex2.game_deals.R

@Composable
fun OnlineImage(
    url: String, modifier: Modifier = Modifier, contentDescription: String? = null
) {
    val painter = rememberAsyncImagePainter(
        model = url,
        error = painterResource(id = R.drawable.outline_nearby_error_24),
        placeholder = painterResource(id = R.drawable.outline_hourglass_top_24)
    )
    Image(painter = painter, contentDescription = contentDescription, modifier = modifier)
}
