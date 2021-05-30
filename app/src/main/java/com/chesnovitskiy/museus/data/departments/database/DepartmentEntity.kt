package com.chesnovitskiy.museus.data.departments.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chesnovitskiy.museus.data.departments.database.DepartmentEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class DepartmentEntity(
    @PrimaryKey
    @ColumnInfo(name = COLUMN_ID)
    val id: Int,
    @ColumnInfo(name = COLUMN_NAME)
    val name: String,
    @ColumnInfo(name = COLUMN_TOTAL_OBJECTS)
    val totalObjects: Int,
    @ColumnInfo(name = COLUMN_OBJECTS_IDS)
    val objectIds: List<Int>
) {

    companion object {

        const val TABLE_NAME = "departments_table"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_TOTAL_OBJECTS = "total_objects"
        const val COLUMN_OBJECTS_IDS = "objects_id"
    }
}