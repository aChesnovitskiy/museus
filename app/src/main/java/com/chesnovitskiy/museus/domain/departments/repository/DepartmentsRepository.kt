package com.chesnovitskiy.museus.domain.departments.repository

import com.chesnovitskiy.museus.domain.departments.model.Department
import kotlinx.coroutines.flow.Flow

interface DepartmentsRepository {

    val departmentsFlow: Flow<List<Department>>

    suspend fun updateDepartments()
}