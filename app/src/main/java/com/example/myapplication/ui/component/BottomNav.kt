package com.example.myapplication.ui.component

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapplication.R
import com.example.myapplication.ui.theme.pretendard


class View(
    val icon: Int,
    val route: String,
    val name: String
)

@Composable
fun BottomNav(
    navController: NavController = NavController(LocalContext.current),
    modifier: Modifier = Modifier
) {
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri: Uri? ->
            selectedImageUri = uri
            Log.d("select picture", "picture uri : $uri")
        }
    )

    val views = listOf(
        View(
            icon = R.drawable.home_icon,
            route = "home",
            name = "홈"
        ),
        View(
            icon = R.drawable.wishlist_icon,
            route = "wishlist",
            name = "찜 목록"
        )
    )

    Box(
        modifier = modifier
            .background(Color.White)
            .background(Transparent),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom // 아래 정렬
        ) {
            NavigationBar(
                tonalElevation = 10.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .drawBehind {
                        // 상단에만 선(보더)를 그립니다.
                        drawLine(
                            color = Color(0xFFD9D9D9), // 원하는 색상으로 변경 가능
                            start = Offset(0f, 0f),
                            end = Offset(size.width, 0f),
                            strokeWidth = 1.dp.toPx() // 원하는 두께로 변경 가능
                        )
                    },
                containerColor = Color(0xFFFFFFFF),
            ) {
                views.forEachIndexed { index, view ->
                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Black,
                            unselectedIconColor = Color.Gray,
                            selectedTextColor = Color.Black,
                            unselectedTextColor = Color.Gray,
                            indicatorColor = Transparent
                        ),
                        icon = {
                            Icon(
                                modifier = Modifier.size(32.dp),
                                painter = painterResource(view.icon),
                                contentDescription = "",
                                tint = if (currentRoute(navController) == view.route) Color.Black else Color(
                                    0xFFBBBBBB
                                )
                            )
                        },
                        label = {
                            Text(
                                text = view.name,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = pretendard
                            )
                        },
                        onClick = {
                            navController.navigate(route = view.route)
                        },
                        selected = currentRoute(navController) == view.route,
                    )
                    if (index == 0) {
                        Spacer(modifier = Modifier.width(80.dp))
                    }
                }
            }
        }

        Column(
            Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-55).dp) // 네비게이션 바 위로 이동
        ) {
            Box(
                Modifier
                    .size(80.dp, 80.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF008BFF))
                    .clickable {
                        photoPickerLauncher.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                    }
            ) {
                Image(
                    modifier = Modifier.align(Alignment.Center),
                    painter = painterResource(R.drawable.photo_icon),
                    contentDescription = ""
                )
            }
            Spacer(Modifier.height(7.dp))
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "입혀보기",
                fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                color = Color(0xFF008BFF)
            )
        }
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Log.d("adfj", "${navBackStackEntry?.destination?.route}")
    return navBackStackEntry?.destination?.route
}
