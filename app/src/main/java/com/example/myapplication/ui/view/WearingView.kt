package com.example.myapplication.ui.view

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil3.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.model.Clothes
import com.example.myapplication.ui.theme.pretendard

@Composable
fun WearingView(navController: NavController,uri: String?) {
    println(uri)
    val uriS = uri?.let { Uri.parse(it) }
    val pagerState = rememberPagerState{2}
    val items = Array(30,{
        WearingViewClothes(
            name = "one",
            price = 10000,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQsSEGsb-eTzQtV9IRS3lbfufgSsDImqQEHWA&s",
            isSelected = false
        )
    })
    Column(
        modifier = Modifier.fillMaxSize().background(White)
    ) {
        Spacer(Modifier.height(45.dp))
        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        ){
            Image(
                modifier = Modifier.clickable { navController.popBackStack() },
                painter = painterResource(R.drawable.back_icon),
                contentDescription = "back"
                )
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "나만의 착장 조합"
            )
        }
        Spacer(Modifier.height(18.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFFF4F4F4))
        ){
            Row(
                modifier = Modifier.align(Alignment.Center)
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF999999))
                )
                Spacer(Modifier.width(4.dp))
                Image(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    painter = painterResource(R.drawable.plus_icon),
                    contentDescription = ""
                )
                Spacer(Modifier.width(4.dp))
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF999999))
                )
                Spacer(Modifier.width(4.dp))
                Image(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    painter = painterResource(R.drawable.plus_icon),
                    contentDescription = ""
                )
                Spacer(Modifier.width(4.dp))
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF999999))
                )
                Spacer(Modifier.width(4.dp))
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    painter = painterResource(R.drawable.equal_icon),
                    contentDescription = ""
                )
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize(),
        ) { page ->
            if (page == 0){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFD9D9D9))
                )
                {
                    BigClothesCard(
                        item = uriS!!
                    )
                }
            }
            else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Spacer(Modifier.height(18.dp))
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 17.dp)
                            .fillMaxWidth()
                        .height(50.dp)
                        .clip(CircleShape)
                        .border(2.dp,Color(0xFF008BFF), CircleShape)
                ){
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "최애 입히기",
                        fontFamily = pretendard,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = Color(0xFF008BFF)
                    )
                }
                Spacer(Modifier.height(20.dp))
                LazyVerticalGrid(
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(horizontal = 20.dp),
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(26.dp),
                    horizontalArrangement = Arrangement.spacedBy(18.dp)
                ) {
                    items(items){ item ->
                        WearingClothes(item)
                    }
                }
            } }
        }
    }
}
@Composable
private fun WearingClothes(item: WearingViewClothes, modifier: Modifier = Modifier){
    var isSelected by remember { mutableStateOf(item.isSelected) }
    Box(
        modifier = modifier
            .width(161.dp)
            .height(250.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                isSelected = !isSelected
            }
    ) {
        AsyncImage(
            modifier = modifier
                .fillMaxSize()
                ,
            model = item.image,
            contentDescription = item.name,
            contentScale = ContentScale.Crop
        )
        Icon(
            modifier = Modifier.align(Alignment.TopEnd).padding(end = 10.dp,top =10.dp),
            painter = painterResource(R.drawable.check_icon),
            contentDescription = "",
            tint = if (isSelected) Color(0xFF008BFF) else (Color(0xFF5D5D5D).copy(0.5f))
        )
    }
}
data class WearingViewClothes(
    val name: String,
    val price: Int,
    val image: String,
    var isSelected: Boolean
)
@Composable
private fun BigClothesCard(item: Uri, modifier: Modifier = Modifier){
    AsyncImage(
        model = item,
        contentDescription = "",
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop
    )
}