package com.example.esaadfebrerogaj.data

import com.example.esaadfebrerogaj.data.local.ModelsXmlDataSource
import com.example.esaadfebrerogaj.data.local.room.ModelsDbDataSource
import com.example.esaadfebrerogaj.data.remote.ModelsMockDataSource
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
        localAlbumList.ifEmpty {
            localAlbumList = remoteMock.getRemoteAlbumList()
            localAlbumList.forEach{ album ->
                localRoom.insertAlbum(album)
            }
        }
        return localAlbumList
    }

    override fun getCardList(): List<Card> {
        var localCardList = localShared.getCardList()
        localCardList.ifEmpty {
            localCardList = remoteMock.getRemoteCardList()
            localCardList.forEach { card ->
                localRoom.insertCard(card)
            }
        }
        return localCardList
    }

    override fun setAlbum(album: Album) {
        localShared.setAlbum(album)
        localRoom.insertAlbum(album)
    }

    override fun deleteAlbum(album: Album) {
        localShared.deleteAlbum(album.title)
        localRoom.deleteAlbum(album.title)

    }

    override fun deleteCard(card: Card) {
        val cardMushroomId = card.mushroom.idMushroom
        localRoom.deleteCard(cardMushroomId.toIntOrNull() ?: return)

        val updatedAlbums = getAlbumList().map { album ->
            if (album.card.mushroom.idMushroom == cardMushroomId) {
                album.copy(card = card.copy(mushroomImg = "", latitude = "", altitude = "", date = ""))
            } else album
        }
        localShared.setAlbumList(updatedAlbums)
    }

}