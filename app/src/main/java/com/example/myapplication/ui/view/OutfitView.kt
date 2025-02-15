package com.example.myapplication.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.model.Clothes
import com.example.myapplication.ui.theme.pretendard

@Preview
@Composable
fun OutfitView(navController: NavController = NavController(LocalContext.current)) {
    val item = Clothes(
        name = "one",
        price = 10000,
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2sSt7ehunsFoCCn52pxA8zhUkcLcpVJXXHA&s"
    )
    val parts = listOf(
        Clothes(
            name = "one",
            price = 10000,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2sSt7ehunsFoCCn52pxA8zhUkcLcpVJXXHA&s"
        ),
        Clothes(
            name = "one",
            price = 10000,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2sSt7ehunsFoCCn52pxA8zhUkcLcpVJXXHA&s"
        ),
        Clothes(
            name = "one",
            price = 10000,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2sSt7ehunsFoCCn52pxA8zhUkcLcpVJXXHA&s"
        ),
        Clothes(
            name = "one",
            price = 10000,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2sSt7ehunsFoCCn52pxA8zhUkcLcpVJXXHA&s"
        ),
        Clothes(
            name = "one",
            price = 10000,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2sSt7ehunsFoCCn52pxA8zhUkcLcpVJXXHA&s"
        )
    )
    LazyColumn(
        modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        item {
            Spacer(modifier = Modifier.height(52.dp))
            Image(
                modifier = Modifier.padding(start = 20.dp)
                    .clickable { navController.popBackStack() },
                painter = painterResource(R.drawable.back_icon),
                contentDescription = "backbutton"
            )
        }
        item {
            Spacer(modifier = Modifier.height(14.dp))
            OutfitClothes(item = item)
        }
        item {
            Spacer(modifier = Modifier.height(28.dp))
            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = "착장 정보",
                fontSize = 18.sp,
                fontFamily = pretendard,
                fontWeight = FontWeight.SemiBold
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow {
                items(parts){ part ->
                    Spacer(modifier = Modifier.width(20.dp))
                    PartClothes(
                        item = part
                    )
                }
            }
        }
    }
}

@Composable
private fun OutfitClothes(item: Clothes, modifier: Modifier = Modifier){
    AsyncImage(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(420.dp)
            .clip(RoundedCornerShape(8.dp)),
        model = item.image,
        contentDescription = item.name,
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun PartClothes(item: Clothes, modifier: Modifier = Modifier){
    AsyncImage(
        modifier = modifier
            .fillMaxWidth()
            .width(100.dp)
            .height(130.dp)
            .clip(RoundedCornerShape(8.dp)),
        model = item.image,
        contentDescription = item.name,
        contentScale = ContentScale.Crop
    )
}