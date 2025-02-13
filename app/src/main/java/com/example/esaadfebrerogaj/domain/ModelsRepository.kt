package com.example.esaadfebrerogaj.domain

interface ModelsRepository {
    fun getAlbumList(): List<Album>
    fun setAlbum(album: Album)
    fun deleteAlbum(album: Album)
}