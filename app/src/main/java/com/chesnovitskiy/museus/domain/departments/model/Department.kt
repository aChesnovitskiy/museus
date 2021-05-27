package com.chesnovitskiy.museus.domain.departments.model

data class Department(
    val id: Int,
    val name: String,
    val totalObjects: Int,
    val objectIds: List<Int>
)