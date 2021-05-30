package com.chesnovitskiy.museus.presentation.departments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.chesnovitskiy.museus.domain.departments.DepartmentsUseCase
import com.chesnovitskiy.museus.domain.departments.model.Department
import com.chesnovitskiy.museus.presentation.base.BaseViewModel
import com.chesnovitskiy.museus.presentation.base.BaseViewState
import com.chesnovitskiy.museus.presentation.departments.model.UiDepartment
import com.chesnovitskiy.museus.presentation.departments.model.toUiDepartment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DepartmentsViewModel(departmentsUseCase: DepartmentsUseCase) :
    BaseViewModel<DepartmentsViewState>(DepartmentsViewState()) {

    init {
        updateState { it.copy(isUpdating = true) }
        viewModelScope.launch {
            departmentsUseCase.updateDepartments()
            updateState { it.copy(isUpdating = false) }
        }
        viewModelScope.launch {
            departmentsUseCase
                .departmentsFlow
                .collect { departments: List<Department> ->
                    updateState { state ->
                        state.copy(departments = departments.map { it.toUiDepartment() })
                    }
                }
        }
    }

    fun onDepartmentClick(departmentId: Int) {

    }
}

class DepartmentsViewModelFactory(
    private val departmentsUseCase: DepartmentsUseCase
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        DepartmentsViewModel(departmentsUseCase) as T
}

data class DepartmentsViewState(
    val departments: List<UiDepartment> = emptyList(),
    val isUpdating: Boolean = false
) : BaseViewState