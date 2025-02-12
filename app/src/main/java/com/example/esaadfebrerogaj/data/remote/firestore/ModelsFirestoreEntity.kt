package com.example.esaadfebrerogaj.data.remote.firestore

import com.google.firebase.firestore.PropertyName

data class MushroomFirestoreEntity(
    @get:PropertyName("idMushroom") @set:PropertyName("idMushroom") var idMushroom: String = "",
    @get:PropertyName("name") @set:PropertyName("name") var name: String = "",
    @get:PropertyName("family") @set:PropertyName("family") var family: String = "",
    @get:PropertyName("description") @set:PropertyName("description") var description: String = ""
)

data class CardFirestoreEntity(
    @get:PropertyName("id") @set:PropertyName("id") var id: String = "",
    @get:PropertyName("mushroom") @set:PropertyName("mushroom") var mushroom: MushroomFirestoreEntity = MushroomFirestoreEntity(),
    @get:PropertyName("mushroomImg") @set:PropertyName("mushroomImg") var mushroomImg: String = "",
    @get:PropertyName("latitude") @set:PropertyName("latitude") var latitude: String = "",
    @get:PropertyName("altitude") @set:PropertyName("altitude") var altitude: String = "",
    @get:PropertyName("date") @set:PropertyName("date") var date: String = ""
)

data class AlbumFirestoreEntity(
    @get:PropertyName("title") @set:PropertyName("title") var title: String = "",
    @get:PropertyName("cards") @set:PropertyName("cards") var cards: List<CardFirestoreEntity> = emptyList()
)