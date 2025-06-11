package com.example.network.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.data.model.CatImageModel
import com.example.network.domain.usecase.GetCatImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(
    private val getCatImagesUseCase: GetCatImagesUseCase
) : ViewModel() {

    private val _cats = MutableStateFlow<List<CatImageModel>>(emptyList())
    val cats: StateFlow<List<CatImageModel>> = _cats



    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    init {
        fetchCats()
    }

    private fun fetchCats(limit: Int = 10) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val images = getCatImagesUseCase(limit)
                _uiState.value = UiState.Success(images)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Unknown error")
            }
        }
    }

}

sealed class UiState {
    object Loading : UiState()
    data class Success(val cats: List<CatImageModel>) : UiState()
    data class Error(val message: String) : UiState()
}

