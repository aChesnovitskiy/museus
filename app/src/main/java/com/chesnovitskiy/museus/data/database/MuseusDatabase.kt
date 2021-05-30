package com.chesnovitskiy.museus.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.chesnovitskiy.museus.data.database.MuseusDatabase.Companion.DATABASE_VERSION
import com.chesnovitskiy.museus.data.database.converter.IntListConverter
import com.chesnovitskiy.museus.data.departments.database.DepartmentEntity
import com.chesnovitskiy.museus.data.departments.database.DepartmentsDao

@Database(
    entities = [
        DepartmentEntity::class
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)
@TypeConverters(
    IntListConverter::class
)
abstract class MuseusDatabase: RoomDatabase() {

    companion object {

        const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "museus_database"

        fun provideDatabase(context: Context): MuseusDatabase =
            Room
                .databaseBuilder(
                    context,
                    MuseusDatabase::class.java,
                    DATABASE_NAME
                )
                .fallbackToDestructiveMigration()
                .build()
    }

    abstract val departmentsDao: DepartmentsDao
}