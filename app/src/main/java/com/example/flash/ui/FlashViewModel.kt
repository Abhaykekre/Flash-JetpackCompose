package com.example.flash.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flash.data.InternetItem
import com.example.flash.network.FlashApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FlashViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(FlashUiState())
    val uiState: StateFlow<FlashUiState> = _uiState.asStateFlow()

    val _isVisible = MutableStateFlow<Boolean>(true)
    val isVisible = _isVisible

    var itemUiState: ItemUiState by mutableStateOf(ItemUiState.Loading)
        private set

    private val _cardItems = MutableStateFlow<List<InternetItem>>(emptyList())
    val cartItems: StateFlow<List<InternetItem>> get() = _cardItems.asStateFlow()

    lateinit var internetJob: Job
    lateinit var screenJob: Job

    sealed interface ItemUiState {
        data class Success(val items: List<InternetItem>) : ItemUiState
        object Loading : ItemUiState
        object Error : ItemUiState
    }

    fun addToCart(
        item: InternetItem
    ) {
         _cardItems.value = _cardItems.value + item
    }

    fun removeFromCart(item: InternetItem) {
         _cardItems.value = _cardItems.value - item
    }

    fun updateClickText(updatedText: String) {
        _uiState.update {
            it.copy(
                clickStatus = updatedText
            )
        }
    }

    fun updateSelectedCategory(updateCategory: Int) {
        _uiState.update {
            it.copy(
                selectedCategory = updateCategory
            )
        }
    }

    fun toggleVisibility() {
        _isVisible.value = false

    }

    fun getFlashItems() {
        internetJob = viewModelScope.launch {
            try {
                val listResult = FlashApi.retrofitService.getItems()
                itemUiState = ItemUiState.Success(listResult)
            } catch (exception: Exception) {
                itemUiState = ItemUiState.Error
                toggleVisibility()
                screenJob.cancel()
            }

        }
    }

    init {
        screenJob = viewModelScope.launch(Dispatchers.Default) {
            delay(3000)
            toggleVisibility()
        }
        getFlashItems()
    }

}