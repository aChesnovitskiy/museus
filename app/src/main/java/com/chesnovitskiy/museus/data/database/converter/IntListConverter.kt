package com.chesnovitskiy.museus.data.database.converter

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class IntListConverter {

    @TypeConverter
    fun toJson(list: List<Int>): String = Json.encodeToString(list)

    @TypeConverter
    fun fromJson(json: String): List<Int> = Json.decodeFromString(json)
}