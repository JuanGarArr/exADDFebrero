package com.example.esaadfebrerogaj.data

import com.example.esaadfebrerogaj.data.local.ModelsXmlDataSource
import com.example.esaadfebrerogaj.data.remote.ModelsMockDataSource
import com.example.esaadfebrerogaj.domain.Album
import com.example.esaadfebrerogaj.domain.Card
import com.example.esaadfebrerogaj.domain.ModelsRepository

class ModelsDataRepository(
    private val localShared : ModelsXmlDataSource,
    private val remoteMock : ModelsMockDataSource
) : ModelsRepository{

    override fun getAlbumList(): List<Album> {
        var localAlbumList = localShared.getAlbumList()
        localAlbumList.ifEmpty {
            localAlbumList = remoteMock.getRemoteAlbumList()
            localAlbumList
        }
        return localAlbumList
    }

    override fun getCardList(): List<Card> {
        var localCardList = localShared.getCardList()
        localCardList.ifEmpty {
            localCardList = remoteMock.getRemoteCardList()
            localCardList
        }
        return localCardList
    }

    override fun setAlbum(album: Album) {
        localShared.setAlbum(album)
    }

    override fun deleteAlbum(album: Album) {
        localShared.deleteAlbum(album.title)

    }

    override fun deleteCard(card: Card) {
        val updatedAlbums = getAlbumList().map { album ->
            if (album.card.mushroom.id == card.mushroom.id) {
                album.copy(card = card.copy(mushroomImg = "", latitude = "", altitude = "", date = ""))
            } else album
        }
        localShared.setAlbumList(updatedAlbums)
    }


}