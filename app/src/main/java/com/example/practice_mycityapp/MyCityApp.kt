package com.example.practice_mycityapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.practice_mycityapp.data.DataProvider
import com.example.practice_mycityapp.ui.DetailsCard
import com.example.practice_mycityapp.ui.MainList
import com.example.practice_mycityapp.ui.MainListViewModel
import com.example.practice_mycityapp.utils.ContentType
import com.example.practice_mycityapp.utils.View

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    viewModel: MainListViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "My City"
                    )
                },
                navigationIcon = {
                    if(uiState.view == View.DETAIL_VIEW) {
                        IconButton( onClick = { viewModel.changeView(View.LIST_VIEW) } ){
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = stringResource(R.string.back_button)
                            )
                        }
                    }
                },
                modifier = Modifier
            )
        }
        ) { innerPadding ->

        val buildings = when(uiState.selectedList){
            ContentType.BUILDINGS -> DataProvider.buildings
            ContentType.RESOURCES -> listOf()
        }

        val resources = when(uiState.selectedList){
            ContentType.BUILDINGS -> listOf()
            ContentType.RESOURCES -> DataProvider.resources
        }

        when(uiState.view){
            View.LIST_VIEW ->
                MainList(
                    buildings = buildings,
                    resources = resources,
                    onBuildingCardClicked = { buildingId ->
                        viewModel.selectBuilding(buildingId)
                        viewModel.changeView(View.DETAIL_VIEW)
                    },
                    onResourceCardClicked = { resourceId ->
                        viewModel.selectResource(resourceId)
                        viewModel.changeView(View.DETAIL_VIEW)
                    },
                    modifier = Modifier.padding(innerPadding)
                )
            View.DETAIL_VIEW ->
                DetailsCard(
                    isShowingBuilding = uiState.selectedList == ContentType.BUILDINGS,
                    building = uiState.selectedBuilding,
                    resource = uiState.selectedResource,
                    modifier = Modifier.padding(innerPadding).fillMaxSize()
                )
            View.LIST_DETAIL_VIEW -> Text(
                text = "list_detail_view"
            )
        }
    }
}