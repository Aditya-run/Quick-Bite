package com.example.quickbite.ui.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickbite.data.FoodApi
import com.example.quickbite.data.models.Category
import com.example.quickbite.data.remote.ApiResponse
import com.example.quickbite.data.remote.safeApiCall
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val foodApi: FoodApi) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeScreenState>(HomeScreenState.Loading)
    val uiState: StateFlow<HomeScreenState> = _uiState.asStateFlow()

    private val _navigationEvent = MutableSharedFlow<HomeScreenNavigationEvents?>()
    val navigationEvent = _navigationEvent.asSharedFlow()

    var categories = emptyList<Category>()
    init {
        getCategories()
        getPopularRestaurants()
    }
    fun getCategories() {
        viewModelScope.launch {
            val response = safeApiCall { foodApi.getCategories() }
            when (response) {
                is ApiResponse.Success -> {
                    categories = response.data.data
                    _uiState.value = HomeScreenState.Success
                }
                is ApiResponse.Error -> {
                    _uiState.value = HomeScreenState.Empty
                }
                else -> {
                    _uiState.value = HomeScreenState.Empty
                }
            }
        }
    }
    fun getPopularRestaurants() {

    }

    sealed class HomeScreenState {
        object Loading : HomeScreenState()
        object Empty : HomeScreenState()
        object Success : HomeScreenState()
    }
    sealed class HomeScreenNavigationEvents {
        object NavigateToDetail : HomeScreenNavigationEvents()
    }
}