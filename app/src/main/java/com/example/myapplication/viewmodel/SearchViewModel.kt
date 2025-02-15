package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.RetrofitClient
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

    private fun updateIsLoading(isLoading: Boolean){
        _uiState.update { it.copy(isLoading = isLoading) }
    }

    private fun updateSearchResult(images: List<String>){
        _uiState.update { it.copy(images = images) }
    }

    fun updateSearchText(data : String){
        _uiState.update { it.copy(searchText = data) }
    }

    fun search(keyword: String) {
        updateIsLoading(true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitClient.apiService.getCrawledImages(keyword, 10).execute()
                if (response.isSuccessful) {
                    val images = response.body()?.images ?: emptyList()
                    updateSearchResult(images)
                } else {
                    println("API 오류: ${response.errorBody()?.string()}")
                }
            } catch (e: HttpException) {
                println("서버 오류: ${e.message}")
            } catch (e: Exception) {
                println("네트워크 오류: ${e.message}")
            }
            updateIsLoading(false)
        }
    }
}