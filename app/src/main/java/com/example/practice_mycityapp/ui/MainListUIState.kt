package com.example.practice_mycityapp.ui

import com.example.practice_mycityapp.model.Building
import com.example.practice_mycityapp.model.Resource
import com.example.practice_mycityapp.utils.ContentType
import com.example.practice_mycityapp.utils.View

data class MainListUIState (
    val contentType: ContentType,
    val selectedBuilding: Building,
    val selectedResource: Resource,
    val view: View
)