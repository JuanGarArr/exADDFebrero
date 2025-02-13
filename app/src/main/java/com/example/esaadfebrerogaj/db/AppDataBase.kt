package com.example.esaadfebrerogaj.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.esaadfebrerogaj.data.local.room.AlbumEntity
import com.example.esaadfebrerogaj.data.local.room.ModelsDao

@Database(
    entities = [
        AlbumEntity::class
    ], version = 1, exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun modelsDao(): ModelsDao
}