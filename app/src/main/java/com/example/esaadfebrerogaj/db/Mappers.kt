package com.example.esaadfebrerogaj.db

import com.example.esaadfebrerogaj.data.local.room.AlbumEntity
import com.example.esaadfebrerogaj.domain.Album
import com.example.esaadfebrerogaj.domain.Card
import com.example.esaadfebrerogaj.domain.Mushroom
import com.google.gson.Gson


fun AlbumEntity.toModel() = Album(
    title = title,
    card = Gson().fromJson(card, Card::class.java)
)


fun Album.toEntity() = AlbumEntity(
    title = title,
    card = Gson().toJson(card)
)
