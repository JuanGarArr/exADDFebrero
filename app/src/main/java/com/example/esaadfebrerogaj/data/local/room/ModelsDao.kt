package com.example.esaadfebrerogaj.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ModelsDao {

    @Query("SELECT title, card FROM albums")
    fun getAllAlbums(): List<AlbumEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlbum(album: AlbumEntity)

    @Query("DELETE FROM albums WHERE title = :title")
    fun deleteAlbum(title: String)

    @Query("SELECT * FROM cards")
    fun getAllCards(): List<CardEntity>

    @Query("SELECT card FROM albums WHERE title = :albumTitle")
    fun getCardJsonByAlbum(albumTitle: String): String?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCard(card: CardEntity)

    @Query("DELETE FROM cards WHERE id = :cardId")
    fun deleteCard(cardId: Int)


}