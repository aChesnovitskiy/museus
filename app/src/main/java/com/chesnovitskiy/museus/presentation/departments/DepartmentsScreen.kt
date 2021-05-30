package com.chesnovitskiy.museus.presentation.departments

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import com.chesnovitskiy.museus.R
import com.chesnovitskiy.museus.presentation.departments.model.UiDepartment
import com.chesnovitskiy.museus.presentation.theme.MuseusTheme
import com.google.accompanist.coil.rememberCoilPainter

@ExperimentalFoundationApi
@Composable
fun DepartmentsScreen(
    viewModel: DepartmentsViewModel,
    modifier: Modifier = Modifier
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val stateFlowLifecycleAware = remember(viewModel.viewStateFlow, lifecycleOwner) {
        viewModel
            .viewStateFlow
            .flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
    }
    val state: DepartmentsViewState by stateFlowLifecycleAware.collectAsState(DepartmentsViewState())

    Scaffold { paddingValues ->
        if (state.isUpdating && state.departments.isEmpty()) {
            Box(
                modifier = modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                ,
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            modifier = modifier.padding(paddingValues),
            contentPadding = PaddingValues(12.dp)
        ) {
            items(state.departments) { department ->
                DepartmentCard(
                    department = department,
                    onClick = {},
                    modifier = modifier.padding(4.dp)
                )
            }
        }
    }
}

@Composable
fun DepartmentCard(
    department: UiDepartment,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier, elevation = 2.dp) {
        Column(
            Modifier
                .clickable { onClick.invoke() }
                .padding(8.dp)
        ) {
            Image(
                painter = rememberCoilPainter(department.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = department.name,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.subtitle2
            )
            Text(
                text = stringResource(R.string.objects_d, department.totalObjects),
                style = MaterialTheme.typography.caption
            )
        }
    }
}

//@ExperimentalFoundationApi
//@Preview(showBackground = true)
//@Composable
//fun DepartmentsScreenPreview() {
//    MuseusTheme {
//        DepartmentsScreen(
//            listOf(
//                UiDepartment(
//                    id = 1,
//                    name = "Medieval Art",
//                    totalObjects = 2,
//                    imageUrl = "",
//                ),
//                UiDepartment(
//                    id = 2,
//                    name = "Russian Art",
//                    totalObjects = 2,
//                    imageUrl = "",
//                ),
//                UiDepartment(
//                    id = 3,
//                    name = "Medieval Art Art Art Art Art",
//                    totalObjects = 2,
//                    imageUrl = "",
//                ),
//            )
//        )
//    }
//}

@Preview(showBackground = true)
@Composable
fun DepartmentCardPreview() {
    MuseusTheme {
        DepartmentCard(
            UiDepartment(
                id = 1,
                name = "Medieval Art",
                totalObjects = 2,
                imageUrl = "",
            ),
            onClick = {}
        )
    }
}