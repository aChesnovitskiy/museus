package com.chesnovitskiy.museus.presentation.departments

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chesnovitskiy.museus.R
import com.chesnovitskiy.museus.domain.departments.model.Department
import com.chesnovitskiy.museus.presentation.theme.MuseusTheme
import com.google.accompanist.coil.rememberCoilPainter

@ExperimentalFoundationApi
@Composable
fun DepartmentsScreen(
    departments: List<Department>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(12.dp)
    ) {
        items(departments) { department ->
            DepartmentCard(
                department = department,
                onClick = {},
                modifier = modifier.padding(4.dp)
            )
        }
    }
}

@Composable
fun DepartmentCard(
    department: Department,
    imageUrl: String = "https://images.metmuseum.org/CRDImages/as/web-large/DP251139.jpg",
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
                painter = rememberCoilPainter(imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = department.name,
                style = MaterialTheme.typography.subtitle2
            )
            Text(
                text = stringResource(R.string.objects_d, department.totalObjects),
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DepartmentsScreenPreview() {
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
                    name = "Modern Art Art Art Art Art",
                    totalObjects = 5,
                    objectIds = listOf(3, 4),
                ),
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DepartmentCardPreview() {
    MuseusTheme {
        DepartmentCard(
            Department(
                id = 1,
                name = "Medieval Art",
                totalObjects = 2,
                objectIds = listOf(1, 2),
            ),
            onClick =  {}
        )
    }
}