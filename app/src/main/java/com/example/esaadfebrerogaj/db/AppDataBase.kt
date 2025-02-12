package com.example.esaadfebrerogaj.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.esaadfebrerogaj.data.local.room.AlbumEntity
import com.example.esaadfebrerogaj.data.local.room.CardEntity
import com.example.esaadfebrerogaj.data.local.room.ModelsDao
import com.example.esaadfebrerogaj.data.local.room.MushroomEntity

@Database(
    entities = [
        MushroomEntity::class,
        CardEntity::class,
        AlbumEntity::class
    ], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun modelsDao(): ModelsDao
}