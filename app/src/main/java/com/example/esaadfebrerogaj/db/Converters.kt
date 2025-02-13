package com.example.esaadfebrerogaj.db

import androidx.room.TypeConverter
import com.example.esaadfebrerogaj.domain.Card
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromCard(card: Card): String {
        return Gson().toJson(card)
    }

    @TypeConverter
    fun toCard(cardString: String): Card {
        return Gson().fromJson(cardString, object : TypeToken<Card>() {}.type)
    }

}
