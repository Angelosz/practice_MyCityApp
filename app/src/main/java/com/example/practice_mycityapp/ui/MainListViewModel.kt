package com.example.practice_mycityapp.ui

import androidx.lifecycle.ViewModel
import com.example.practice_mycityapp.data.DataProvider
import com.example.practice_mycityapp.model.Building
import com.example.practice_mycityapp.model.Resource
import com.example.practice_mycityapp.utils.ContentType
import com.example.practice_mycityapp.utils.View
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainListViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        MainListUIState(
            contentType = ContentType.BUILDINGS,
            selectedBuilding = DataProvider.buildings[0],
            selectedResource = DataProvider.resources[0],
            view = View.LIST_VIEW
        )
    )
    val uiState: StateFlow<MainListUIState> = _uiState

    fun selectResource(id: Int){
        val resource = findResource(id) ?: DataProvider.resources[0]

        _uiState.update { currentState ->
            currentState.copy(
                selectedResource = resource
            )
        }
    }

    fun selectBuilding(id: Int){
        val building = findBuilding(id) ?: DataProvider.buildings[0]
        val resource = findResource(building.resourceProducedId) ?: DataProvider.resources[0]

        _uiState.update { currentState ->
            currentState.copy(
                selectedBuilding = building,
                selectedResource = resource
            )
        }

    }

    private fun findResource(id: Int): Resource? {
        return DataProvider.resources.find { resource -> resource.id == id }
    }

    private fun findBuilding(id: Int): Building? {
        return DataProvider.buildings.find { building -> building.id == id }
    }

    fun changeView(view: View){
        _uiState.update { currentState ->
            currentState.copy(
                view = view
            )
        }
    }

    fun changeSelectedContentType(contentType: ContentType){
        _uiState.update { currentState ->
            currentState.copy(
                contentType = contentType
            )
        }
    }
}