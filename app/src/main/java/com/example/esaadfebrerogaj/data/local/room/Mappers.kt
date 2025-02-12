package com.example.esaadfebrerogaj.data.local.room

import com.example.esaadfebrerogaj.domain.Album
import com.example.esaadfebrerogaj.domain.Card
import com.example.esaadfebrerogaj.domain.Mushroom

fun MushroomEntity.toModel() = Mushroom(
    id = id,
    name = name,
    family = family,
    description = description
)

fun CardEntity.toModel() = Card(
    mushroom = mushroom.toModel(),
    mushroomImg = mushroomImg,
    latitude = latitude,
    altitude = altitude,
    date = date
)

fun Mushroom.toEntity() = MushroomEntity(
    id = id,
    name = name,
    family = family,
    description = description
)

fun Card.toEntity() = CardEntity(
    mushroom = mushroom.toEntity(),
    mushroomImg = mushroomImg,
    latitude = latitude,
    altitude = altitude,
    date = date
)

fun Album.toEntity() = AlbumEntity(
    title = title,
    card = card.toEntity()
)

fun AlbumEntity.toModel() = Album(
    title = title,
    card = card.toModel()
)