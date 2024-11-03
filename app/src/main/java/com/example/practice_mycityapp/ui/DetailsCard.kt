package com.example.practice_mycityapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_mycityapp.R
import com.example.practice_mycityapp.data.DataProvider
import com.example.practice_mycityapp.model.Building
import com.example.practice_mycityapp.model.Resource

@Composable
fun DetailsCard(
    isShowingBuilding: Boolean,
    building: Building,
    resource: Resource,
    modifier: Modifier = Modifier
){
    Card(modifier = modifier
        .padding(dimensionResource(R.dimen.padding_large))
        .widthIn(min = 256.dp)
        .heightIn(min = 256.dp)
        .shadow(1.dp, MaterialTheme.shapes.medium)
    ) {
        Column(modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_large))
        ) {
            if(isShowingBuilding) BuildingDetailCard(building)
            ResourceDetailCard(resource)
        }
    }
}

@Composable
fun ResourceDetailCard(resource: Resource) {
    Row(modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))){

        Column(
            modifier = Modifier.fillMaxWidth(),

        ) {
            Image(
                painter = painterResource(resource.image),
                contentDescription = stringResource(resource.name),
                modifier = Modifier
                    .size(dimensionResource(R.dimen.card_item_image_large))
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            Text(
                text = stringResource(resource.name),
                style = MaterialTheme.typography.displaySmall,
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            Text(
                text = stringResource(resource.description),
                style = MaterialTheme.typography.bodyLarge,
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
        }
    }
}

@Composable
fun BuildingDetailCard(building: Building){
    Text(
        text = stringResource(building.name)
    )
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun DetailsCardPreview(){
    DetailsCard(
        isShowingBuilding = true,
        building = DataProvider.buildings[0],
        resource = DataProvider.resources[0],
        modifier = Modifier.fillMaxSize()
    )
}