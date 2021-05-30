package com.chesnovitskiy.museus.data.departments.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chesnovitskiy.museus.data.departments.database.DepartmentEntity.Companion.TABLE_NAME
import kotlinx.coroutines.flow.Flow

@Dao
interface DepartmentsDao {

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllFlow(): Flow<List<DepartmentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(departments: List<DepartmentEntity>)

    @Query("DELETE FROM $TABLE_NAME")
    suspend fun deleteAll()
}