package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.RetrofitClient1
import com.example.myapplication.RetrofitClient2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException

data class HomeState(
    val isLoading: Boolean = false,
    val images: List<String> = emptyList(),
    val searchText: String = ""
)
class SearchViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(HomeState())
    val uiState = _uiState.asStateFlow()

    fun search(keyword: String) {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitClient1.apiService.getCrawledImages(keyword + " 패션").execute()
                if (response.isSuccessful) {
                    val images = response.body()?.images ?: emptyList()
                    _uiState.update { it.copy(images = images) }
                } else {
                    println("API 오류: ${response.errorBody()?.string()}")
                }
            } catch (e: HttpException) {
                println("서버 오류: ${e.message}")
            } catch (e: Exception) {
                println("네트워크 오류: ${e.message}")
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }
}