package com.example.esaadfebrerogaj.data.remote.firestore

import com.example.esaadfebrerogaj.domain.Album
import com.example.esaadfebrerogaj.domain.Card
import com.example.esaadfebrerogaj.domain.Mushroom

fun MushroomFirestoreEntity.toDomain() = Mushroom(
    idMushroom = idMushroom,
    name = name,
    family = family,
    description = description
)

fun CardFirestoreEntity.toDomain() = Card(
    mushroom = mushroom.toDomain(),
    mushroomImg = mushroomImg,
    latitude = latitude,
    altitude = altitude,
    date = date
)

fun AlbumFirestoreEntity.toDomain(): Album {
    val cardList = try {
        cards as? List<CardFirestoreEntity> ?: emptyList()
    } catch (e: Exception) {
        emptyList<CardFirestoreEntity>()
    }

    return Album(
        title = title,
        card = cardList.firstOrNull()?.toDomain() ?: Card(
            mushroom = Mushroom("", "", "", ""),
            mushroomImg = "",
            latitude = "",
            altitude = "",
            date = ""
        )
    )
}

fun Mushroom.toFirestore() = MushroomFirestoreEntity(
    idMushroom = idMushroom,
    name = name,
    family = family,
    description = description
)

fun Card.toFirestore() = CardFirestoreEntity(
    id = mushroom.idMushroom,
    mushroom = mushroom.toFirestore(),
    mushroomImg = mushroomImg,
    latitude = latitude,
    altitude = altitude,
    date = date
)

fun Album.toFirestore() = AlbumFirestoreEntity(
    title = title,
    cards = listOf(card.toFirestore())
)
