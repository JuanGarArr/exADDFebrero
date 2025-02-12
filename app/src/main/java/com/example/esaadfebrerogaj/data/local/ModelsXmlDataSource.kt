package com.example.esaadfebrerogaj.data.local

import android.content.Context
import com.example.esaadfebrerogaj.domain.Album
import com.example.esaadfebrerogaj.domain.Card
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ModelsXmlDataSource (context: Context) {

    private val gson = Gson()

    private val sharedPref = context.getSharedPreferences("models.xml", Context.MODE_PRIVATE)

    fun setAlbum(album: Album) {
        val editor = sharedPref.edit()
        val json = gson.toJson(album)
        editor.putString(album.title, json).apply()
    }


    fun getAlbum(title: String): Album? {
        val json = sharedPref.getString(title, null) ?: return null
        return gson.fromJson(json, Album::class.java)
    }


    fun setAlbumList(albums: List<Album>) {
        val editor = sharedPref.edit()
        val json = gson.toJson(albums)
        editor.putString("albums", json).apply()
    }

    fun getAlbumList(): List<Album> {
        val json = sharedPref.getString("albums", null) ?: return emptyList()
        val type = object : TypeToken<List<Album>>() {}.type
        return gson.fromJson(json, type)
    }


    fun getCardList():List<Card>{
        val json = sharedPref.getString("cards", null) ?: return emptyList()
        val type = object : TypeToken<List<Card>>() {}.type
        return gson.fromJson(json, type)
    }

    fun deleteAlbum(title: String) {
        val editor = sharedPref.edit()
        editor.remove(title).apply()
    }

    fun deleteCard(card: Card){
        val editor = sharedPref.edit()
        editor.remove(card.toString()).apply()
    }




}

