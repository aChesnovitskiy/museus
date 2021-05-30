package com.chesnovitskiy.museus.data.departments.repository

import androidx.room.withTransaction
import com.chesnovitskiy.museus.data.database.MuseusDatabase
import com.chesnovitskiy.museus.data.departments.database.DepartmentEntity
import com.chesnovitskiy.museus.data.departments.mapper.toDepartment
import com.chesnovitskiy.museus.domain.departments.DepartmentsRepository
import com.chesnovitskiy.museus.domain.departments.model.Department
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DepartmentsRepositoryImpl(private val database: MuseusDatabase) : DepartmentsRepository {

    override val departmentsFlow: Flow<List<Department>>
        get() = database
            .departmentsDao
            .getAllFlow()
            .map { departmentsEntities ->
                departmentsEntities.map { it.toDepartment() }
            }

    override suspend fun updateDepartments() {
        delay(2000)
        with(database) {
            withTransaction {
                departmentsDao.deleteAll()
                departmentsDao.insert(mock)
            }
        }
    }

    val mock = listOf(
        DepartmentEntity(
            id = 1,
            name = "Medieval Art",
            totalObjects = 10,
            objectIds = listOf()
        ),
        DepartmentEntity(
            id = 2,
            name = "Russian Art",
            totalObjects = 20,
            objectIds = listOf()
        ),
        DepartmentEntity(
            id = 3,
            name = "Ancient Art",
            totalObjects = 30,
            objectIds = listOf()
        ),
        DepartmentEntity(
            id = 4,
            name = "Medieval Art",
            totalObjects = 10,
            objectIds = listOf()
        ),
        DepartmentEntity(
            id = 5,
            name = "Russian Art",
            totalObjects = 20,
            objectIds = listOf()
        ),
        DepartmentEntity(
            id = 6,
            name = "Ancient Art",
            totalObjects = 30,
            objectIds = listOf()
        ),
    )
}