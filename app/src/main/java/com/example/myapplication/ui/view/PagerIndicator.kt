package com.example.myapplication.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@ExperimentalFoundationApi
@Composable
fun PagerIndicator(modifier: Modifier = Modifier, pagerState: PagerState) {
    if (pagerState.pageCount > 1) {
        Row(modifier = modifier) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) {
                        Color(0xFF008BFF)
                    } else {
                        Color(0xFFD9D9D9)
                    }

                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp),
                )
            }
        }
    }
}

//val mealPagerState = rememberPagerState { 3 }
