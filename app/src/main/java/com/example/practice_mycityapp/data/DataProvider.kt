package com.example.practice_mycityapp.data

import com.example.practice_mycityapp.R
import com.example.practice_mycityapp.model.Building
import com.example.practice_mycityapp.model.Resource

object DataProvider {
    val buildings = listOf(
        Building(
            id = 1,
            name = R.string.forest,
            description = R.string.forest_description,
            cost = 12,
            imageRes = R.drawable.forest,
            upgradeCost = 20,
            resourceProducedId = 1
        ),
        Building(
            id = 2,
            name = R.string.sawmill,
            description = R.string.sawmill_description,
            cost = 26,
            imageRes = R.drawable.sawmill,
            upgradeCost = 44,
            resourceProducedId = 2
        ),
        Building(
            id = 3,
            name = R.string.carpentry,
            description = R.string.carpentry,
            cost = 48,
            imageRes = R.drawable.carpentry,
            upgradeCost = 84,
            resourceProducedId = 3
        ),
        Building(
            id = 4,
            name = R.string.wheat_field,
            description = R.string.wheat_field_description,
            cost = 36,
            imageRes = R.drawable.wheatfield,
            upgradeCost = 20,
            resourceProducedId = 4
        ),
        Building(
            id = 5,
            name = R.string.windmill,
            description = R.string.windmill_description,
            cost = 58,
            imageRes = R.drawable.windmill,
            upgradeCost = 72,
            resourceProducedId = 5
        ),
        Building(
            id = 6,
            name = R.string.bakery,
            description = R.string.bakery_description,
            cost = 102,
            imageRes = R.drawable.bakery,
            upgradeCost = 124,
            resourceProducedId = 6
        )
    )

    val resources = listOf(
        Resource(
            id = 1,
            name = R.string.tree,
            description = R.string.tree_description,
            image = R.drawable.tree,
            goldValue = 2,
        ),
        Resource(
            id = 2,
            name = R.string.wood_trunk,
            description = R.string.wood_trunk_description,
            image = R.drawable.treetrunks,
            goldValue = 8,
        ),
        Resource(
            id = 3,
            name = R.string.wood_plank,
            description = R.string.wood_plank_description,
            image = R.drawable.woodplanks,
            goldValue = 24,
        ),
        Resource(
            id = 4,
            name = R.string.wheat,
            description = R.string.wheat_description,
            image = R.drawable.wheat,
            goldValue = 12,
        ),
        Resource(
            id = 5,
            name = R.string.flour,
            description = R.string.flour_description,
            image = R.drawable.flour,
            goldValue = 46,
        ),
        Resource(
            id = 6,
            name = R.string.bread,
            description = R.string.bread_description,
            image = R.drawable.bread,
            goldValue = 162,
        )
    )
}