package com.example.esaadfebrerogaj.data.local.room

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


const val MUSHROOM_TABLE_NAME = "mushrooms"
const val ALBUMS_TABLE_NAME = "albums"
const val CARDS_TABLE_NAME = "cards"


@Entity(tableName = MUSHROOM_TABLE_NAME)
data class MushroomEntity(
    @PrimaryKey val id: String,
    val name: String,
    val family: String,
    val description: String
)

@Entity(tableName = ALBUMS_TABLE_NAME)
data class CardEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @Embedded val mushroom: MushroomEntity,
    val mushroomImg: String,
    val latitude: String,
    val altitude: String,
    val date: String
)

@Entity(tableName = CARDS_TABLE_NAME)
data class AlbumEntity(
    @PrimaryKey val title: String,
    @Embedded val card: CardEntity
)