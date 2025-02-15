package com.example.myapplication.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit
) {
    var searchKeyword by remember { mutableStateOf("") }

    Box(
        modifier = modifier.fillMaxWidth().border(2.dp,Color(0xFF00A5B7), CircleShape)
    ) {
        OutlinedTextField(
            value = searchKeyword,
            onValueChange = { searchKeyword = it },
            placeholder = { Text("최애를 입력하세요.") },
            modifier = Modifier
                .fillMaxWidth(),
            shape = CircleShape,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { onSearch(searchKeyword) }
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent, // 포커스 시 테두리 제거
                unfocusedBorderColor = Color.Transparent,
                containerColor = Color.White
            )
        )
        Image(
            modifier = Modifier.align(Alignment.CenterEnd).padding(end = 20.dp).clickable { onSearch(searchKeyword) },
            painter = painterResource(R.drawable.search_icon),
            contentDescription = ""
            )
    }
}
