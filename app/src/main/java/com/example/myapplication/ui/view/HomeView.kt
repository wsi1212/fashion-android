package com.example.myapplication.ui.view

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.example.myapplication.RetrofitClient1
import com.example.myapplication.RetrofitClient2
import com.example.myapplication.ui.component.ClothesCard
import com.example.myapplication.ui.component.SearchBar
import com.example.myapplication.model.Clothes
import com.example.myapplication.ui.theme.pretendard
import com.example.myapplication.ui.toFigmaSp

@Composable
fun HomeView(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    var favShareItems = listOf(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTf3DQDx_wPl94pE9WSA7z9PnldTOtUx8_0Q&s",
        "https://image.edaily.co.kr/images/Photo/files/NP/S/2022/06/PS22061300985.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvlA9GQiMozsGGOfr0NoeWdwSih_zdxRQn2IJR3-X_qtdHTtn3mmb6xa3wf3aKK1vLHEQ&usqp=CAU"
    )
    val manySearchItems = listOf(
        Clothes(
            name = "손흥민",
            price = 10000,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQsSEGsb-eTzQtV9IRS3lbfufgSsDImqQEHWA&s"
        ),
        Clothes(
            name = "아이유",
            price = 10000,
            image = "https://i.namu.wiki/i/R0AhIJhNi8fkU2Al72pglkrT8QenAaCJd1as-d_iY6MC8nub1iI5VzIqzJlLa-1uzZm--TkB-KHFiT-P-t7bEg.webp"
        ),
        Clothes(
            name = "박재범",
            price = 10000,
            image = "https://i.namu.wiki/i/r_Zr2Q2jbfjOFEYqAWHCm_xrZ5RvPT5Z3T-Etzc69p3jIDmaevwpNKa9OqU9D6afMiiUbENw4bzn8ButrP0dDQ.webp"
        ),
        Clothes(
            name = "장원영",
            price = 10000,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2nD4_OOi_VhDSrieBCiqv5AbgPgs6xT3CDA&s"
        ),
        Clothes(
            name = "three",
            price = 10000,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQJZhJsAJy2TsE7SrqXBBumBJAf5DgDif8EQ&s"
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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF008BFF))
                    .statusBarsPadding()
                    .padding(
                        vertical = 16.dp,
                        horizontal = 18.dp
                    )
            ) {
                Column {
                    Image(
                        modifier = Modifier.width(90.dp).height(30.dp),
                        painter = painterResource(R.drawable.logo_black),
                        contentDescription = "",
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    SearchBar(
                        onSearch = {
                            navController.navigate("search/$it")
                        }
                    )
                }
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
                                item = item.image,
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
                                item = item.image,
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
private fun HumanClothes(item: Clothes, modifier: Modifier = Modifier) {
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerImages(modifier: Modifier = Modifier) {
    val images = listOf(R.drawable.banner1, R.drawable.banner2) // 이미지 리소스 리스트

    // Pager 상태 관리
    val pagerState = rememberPagerState{2}

    Box {
        HorizontalPager(
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
        PagerIndicator(
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 10.dp),
            pagerState = pagerState
        )
    }
}

