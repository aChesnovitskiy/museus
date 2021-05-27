package com.chesnovitskiy.museus.data.departments.repository

import com.chesnovitskiy.museus.domain.departments.model.Department
import com.chesnovitskiy.museus.domain.departments.repository.DepartmentsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DepartmentsRepositoryImpl() : DepartmentsRepository {

    override val departmentsFlow: Flow<List<Department>>
        get() = flow {
            emit(
                listOf(
                    Department(
                        id = 1,
                        name = "Medieval Art",
                        totalObjects = 2,
                        objectIds = listOf(1, 2),
                    ),
                    Department(
                        id = 2,
                        name = "Russian Art",
                        totalObjects = 2,
                        objectIds = listOf(3, 4),
                    ),
                )
            )
        }

    override suspend fun updateDepartments() {

    }
}