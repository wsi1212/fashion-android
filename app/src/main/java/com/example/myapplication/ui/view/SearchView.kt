package com.example.myapplication.ui.view

import android.widget.SearchView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.component.SearchBar
import com.example.myapplication.ui.theme.pretendard
import com.example.myapplication.ui.toFigmaSp
import com.example.myapplication.viewmodel.SearchViewModel

@Composable
fun SearchView(navController: NavController, keyword: String?) {
    val viewModel = SearchViewModel()
    LaunchedEffect(Unit) {
        viewModel.search(keyword!!)
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
                        painter = painterResource(R.drawable.back_icon),
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
                    "$keyword", fontFamily = pretendard,
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
    }
}