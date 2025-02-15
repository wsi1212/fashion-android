package com.example.myapplication.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun HomeView(){
    val manySearchItems = listOf(
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
    val favShareItems = listOf(
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
    val famousItems = listOf(
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
        modifier = Modifier.fillMaxSize().background(Color.White),
        contentPadding = PaddingValues(start = 20.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(47.dp))
            SearchBar(
                modifier = Modifier.padding(end = 20.dp),
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
                fontSize = 18.toFigmaSp().sp,
                fontWeight = FontWeight.W400
            )
        }
        item {
            Spacer(modifier = Modifier.height(14.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                content = {
                    items(manySearchItems) { item ->
                        ClothesCard(
                            item = item,
                            modifier = Modifier.size(98.dp, 98.dp).clip(RoundedCornerShape(20.dp))
                        )
                    }
                }
            )
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "최애 공유의 책장",
                fontFamily = pretendard,
                fontSize = 18.toFigmaSp().sp,
                fontWeight = FontWeight.W400
            )
        }
        item {
            Spacer(modifier = Modifier.height(15.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                content = {
                    items(favShareItems) { item ->
                        ClothesCard(
                            item = item,
                            modifier = Modifier.size(160.dp, 200.dp)
                        )
                    }
                }
            )
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "인기있는 착장",
                fontFamily = pretendard,
                fontSize = 18.toFigmaSp().sp,
                fontWeight = FontWeight.W400
            )
        }
        item {
            Spacer(modifier = Modifier.height(15.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                content = {
                    items(famousItems) { item ->
                        ClothesCard(
                            item = item,
                            modifier = Modifier.size(160.dp, 200.dp)
                        )
                    }
                }
            )
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "당신을 위한 추천 착장",
                fontFamily = pretendard,
                fontSize = 18.toFigmaSp().sp,
                fontWeight = FontWeight.W400
            )
        }
        item {
            Spacer(modifier = Modifier.height(15.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                content = {
                    items(youRecommendItem) { item ->
                        ClothesCard(
                            item = item,
                            modifier = Modifier.size(160.dp, 200.dp)
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}


