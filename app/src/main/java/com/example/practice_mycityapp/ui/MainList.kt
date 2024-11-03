package com.example.practice_mycityapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.practice_mycityapp.R
import com.example.practice_mycityapp.data.DataProvider
import com.example.practice_mycityapp.model.Building
import com.example.practice_mycityapp.model.Resource
import com.example.practice_mycityapp.ui.theme.Practice_MyCityAppTheme

@Composable
fun MainList(
    buildings: List<Building>,
    resources: List<Resource>,
    onBuildingCardClicked: (Int) -> Unit,
    onResourceCardClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier
        .padding(dimensionResource(R.dimen.padding_small))
    ) {
        items(buildings) { building ->
            BuildingListCard(building, onBuildingCardClicked)
        }
        items(resources) { resource ->
            ResourceListCard(resource, onResourceCardClicked )
        }
    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun MainListPreview(){
    Practice_MyCityAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            MainList(
                DataProvider.buildings,
                listOf<Resource>(),
                {},{},
                Modifier.padding(innerPadding)
            )
        }
    }
}