package com.chesnovitskiy.museus.presentation.departments.model

import com.chesnovitskiy.museus.domain.departments.model.Department

data class UiDepartment(
    val id: Int,
    val name: String,
    val totalObjects: Int,
    val imageUrl: String,
)

fun Department.toUiDepartment(): UiDepartment = UiDepartment(
    id = id,
    name = name,
    totalObjects = totalObjects,
    imageUrl = "",
)