package com.sesame.module_test.test_flow2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FlowViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(LatestNewsUiState.Success(emptyList()))

    val uiState: StateFlow<LatestNewsUiState> = _uiState

    init {
        viewModelScope.launch {
            delay(2000)
            val news = mutableListOf<String>()
            news.add("title1")
            news.add("title2")
            _uiState.value = LatestNewsUiState.Success(news)
        }
    }
}

sealed class LatestNewsUiState {
    data class Success(val news: List<String>): LatestNewsUiState()
    data class Error(val exception: Throwable): LatestNewsUiState()
}