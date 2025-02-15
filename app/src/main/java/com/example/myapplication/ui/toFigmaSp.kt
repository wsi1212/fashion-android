package com.example.myapplication.ui

import android.content.res.Resources

fun Int.toFigmaSp():Int {
    val systemScreen = Resources.getSystem().displayMetrics
    return this * systemScreen.widthPixels / 412 / (systemScreen.densityDpi / 160)
}