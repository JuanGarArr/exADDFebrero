package com.example.esaadfebrerogaj.data.local.room

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.esaadfebrerogaj.domain.Mushroom


const val MUSHROOM_TABLE_NAME = "mushrooms"
const val ALBUMS_TABLE_NAME = "albums"
const val CARDS_TABLE_NAME = "cards"


@Entity(tableName = MUSHROOM_TABLE_NAME)
data class MushroomEntity(
    @ColumnInfo(name = "idMushroom") @PrimaryKey val idMushroom: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "family") val family: String,
    @ColumnInfo(name = "description") val description: String,

    )

@Entity(tableName = ALBUMS_TABLE_NAME)
data class AlbumEntity(
    @PrimaryKey @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "card") val card: String
)

@Entity(tableName = CARDS_TABLE_NAME)
data class CardEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "mushroom") val mushroom: Mushroom,
    @ColumnInfo(name = "mushroomImg") val mushroomImg: String,
    @ColumnInfo(name = "latitude") val latitude: String,
    @ColumnInfo(name = "altitude") val altitude: String,
    @ColumnInfo(name = "date") val date: String
)
