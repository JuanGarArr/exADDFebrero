package com.example.esaadfebrerogaj.data

import com.example.esaadfebrerogaj.data.local.ModelsXmlDataSource
import com.example.esaadfebrerogaj.data.local.room.ModelsDbDataSource
import com.example.esaadfebrerogaj.data.remote.ModelsMockDataSource
import com.example.esaadfebrerogaj.data.remote.firestore.ModelsFirestoreDataSource
import com.example.esaadfebrerogaj.domain.Album
import com.example.esaadfebrerogaj.domain.Card
import com.example.esaadfebrerogaj.domain.ModelsRepository

class ModelsDataRepository(
    private val localShared : ModelsXmlDataSource,
    private val localRoom : ModelsDbDataSource,
    private val remoteMock : ModelsMockDataSource
) : ModelsRepository{

    override fun getAlbumList(): List<Album> {
        var localAlbumList = localShared.getAlbumList()

        if (localAlbumList.isEmpty()) {
            localAlbumList = remoteMock.getRemoteAlbumList()
            localAlbumList.forEach { album ->
                localRoom.insertAlbum(album)
            }
        }
        return localAlbumList
    }

    override fun setAlbum(album: Album) {
        localShared.setAlbum(album)
        localRoom.insertAlbum(album)
    }

    override fun deleteAlbum(album: Album) {
        localShared.deleteAlbum(album.title)
        localRoom.deleteAlbum(album.title)

    }



}