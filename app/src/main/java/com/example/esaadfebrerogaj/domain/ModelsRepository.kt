package com.example.esaadfebrerogaj.domain

interface ModelsRepository {
    fun getAlbumList(): List<Album>
    fun getCardList(): List<Card>

    fun setAlbum(album: Album)

    fun deleteAlbum(album: Album)
    fun deleteCard(card: Card)
}