package com.example.practice_mycityapp.ui

import androidx.lifecycle.ViewModel
import com.example.practice_mycityapp.data.DataProvider
import com.example.practice_mycityapp.utils.ContentType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainListViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        MainListUIState(
            selectedList = ContentType.BUILDINGS,
            selectedBuilding = DataProvider.buildings[0],
            selectedResource = DataProvider.resources[0]
        )
    )
    val uiState: StateFlow<MainListUIState> = _uiState


}