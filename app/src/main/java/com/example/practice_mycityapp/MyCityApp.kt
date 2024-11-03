package com.example.practice_mycityapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
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

        val buildings = when(uiState.contentType){
            ContentType.BUILDINGS -> DataProvider.buildings
            ContentType.RESOURCES -> listOf()
        }

        val resources = when(uiState.contentType){
            ContentType.BUILDINGS -> listOf()
            ContentType.RESOURCES -> DataProvider.resources
        }

        when(uiState.view){
            View.LIST_VIEW ->
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxSize()
                ) {
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
                    BottomNavigationBar(
                        selectedContentType = uiState.contentType,
                        onTabPressed = { contentType ->
                            viewModel.changeSelectedContentType(contentType)
                        },
                    )
                }
            View.DETAIL_VIEW ->
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxSize()
                ) {
                    DetailsCard(
                        isShowingBuilding = uiState.contentType == ContentType.BUILDINGS,
                        building = uiState.selectedBuilding,
                        resource = uiState.selectedResource,
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxWidth()
                    )
                    BottomNavigationBar(
                        selectedContentType = uiState.contentType,
                        onTabPressed = { contentType ->
                            viewModel.changeSelectedContentType(contentType)
                            viewModel.changeView(View.LIST_VIEW)
                        },
                    )
                }
            View.LIST_DETAIL_VIEW -> Text(
                text = "list_detail_view"
            )
        }
    }
}
private data class NavigationItem(
    val contentType: ContentType,
    val icon: ImageVector,
    val text: String
)

private val navigationItems = listOf(
    NavigationItem(
        ContentType.BUILDINGS,
        Icons.Filled.Home,
        "Buildings"
    ),
    NavigationItem(
        ContentType.RESOURCES,
        Icons.Filled.Build,
        "Resources"
    )
)

@Composable
private fun BottomNavigationBar(
    selectedContentType: ContentType,
    onTabPressed: (ContentType) -> Unit,
    modifier: Modifier = Modifier
){
    NavigationBar(modifier = modifier){
        for( item in navigationItems) {
            NavigationBarItem(
                selected = item.contentType == selectedContentType,
                onClick = { onTabPressed(item.contentType) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.text
                    )
                }
            )
        }
    }
}
