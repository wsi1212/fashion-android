package com.example.myapplication.ui.view

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import kotlinx.coroutines.delay

@Preview
@Composable
fun OutfitView(navController: NavController = NavController(LocalContext.current)) {

    var isRoading by remember { mutableStateOf(true) }


    LaunchedEffect(Unit){
        delay(2000L)
        isRoading = false
    }


    val item = Clothes(
        name = "one",
        price = 10000,
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxV22ruQdGMc_0mmbVw0rtM_GNP3wP85nfag&s"
    )
    val parts = listOf(
        Clothes(
            name = "GUCCI 자켓",
            price = 270000,
            image = "https://cdn.discordapp.com/attachments/1339576223348559914/1340484301438976072/shopping.png?ex=67b286ca&is=67b1354a&hm=ba613d8c2b69401d11fb6bd7a5e847f2354629bcb66ca3558cb6b2e91e2610a0&"
        ),
        Clothes(
            name = "1989 스탠다드 후드",
            price = 34000,
            image = "https://cdn.discordapp.com/attachments/1339576223348559914/1340484533220413510/2990463_16947561188804_big.png?ex=67b28701&is=67b13581&hm=419b9794a31d2967212a28f57ee7fbe73c979bf1002a356a3f141db859e94c21&"
        ),
        Clothes(
            name = "커스텀어클락 데님팬츠",
            price = 24750,
            image = "https://cdn.discordapp.com/attachments/1339576223348559914/1340484689038934188/3816988_17171271417251_big.png?ex=67b28726&is=67b135a6&hm=804b78e6b68c34599a10cebd0570fdd2f59409d05744b60fb27faac1ad8742c6&"
        ),
        Clothes(
            name = "GUCCI 사보이 더플백",
            price = 3800000,
            image = "https://cdn.discordapp.com/attachments/1339576223348559914/1340483669302710333/GQC924082114836_0_ORGINL_20240821121101968.png?ex=67b28633&is=67b134b3&hm=770d446516a8f0d9816803a3109b9d758cae1a3dbfcae23660213a328f8245c9&"
        ),
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
            OutfitClothes(item = item, isRoading = isRoading)
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow {
                items(parts){ part ->
                    Spacer(modifier = Modifier.width(20.dp))
                    PartClothes(
                        item = part,
                        context = LocalContext.current,
                        isRoading = isRoading
                    )
                }
            }
        }
    }
}

@Composable
private fun OutfitClothes(item: Clothes, modifier: Modifier = Modifier,isRoading: Boolean){
    if (isRoading){
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(420.dp)
                .clip(RoundedCornerShape(8.dp))
                .placeholder(
                    visible = true,
                    highlight = PlaceholderHighlight.shimmer() // 최신 shimmer 적용
                )
        )
    }
    else {
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
}

@Composable
private fun PartClothes(item: Clothes, modifier: Modifier = Modifier,context: Context,isRoading: Boolean){
    val url = "https://www.musinsa.com/products/2990463"
    Column(){
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = if (isRoading) "" else  item.name,
            fontWeight = FontWeight.Bold,
            fontFamily = pretendard,
            fontSize = 10.sp
        )
    if (isRoading){
        Box(
            modifier = modifier
                .fillMaxWidth()
                .width(100.dp)
                .height(130.dp)
                .clip(RoundedCornerShape(8.dp))
                .placeholder(
                    visible = true,
                    highlight = PlaceholderHighlight.shimmer() // 최신 shimmer 적용
                )
        )
    }
    else {
        AsyncImage(
            modifier = modifier
                .fillMaxWidth()
                .width(100.dp)
                .height(130.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    context.startActivity(intent)
                },
            model = item.image,
            contentDescription = item.name,
            contentScale = ContentScale.Crop
        )
    }
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = if(isRoading) "" else "${item.price} 원",
            fontWeight = FontWeight.Bold,
            fontFamily = pretendard,
            fontSize = 10.sp
        )
    }
}
data class Clothe(
    val image : String,
    val store : String
)