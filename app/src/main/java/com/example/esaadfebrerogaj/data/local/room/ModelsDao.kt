package com.example.esaadfebrerogaj.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ModelsDao {

    @Query("SELECT * FROM albums")
    fun getAllAlbums(): List<AlbumEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlbum(album: AlbumEntity)

    @Query("DELETE FROM albums")
    fun deleteAlbum(title: String)

    @Query("SELECT * FROM cards")
    fun getAllCards(): List<CardEntity>

    @Query("SELECT * FROM cards WHERE id = (SELECT name FROM albums WHERE title = :albumTitle)")
    fun getCardsByAlbum(albumTitle: String): List<CardEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCard(card: CardEntity)

    @Query("DELETE FROM cards WHERE id = :cardId")
    fun deleteCard(cardId: Int)

}