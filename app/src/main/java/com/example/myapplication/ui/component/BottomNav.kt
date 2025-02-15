package com.example.myapplication.ui.component

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapplication.R
import com.example.myapplication.ui.theme.pretendard
import com.example.myapplication.ui.toFigmaSp


class View(
    val icon: Int,
    val route: String,
    val name: String
)
@Preview
@Composable
fun BottomNav(navController: NavController = NavController(LocalContext.current), modifier: Modifier = Modifier){
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
        modifier = modifier.background(Transparent)
    ) {
        NavigationBar(
            tonalElevation = 10.dp,
            modifier = Modifier.align(Alignment.BottomCenter),
            containerColor = Color(0xFFF4F4F4),
            content = {
                views.forEach { view ->
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
                                fontSize = 15.toFigmaSp().sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = pretendard
                            )
                        },
                        onClick = {
                            navController.navigate(route = view.route)
                        },
                        selected = currentRoute(navController) == view.route,
                    )
                }
            }
        )
        Column(
            Modifier
                .align(Alignment.TopCenter)
                .padding(bottom = 20.dp)
        ) {
            Box(
                Modifier
                    .size(80.dp, 80.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF008BFF))
                    .clickable { Log.d("fasd", "adf") }
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
                fontSize = 15.toFigmaSp().sp,
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