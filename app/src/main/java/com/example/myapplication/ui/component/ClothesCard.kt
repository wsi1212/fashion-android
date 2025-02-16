package com.example.myapplication.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import com.example.myapplication.model.Clothes

@Composable
fun ClothesCard(item: String, modifier: Modifier = Modifier) {
    AsyncImage(
        modifier = modifier
            .width(161.dp)
            .height(250.dp)
            .clip(RoundedCornerShape(8.dp)),
        model = item,
        contentDescription = "",
        contentScale = ContentScale.Crop
    )
}
