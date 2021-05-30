package com.chesnovitskiy.museus.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import com.chesnovitskiy.museus.data.departments.repository.DepartmentsRepositoryImpl
import com.chesnovitskiy.museus.domain.departments.DepartmentsUseCase
import com.chesnovitskiy.museus.presentation.departments.DepartmentsScreen
import com.chesnovitskiy.museus.presentation.departments.DepartmentsViewModel
import com.chesnovitskiy.museus.presentation.departments.DepartmentsViewModelFactory
import com.chesnovitskiy.museus.presentation.departments.model.UiDepartment
import com.chesnovitskiy.museus.presentation.theme.MuseusTheme

class MainActivity : ComponentActivity() {

    val departmentsViewModel: DepartmentsViewModel by viewModels {
        DepartmentsViewModelFactory(DepartmentsUseCase(DepartmentsRepositoryImpl()))
    }

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MuseusTheme {
                DepartmentsScreen(departmentsViewModel)
            }
        }
    }
}