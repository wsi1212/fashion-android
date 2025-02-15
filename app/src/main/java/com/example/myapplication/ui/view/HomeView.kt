package com.example.myapplication.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.component.ClothesCard
import com.example.myapplication.ui.component.SearchBar
import com.example.myapplication.ui.model.Clothes
import com.example.myapplication.ui.theme.pretendard
import com.example.myapplication.ui.toFigmaSp
import dagger.Module

@Preview
@Composable
fun HomeView() {
    val manySearchItems = listOf(
        Clothes(
            name = "one",
            price = 10000,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQsSEGsb-eTzQtV9IRS3lbfufgSsDImqQEHWA&s"
        ),
        Clothes(
            name = "two",
            price = 10000,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcNsNrMMbXuNZWeb7-8YAqG-NokPs05sy8Wg&s"
        ),
        Clothes(
            name = "three",
            price = 10000,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQJZhJsAJy2TsE7SrqXBBumBJAf5DgDif8EQ&s"
        ),
        Clothes(
            name = "three",
            price = 10000,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQJZhJsAJy2TsE7SrqXBBumBJAf5DgDif8EQ&s"
        ),
        Clothes(
            name = "three",
            price = 10000,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQJZhJsAJy2TsE7SrqXBBumBJAf5DgDif8EQ&s"
        )
    )
    val favShareItems = listOf(
        Clothes(
            name = "one",
            price = 10000,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2sSt7ehunsFoCCn52pxA8zhUkcLcpVJXXHA&s"
        ),
        Clothes(
            name = "two",
            price = 10000,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcXoRKiOZL8XTXfr0Ng5FUBheNfCBhYCISow&s"
        ),
        Clothes(
            name = "three",
            price = 10000,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGMYpHaI_CDOWtwc-qKvlZvFvwrs4pQYSQwQ&s"
        )
    )
    val famousItems = listOf(
        Clothes(
            name = "one",
            price = 10000,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQIiOqCnsKCZLAMTgJQw0KzwuQoXQI0bRcZPw&s"
        ),
        Clothes(
            name = "two",
            price = 10000,
            image = "https://image.msscdn.net/thumbnails/images/goods_img/20240214/3866831/3866831_17095239369616_big.jpg?w=1200"
        ),
        Clothes(
            name = "three",
            price = 10000,
            image = "https://image.msscdn.net/thumbnails/images/goods_img/20240214/3866831/3866831_17095239369616_big.jpg?w=1200"
        )
    )
    val youRecommendItem = listOf(
        Clothes(
            name = "one",
            price = 10000,
            image = "https://image.msscdn.net/thumbnails/images/goods_img/20240214/3866831/3866831_17095239369616_big.jpg?w=1200"
        ),
        Clothes(
            name = "two",
            price = 10000,
            image = "https://image.msscdn.net/thumbnails/images/goods_img/20240214/3866831/3866831_17095239369616_big.jpg?w=1200"
        ),
        Clothes(
            name = "three",
            price = 10000,
            image = "https://image.msscdn.net/thumbnails/images/goods_img/20240214/3866831/3866831_17095239369616_big.jpg?w=1200"
        )
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            Spacer(modifier = Modifier.height(50.dp))
            SearchBar(
                modifier = Modifier.padding(horizontal = 18.dp),
                onSearch = {
                    println(it)
                }
            )
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "많이 찾아본 인물",
                fontFamily = pretendard,
                fontSize = 16.toFigmaSp().sp,
                fontWeight = FontWeight.W500,
                modifier = Modifier.padding(start = 18.dp)
            )
        }
        item {
            Spacer(modifier = Modifier.height(12.dp))
            LazyRow(
                content = {
                    items(manySearchItems) { item ->
                        ClothesCard(
                            item = item,
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .size(98.dp, 98.dp)
                                .clip(RoundedCornerShape(20.dp))
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }
            )
        }
        item {
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "최애 공유의 착장",
                fontFamily = pretendard,
                fontSize = 16.toFigmaSp().sp,
                fontWeight = FontWeight.W500,
                modifier = Modifier.padding(start = 18.dp)
            )
        }
        item {
            Spacer(modifier = Modifier.height(12.dp))
            LazyRow(
                content = {
                    items(favShareItems) { item ->
                        Row {
                            Spacer(modifier = Modifier.width(16.dp))
                            ClothesCard(
                                item = item,
                            )
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }
            )
        }
        item {
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "인기있는 착장",
                fontFamily = pretendard,
                fontSize = 16.toFigmaSp().sp,
                fontWeight = FontWeight.W500,
                modifier = Modifier.padding(start = 18.dp)
            )
        }
        item {
            Spacer(modifier = Modifier.height(12.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                content = {
                    items(famousItems) { item ->
                        Row {
                            Spacer(modifier = Modifier.width(16.dp))
                            ClothesCard(
                                item = item,
                            )
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }
            )
        }
        item {
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "당신을 위한 추천 착장",
                fontFamily = pretendard,
                fontSize = 16.toFigmaSp().sp,
                fontWeight = FontWeight.W500,
                modifier = Modifier.padding(start = 18.dp)
            )
        }
        item {
            Spacer(modifier = Modifier.height(12.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                content = {
                    items(youRecommendItem) { item ->
                        Row {
                            Spacer(modifier = Modifier.width(16.dp))
                            ClothesCard(
                                item = item,
                            )
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }
            )
            Spacer(modifier = Modifier.height(300.dp))
        }
    }
}


