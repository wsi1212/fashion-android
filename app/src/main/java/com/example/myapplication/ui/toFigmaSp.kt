package com.example.myapplication.ui

import android.content.res.Resources

fun Int.toFigmaSp(figmaWidth: Int):Int {
    val systemScreen = Resources.getSystem().displayMetrics
    return this * systemScreen.widthPixels / figmaWidth / (systemScreen.densityDpi / 160)
}