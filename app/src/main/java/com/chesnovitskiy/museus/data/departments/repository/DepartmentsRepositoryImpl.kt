package com.chesnovitskiy.museus.data.departments.repository

import com.chesnovitskiy.museus.domain.departments.DepartmentsRepository
import com.chesnovitskiy.museus.domain.departments.model.Department
import kotlinx.coroutines.delay
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
                        totalObjects = 3,
                        objectIds = listOf(3, 4),
                    ),
                    Department(
                        id = 3,
                        name = "Ancient Art",
                        totalObjects = 4,
                        objectIds = listOf(5, 6),
                    ),
                    Department(
                        id = 1,
                        name = "Medieval Art",
                        totalObjects = 2,
                        objectIds = listOf(1, 2),
                    ),
                    Department(
                        id = 2,
                        name = "Russian Art",
                        totalObjects = 3,
                        objectIds = listOf(3, 4),
                    ),
                    Department(
                        id = 3,
                        name = "Ancient Art",
                        totalObjects = 4,
                        objectIds = listOf(5, 6),
                    ),
                    Department(
                        id = 1,
                        name = "Medieval Art",
                        totalObjects = 2,
                        objectIds = listOf(1, 2),
                    ),
                    Department(
                        id = 2,
                        name = "Russian Art",
                        totalObjects = 3,
                        objectIds = listOf(3, 4),
                    ),
                    Department(
                        id = 3,
                        name = "Ancient Art",
                        totalObjects = 4,
                        objectIds = listOf(5, 6),
                    ),
                )
            )
        }

    override suspend fun updateDepartments() {
        delay(2000)
    }
}