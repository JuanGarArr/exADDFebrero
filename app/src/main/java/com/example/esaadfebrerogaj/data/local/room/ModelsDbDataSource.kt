package com.example.esaadfebrerogaj.data.local.room

import com.example.esaadfebrerogaj.db.AppDatabase
import com.example.esaadfebrerogaj.db.toEntity
import com.example.esaadfebrerogaj.db.toModel
import com.example.esaadfebrerogaj.domain.Album
import com.example.esaadfebrerogaj.domain.Card
import com.google.gson.Gson

class ModelsDbDataSource(private val database: AppDatabase) {

    private val modelsDao = database.modelsDao()

    fun getAlbumList(): List<Album> {
        return modelsDao.getAllAlbums().map {
            it.toModel()
        }
    }

    fun insertAlbum(album: Album) {
        modelsDao.insertAlbum(album.toEntity())
    }

    fun deleteAlbum(title: String) {
        modelsDao.deleteAlbum(title)
    }


    fun getCardsByAlbum(albumTitle: String): List<Card> {
        val cardJson = modelsDao.getCardJsonByAlbum(albumTitle)
        return cardJson?.let { listOf(Gson().fromJson(it, Card::class.java)) } ?: emptyList() // Convertir JSON a `Card`
    }


    fun deleteCard(cardId: Int) {
        modelsDao.deleteCard(cardId)
    }
}

