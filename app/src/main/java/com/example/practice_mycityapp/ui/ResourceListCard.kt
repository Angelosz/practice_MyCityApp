package com.example.practice_mycityapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice_mycityapp.R
import com.example.practice_mycityapp.data.DataProvider
import com.example.practice_mycityapp.model.Resource
import com.example.practice_mycityapp.ui.theme.Practice_MyCityAppTheme

@Composable
fun ResourceListCard(
    resource: Resource,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
){
    Card(modifier = modifier
        .padding(dimensionResource(R.dimen.padding_small))
        .shadow(1.dp, MaterialTheme.shapes.medium)
        .fillMaxWidth(),
        onClick = { onClick(resource.id) }
    ) {
        Row(modifier = Modifier
            .widthIn(min = 250.dp)
            .padding(dimensionResource(R.dimen.padding_small)),
        ) {
            Image(
                painter = painterResource(resource.image),
                contentDescription = stringResource(resource.description),
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_small))
                    .size(dimensionResource(R.dimen.card_item_image_medium)),
            )
            Column(
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                Text(
                    text = stringResource(resource.name),
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = stringResource(resource.description),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}


@Preview
@Composable
fun ResourceCardPreview(){
    Practice_MyCityAppTheme {
        ResourceListCard(
            DataProvider.resources[0],
            {}
        )
    }
}