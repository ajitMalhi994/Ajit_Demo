package com.app.presentation.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.presentation.R
import com.domain.common.ResponseState
import com.domain.model.HoldingData
import com.domain.model.HoldingsResponse
import com.domain.usecase.FetchHoldingsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel(
    private val fetchHoldingsUseCase: FetchHoldingsUseCase
) : ViewModel() {

    private val _holdingsResponse: MutableStateFlow<HoldingsResponse?> = MutableStateFlow(null)

    private val _holdingsList: MutableStateFlow<List<HoldingData>> = MutableStateFlow(emptyList())
    val holdingsList get() = _holdingsList.asStateFlow()

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading get() = _isLoading.asStateFlow()

    private val _isError: MutableStateFlow<String?> = MutableStateFlow(null)
    val isError get() = _isError.asStateFlow()

    init {
        fetchHoldingsData()
    }

    private fun fetchHoldingsData() {
        _isLoading.value = true
        viewModelScope.launch {
            fetchHoldingsUseCase().catch { cause ->
                _isLoading.value = false
                _isError.value = R.string.generic_error_message.toString()
            }.onEach { responseState ->
                when (responseState) {
                    is ResponseState.SuccessState -> {
                        _isError.value = null
                        _holdingsResponse.value = responseState.data
                        _holdingsList.value = responseState.data.data.userHolding
                        _isLoading.value = false
                    }

                    is ResponseState.ErrorState -> {
                        _holdingsResponse.value = null
                        _isError.value = responseState.message
                        _isLoading.value = false
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}