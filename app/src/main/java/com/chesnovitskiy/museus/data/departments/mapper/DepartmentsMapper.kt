package com.chesnovitskiy.museus.data.departments.mapper

import com.chesnovitskiy.museus.data.departments.database.DepartmentEntity
import com.chesnovitskiy.museus.domain.departments.model.Department

fun DepartmentEntity.toDepartment(): Department = Department(
    id = id,
    name = name,
    totalObjects = totalObjects,
    objectIds = objectIds
)