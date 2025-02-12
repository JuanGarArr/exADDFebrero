package com.example.esaadfebrerogaj.data.local.room

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromMushroomEntity(mushroom: MushroomEntity): String {
        return gson.toJson(mushroom)
    }

    @TypeConverter
    fun toMushroomEntity(json: String): MushroomEntity {
        return gson.fromJson(json, MushroomEntity::class.java)
    }

    @TypeConverter
    fun fromCardEntity(card: CardEntity): String {
        return gson.toJson(card)
    }

    @TypeConverter
    fun toCardEntity(json: String): CardEntity {
        return gson.fromJson(json, CardEntity::class.java)
    }
}
