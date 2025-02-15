package com.example.myapplication.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import com.example.myapplication.ui.model.Clothes

@Composable
fun ClothesCard(item: Clothes, modifier: Modifier = Modifier) {
    AsyncImage(
        modifier = modifier
            .width(161.dp)
            .height(250.dp),
        model = item.image,
        contentDescription = item.name,
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun ClothesCardPreview() {
    ClothesCard(
        Clothes(
            name = "T-shirt",
            price = 1000,
            image = "https://image.msscdn.net/thumbnails/images/goods_img/20240214/3866831/3866831_17095239369616_big.jpg?w=1200"
        )
    )
}