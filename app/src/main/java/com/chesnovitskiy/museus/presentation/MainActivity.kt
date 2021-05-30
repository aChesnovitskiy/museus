package com.chesnovitskiy.museus.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.chesnovitskiy.museus.domain.departments.model.Department
import com.chesnovitskiy.museus.presentation.departments.DepartmentsScreen
import com.chesnovitskiy.museus.presentation.theme.MuseusTheme

class MainActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MuseusTheme {
                DepartmentsScreen(
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
                        Department(
                            id = 3,
                            name = "Modern Art",
                            totalObjects = 5,
                            objectIds = listOf(3, 4),
                        ),
                        Department(
                            id = 3,
                            name = "Modern Art",
                            totalObjects = 5,
                            objectIds = listOf(3, 4),
                        ),
                        Department(
                            id = 3,
                            name = "Modern Art",
                            totalObjects = 5,
                            objectIds = listOf(3, 4),
                        ),
                        Department(
                            id = 3,
                            name = "Modern Art",
                            totalObjects = 5,
                            objectIds = listOf(3, 4),
                        ),
                        Department(
                            id = 3,
                            name = "Modern Art",
                            totalObjects = 5,
                            objectIds = listOf(3, 4),
                        ),
                        Department(
                            id = 3,
                            name = "Modern Art",
                            totalObjects = 5,
                            objectIds = listOf(3, 4),
                        ),
                        Department(
                            id = 3,
                            name = "Modern Art",
                            totalObjects = 5,
                            objectIds = listOf(3, 4),
                        ),
                    )
                )
            }
        }
    }
}