package com.example.esaadfebrerogaj.data.local.room

import com.example.esaadfebrerogaj.domain.Album
import com.example.esaadfebrerogaj.domain.Card
import com.example.esaadfebrerogaj.domain.Mushroom

fun MushroomEntity.toModel() = Mushroom(
    idMushroom = idMushroom,
    name = name,
    family = family,
    description = description
)

fun CardEntity.toModel() = Card(
    mushroom = mushroom,
    mushroomImg = mushroomImg,
    latitude = latitude,
    altitude = altitude,
    date = date
)

fun Mushroom.toEntity() = MushroomEntity(
    idMushroom = idMushroom,
    name = name,
    family = family,
    description = description
)

fun Card.toEntity() = CardEntity(
    mushroom = mushroom.toString(),
    mushroomImg = mushroomImg,
    latitude = latitude,
    altitude = altitude,
    date = date
)

fun Album.toEntity() = AlbumEntity(
    title = title,
    card = card.toString()
)

fun AlbumEntity.toModel() = Album(
    title = title,
    card = card.toString()
)