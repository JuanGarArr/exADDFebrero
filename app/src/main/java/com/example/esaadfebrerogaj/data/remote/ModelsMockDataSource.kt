package com.example.esaadfebrerogaj.data.remote

import com.example.esaadfebrerogaj.domain.Album
import com.example.esaadfebrerogaj.domain.Card
import com.example.esaadfebrerogaj.domain.Mushroom

class ModelsMockDataSource {

    val mushrooms = listOf(
        Mushroom("1", "Boletus", "Boletaceae", "Seta comestible muy apreciada"),
        Mushroom("2", "Amanita", "Amanitaceae", "Algunas especies son venenosas"),
        Mushroom("3", "Agaricus Campestris", "Agaricaceae", "Seta común en praderas"),
        Mushroom("4", "Cantharellus", "Cantharellaceae", "Conocida como rebozuelo"),
        Mushroom("5", "Lactarius", "Russulaceae", "Seta con látex lechoso")
    )

    val album1 = Album(
        title = "Álbum de Setas de Ávila",
        card = Card(
            mushroom = mushrooms[0],
            mushroomImg = "foto_boletus.jpg",
            latitude = "43.0",
            altitude = "4.0",
            date = "01/12/2025"
        )
    )

    val album2 = Album(
        title = "Álbum de Setas Comunes",
        card = Card(
            mushroom = mushrooms[1],
            mushroomImg = "foto_amanita.jpg",
            latitude = "10.0",
            altitude = "2.0",
            date = "05/06/2024"
        )
    )

    val albums = listOf(album1, album2)

    fun getRemoteAlbumList(): List<Album> {
        return albums
    }

    fun getRemoteCardList(): List<Card> {
        return albums.flatMap {
            listOf(it.card)
        }
    }


}