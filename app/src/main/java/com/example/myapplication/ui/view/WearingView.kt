package com.example.myapplication.ui.view

import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WearingView(navController: NavController, uri: String?) {
    println(uri)
    val uriS = uri?.let { Uri.parse(it) }
    val pagerState = rememberPagerState { 2 }

    // 선택된 아이템의 인덱스를 저장하는 리스트
    var selectedIndices by remember { mutableStateOf(listOf<Int>()) }

    // 기본 아이템 리스트 (변경되지 않음)
    val items = List(30) { index ->
        WearingViewClothes(
            name = "one",
            price = index,
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQsSEGsb-eTzQtV9IRS3lbfufgSsDImqQEHWA&s"
        )
    }

    // 선택된 아이템들
    val selectedItems = selectedIndices.map { items[it] }

    Column(modifier = Modifier.fillMaxSize().background(White)) {
        Spacer(Modifier.height(45.dp))
        Box(modifier = Modifier.padding(horizontal = 20.dp).fillMaxWidth()) {
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

        // 나만의 착장 조합 부분
        Box(modifier = Modifier.fillMaxWidth().height(100.dp).background(Color(0xFFF4F4F4))) {
            Row(modifier = Modifier.align(Alignment.Center)) {
                SmallPartCard(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    item = selectedItems.getOrNull(0)
                )
                Spacer(Modifier.width(4.dp))
                Image(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    painter = painterResource(R.drawable.plus_icon),
                    contentDescription = ""
                )
                Spacer(Modifier.width(4.dp))
                SmallPartCard(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    item = selectedItems.getOrNull(1)
                )
                Spacer(Modifier.width(4.dp))
                Image(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    painter = painterResource(R.drawable.plus_icon),
                    contentDescription = ""
                )
                Spacer(Modifier.width(4.dp))
                SmallPartCard(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    item = selectedItems.getOrNull(2)
                )
                Spacer(Modifier.width(4.dp))
                Image(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    painter = painterResource(R.drawable.equal_icon),
                    contentDescription = ""
                )
            }
        }
        Box {
            HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) { page ->
                if (page == 0) {
                    Box(
                        modifier = Modifier.fillMaxSize().padding(20.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFFD9D9D9))
                    ) {
                        BigClothesCard(item = uriS!!)
                    }
                } else {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Spacer(Modifier.height(18.dp))
                        Box(
                            modifier = Modifier.padding(horizontal = 17.dp)
                                .fillMaxWidth()
                                .height(50.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color(0xFF008BFF), CircleShape)
                        ) {
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
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                                .padding(horizontal = 20.dp),
                            columns = GridCells.Fixed(2),
                            verticalArrangement = Arrangement.spacedBy(26.dp),
                            horizontalArrangement = Arrangement.spacedBy(18.dp)
                        ) {
                            items(items.size) { index ->
                                val item = items[index]
                                WearingClothes(
                                    item = item,
                                    isSelected = index in selectedIndices,
                                    onToggle = {
                                        selectedIndices = if (index in selectedIndices) {
                                            // 이미 선택된 경우 제거
                                            selectedIndices.filter { it != index }
                                        } else if (selectedIndices.size < 3) {
                                            // 선택되지 않았고 3개 미만인 경우 추가
                                            selectedIndices + index
                                        } else {
                                            // 3개 이상이면 변경하지 않음
                                            selectedIndices
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
            }
            PagerIndicator(
                modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 40.dp),
                pagerState = pagerState
            )
        }
    }
}

@Composable
private fun WearingClothes(
    item: WearingViewClothes,
    isSelected: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(161.dp)
            .height(250.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onToggle)
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = item.image,
            contentDescription = item.name,
            contentScale = ContentScale.Crop
        )
        Icon(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 10.dp, top = 10.dp),
            painter = painterResource(R.drawable.check_icon),
            contentDescription = "",
            tint = if (isSelected) Color(0xFF008BFF) else Color(0xFF5D5D5D).copy(0.5f)
        )
    }
}

data class WearingViewClothes(
    val name: String,
    val price: Int,
    val image: String
)

@Composable
private fun SmallPartCard(item: WearingViewClothes?, modifier: Modifier = Modifier) {
    if (item == null) {
        Box(
            modifier = modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color(0xFF999999)),
        )
    } else {
        AsyncImage(
            model = item.image,
            contentDescription = "",
            modifier = modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color(0xFF999999)),
            contentScale = ContentScale.Crop
        )
    }
}
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