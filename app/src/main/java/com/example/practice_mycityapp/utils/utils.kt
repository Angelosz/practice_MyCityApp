package com.example.practice_mycityapp.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.example.practice_mycityapp.R

@Composable
fun GoldCoinText(amount: Int, modifier: Modifier = Modifier){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = amount.toString(),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
        )
        Image(
            painter = painterResource(R.drawable.goldcoin),
            contentDescription = null,
            modifier = Modifier.size(dimensionResource(R.dimen.card_item_image_small))
        )
    }
}