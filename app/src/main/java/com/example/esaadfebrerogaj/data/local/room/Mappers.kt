package com.example.esaadfebrerogaj.data.local.room

import com.example.esaadfebrerogaj.domain.Album
import com.example.esaadfebrerogaj.domain.Card
import com.example.esaadfebrerogaj.domain.Mushroom
import com.google.gson.Gson

fun MushroomEntity.toModel() = Mushroom(
    idMushroom = idMushroom,
    name = name,
    family = family,
    description = description
)

fun CardEntity.toModel() = Card(
    mushroom = Gson().fromJson(mushroom, Mushroom::class.java),
    mushroomImg = mushroomImg,
    latitude = latitude,
    altitude = altitude,
    date = date
)

fun AlbumEntity.toModel() = Album(
    title = title,
    card = Gson().fromJson(card, Card::class.java)
)

fun Mushroom.toEntity() = MushroomEntity(
    idMushroom = idMushroom,
    name = name,
    family = family,
    description = description
)

fun Card.toEntity() = CardEntity(
    mushroom = Gson().toJson(mushroom),
    mushroomImg = mushroomImg,
    latitude = latitude,
    altitude = altitude,
    date = date
)

fun Album.toEntity() = AlbumEntity(
    title = title,
    card = Gson().toJson(card)
)
