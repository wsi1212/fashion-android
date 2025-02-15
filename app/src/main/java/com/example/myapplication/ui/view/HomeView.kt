package com.example.myapplication.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.ui.component.ClothesCard
import com.example.myapplication.ui.component.SearchBar
import com.example.myapplication.model.Clothes
import com.example.myapplication.ui.theme.pretendard
import com.example.myapplication.ui.toFigmaSp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@Composable
fun HomeView(navController: NavController) {
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
            Box(modifier = Modifier.fillMaxWidth().height(125.dp).background(Color(0xFF008BFF))) {
                SearchBar(
                    modifier = Modifier
                        .padding(horizontal = 18.dp)
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 11.dp)
                    ,
                    onSearch = {
                        navController.navigate("search/$it")
                    }
                )
            }
        }
        item {
            BannerImages()
        }
        item {
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "많이 찾아본 인물",
                fontFamily = pretendard,
                fontSize = 16.toFigmaSp().sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 18.dp)
            )
        }
        item {
            Spacer(modifier = Modifier.height(12.dp))
            LazyRow(
                content = {
                    items(manySearchItems) { item ->
                        Row {
                            Spacer(modifier = Modifier.width(16.dp))
                            HumanClothes(
                                item = item
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
            Spacer(modifier = Modifier.height(64.dp))
            Text(
                text = "최애 손흥민의 착장",
                fontFamily = pretendard,
                fontSize = 16.toFigmaSp().sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp)
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
            Spacer(modifier = Modifier.height(64.dp))
            Text(
                text = "인기있는 착장",
                fontFamily = pretendard,
                fontSize = 16.toFigmaSp().sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        item {
            Spacer(modifier = Modifier.height(12.dp))
            LazyRow(
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
            Spacer(modifier = Modifier.height(64.dp))
            Text(
                text = "당신을 위한 추천 착장",
                fontFamily = pretendard,
                fontSize = 16.toFigmaSp().sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        item {
            Spacer(modifier = Modifier.height(12.dp))
            LazyRow(
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

@Composable
private fun HumanClothes(item: Clothes, modifier: Modifier = Modifier){
    Column {
        AsyncImage(
            modifier = modifier
                .width(98.dp)
                .height(98.dp)
                .clip(CircleShape),
            model = item.image,
            contentDescription = item.name,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier.height(11.dp))
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = item.name
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BannerImages(modifier: Modifier = Modifier) {
    val images = listOf(R.drawable.banner1, R.drawable.banner2) // 이미지 리소스 리스트

    // Pager 상태 관리
    val pagerState = rememberPagerState()

    HorizontalPager(
        count = images.size,
        state = pagerState,
        modifier = modifier.fillMaxWidth(),
    ) { page ->
        val image = images[page]

        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth()
        )
    }
}

