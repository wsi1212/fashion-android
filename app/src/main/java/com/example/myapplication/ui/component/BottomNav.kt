package com.example.myapplication.ui.component

import android.content.res.Resources
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R


class View(
    val icon: Int,
    val route: String,
    val name: String
)
@Composable
fun BottomNav(navController: NavController){
    val views = listOf(
        View(
            icon = R.drawable.heart_icon,
            route = "heart",
            name = "하트"
        ),
        View(
            icon = R.drawable.combi_icon,
            route = "combi",
            name = "콤비"
        )
    )
    Box() {
        NavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            containerColor = Color(0xFFF4F4F4),
            content = {
                views.forEachIndexed { index, view ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(view.icon),
                                contentDescription = ""
                            )
                        },
                        onClick = {
                            TODO()
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
fun currentRoute(navController: NavController): String?{
    Log.d("adfj","${navController.currentBackStackEntry?.destination?.route}")
    return navController.currentBackStackEntry?.destination?.route
}