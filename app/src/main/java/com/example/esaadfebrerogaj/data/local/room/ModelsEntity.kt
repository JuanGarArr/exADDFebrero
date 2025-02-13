package com.example.esaadfebrerogaj.data.local.room

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.esaadfebrerogaj.domain.Card
import com.example.esaadfebrerogaj.domain.Mushroom


const val ALBUMS_TABLE_NAME = "albums"

@Entity(tableName = ALBUMS_TABLE_NAME)
data class AlbumEntity(
    @PrimaryKey @ColumnInfo(name = "title") val title: String,
    @ColumnInfo (name = "card") val card: String
)


