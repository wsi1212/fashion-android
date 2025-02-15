package com.example.myapplication.ui.component

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapplication.R


class View(
    val icon: Int,
    val route: String,
)
@Composable
fun BottomNav(navController: NavController){
    val views = listOf(
        View(
            icon = R.drawable.wishlist_icon,
            route = "wishlist",
        ),
        View(
            icon = R.drawable.combination_icon,
            route = "combination",
        )
    )
    Box {
        NavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            containerColor = Color(0xFFF4F4F4),
            content = {
                views.forEach {view ->
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
                                painter = painterResource(view.icon),
                                contentDescription = "",
                                tint = if (currentRoute(navController) == view.route) Color.Black else Color(0xFFBBBBBB)
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
        Box(
            Modifier
                .align(Alignment.TopCenter)
                .padding(bottom = 40.dp)
                .size(100.dp,100.dp)
                .clip(CircleShape)
                .background(Color(0xFF848484))
                .clickable { Log.d("fasd","adf") }
        ){
            Image(
                modifier = Modifier.align(Alignment.Center),
                painter = painterResource(R.drawable.image_icon),
                contentDescription = ""
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