package com.example.myapplication.ui.view

import android.util.Log
import android.widget.SearchView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.ui.component.SearchBar
import com.example.myapplication.ui.theme.pretendard
import com.example.myapplication.ui.toFigmaSp
import com.example.myapplication.viewmodel.SearchViewModel

@Composable
fun SearchView(navController: NavController, keyword: String?) {
    val viewModel = remember { SearchViewModel() }
    val uiState by viewModel.uiState.collectAsState()
    val resultText = if (uiState.searchText == "") keyword else uiState.searchText
    LaunchedEffect(Unit) {
        viewModel.search(keyword!!)
    }
    LaunchedEffect(uiState) {
        Log.d("SearchView", "uiState: $uiState")
    }
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
                        top = 16.dp,
                        bottom = 16.dp,
                        start = 12.dp,
                        end = 16.dp
                    )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.back_icon_white),
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        },
                        contentDescription = ""
                    )

                    Spacer(modifier = Modifier.width(8.dp))
                    SearchBar(
                        onSearch = {
                            viewModel.search(it)
                        },
                        defaultValue = keyword!!
                    )
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(64.dp))
        }
        item {
            Row {
                Text(
                    " $resultText", fontFamily = pretendard,
                    fontSize = 16.toFigmaSp().sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Text(
                    " 검색 결과", fontFamily = pretendard,
                    fontSize = 16.toFigmaSp().sp,
                    color = Color(0xFF797979),
                )
            }
        }
        if (uiState.isLoading) {
            items(3) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp), horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    repeat(2) {
                        Box(
                            modifier = Modifier
                                .width(161.dp)
                                .height(250.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.LightGray.copy(alpha = 0.5f))
                        )
                    }
                }
            }
        } else {
            items(uiState.images.chunked(2)) { rowImages ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp), horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    rowImages.forEach { imageUrl ->
                        AsyncImage(
                            model = imageUrl,
                            contentDescription = null,
                            modifier = Modifier
                                .width(161.dp)
                                .height(250.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.LightGray),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }
}