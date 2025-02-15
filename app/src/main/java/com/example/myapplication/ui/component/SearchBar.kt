package com.example.myapplication.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.pretendard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit
) {
    var searchKeyword by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(2.dp, Color(0xFF008BFF), CircleShape)
    ) {
        BasicTextField(
            value = searchKeyword,
            onValueChange = { searchKeyword = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(CircleShape)
                .background(Color.White),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.padding(start = 26.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (searchKeyword.isEmpty()) {
                        Text(
                            text = "최애를 입력하세요.",
                            fontFamily = pretendard,
                            fontWeight = FontWeight.Normal,
                            fontSize = 18.sp,
                            color = Color(0xFF797979)
                        )
                    }
                    innerTextField()
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { onSearch(searchKeyword) }
            ),
            textStyle = TextStyle(
                fontSize = 18.sp,
                fontFamily = pretendard,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            ),
        )
        Image(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 20.dp)
                .clickable { onSearch(searchKeyword) },
            painter = painterResource(R.drawable.search_icon),
            contentDescription = ""
        )
    }
}
