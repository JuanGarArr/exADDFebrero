package com.example.esaadfebrerogaj.domain

data class Mushroom(
    val idMushroom: String,
    val name:String,
    val family:String,
    val description:String
)

data class Card(
    val mushroom: Mushroom,
    val mushroomImg:String,
    val latitude: String,
    val altitude:String,
    val date:String
)

data class Album(
    val title:String,
    val card: Card
)