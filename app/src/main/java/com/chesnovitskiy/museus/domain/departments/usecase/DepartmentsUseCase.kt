package com.chesnovitskiy.museus.domain.departments.usecase

import com.chesnovitskiy.museus.domain.departments.model.Department
import com.chesnovitskiy.museus.domain.departments.repository.DepartmentsRepository
import kotlinx.coroutines.flow.Flow

class DepartmentsUseCase(private val departmentsRepository: DepartmentsRepository) {

    val departmentsFlow: Flow<List<Department>> = departmentsRepository.departmentsFlow

    suspend fun updateDepartments() {
        departmentsRepository.updateDepartments()
    }
}