package com.example.myapplication.ui.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class MainState(
    val searchText: String = ""
)
class MainViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(MainState())
    val uiState = _uiState.asStateFlow()

    fun updateSearchText(data : String){
        _uiState.update { it.copy(searchText = data) }
    }
}