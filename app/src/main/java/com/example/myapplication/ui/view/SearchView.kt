package com.example.myapplication.ui.view

import android.widget.SearchView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.viewmodel.SearchViewModel

@Composable
fun SearchView(navController: NavController, keyword: String?){
    val viewModel = SearchViewModel()
    LaunchedEffect(Unit) {
        viewModel.search(keyword!!)
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        item {
            Spacer(Modifier.height(53.dp))
            Row(
                modifier = Modifier.padding(start = 20.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.back_icon),
                    contentDescription = ""
                    )
            }
        }
    }
}