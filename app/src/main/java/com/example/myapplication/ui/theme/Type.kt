package com.example.myapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
val pretendard = FontFamily(
    Font(
        R.font.pretendardbold, FontWeight.Bold, FontStyle.Normal
    ),
    Font(
        R.font.pretendardblack, FontWeight.Black, FontStyle.Normal
    ),
    Font(
        R.font.pretendardmedium, FontWeight.Medium, FontStyle.Normal
    ),
    Font(
        R.font.pretendardextrabold, FontWeight.ExtraBold, FontStyle.Normal
    ),
    Font(
        R.font.pretendardextralight, FontWeight.ExtraLight, FontStyle.Normal
    ),
    Font(
        R.font.pretendardlight, FontWeight.Light, FontStyle.Normal
    ),
    Font(
        R.font.pretendardregular, FontWeight.Normal, FontStyle.Normal
    ),
    Font(
        R.font.pretendardsemibold, FontWeight.SemiBold, FontStyle.Normal
    ),
    Font(
        R.font.pretendardthin, FontWeight.Thin, FontStyle.Normal
    ),
)