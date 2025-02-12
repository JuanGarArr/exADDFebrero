package com.example.esaadfebrerogaj.data.local.room

import com.example.esaadfebrerogaj.db.AppDatabase
import com.example.esaadfebrerogaj.domain.Album
import com.example.esaadfebrerogaj.domain.Card

class ModelsDbDataSource(private val database: AppDatabase) {

    private val modelsDao = database.modelsDao()

    fun getAlbumList(): List<Album> {
        return modelsDao.getAllAlbums().map { it.toModel() }
    }

    fun insertAlbum(album: Album) {
        modelsDao.insertAlbum(album.toEntity())
    }


    fun deleteAlbum(title: String) {
        modelsDao.deleteAlbum(title)
    }

    fun getCardList(): List<Card> {
        return modelsDao.getAllCards().map { it.toModel() }
    }

    fun getCardsByAlbum(albumTitle: String): List<Card> {
        return modelsDao.getCardsByAlbum(albumTitle).map { it.toModel() }
    }

    fun insertCard(card: Card) {
        modelsDao.insertCard(card.toEntity())
    }

    fun deleteCard(cardId: Int) {
        modelsDao.deleteCard(cardId)
    }
}
