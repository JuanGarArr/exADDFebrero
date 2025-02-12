package com.example.esaadfebrerogaj

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.esaadfebrerogaj.data.ModelsDataRepository
import com.example.esaadfebrerogaj.data.local.ModelsXmlDataSource
import com.example.esaadfebrerogaj.data.remote.ModelsMockDataSource
import com.example.esaadfebrerogaj.domain.Album
import com.example.esaadfebrerogaj.domain.Card
import com.example.esaadfebrerogaj.domain.Mushroom

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initEx1Shared()
    }


    private fun initEx1Shared() {
        val sharedRepository = ModelsDataRepository(
            localShared = ModelsXmlDataSource(this),
            remoteMock = ModelsMockDataSource()
        )

        // Mostrar todos los álbumes con sus cromos y setas
        val albums = sharedRepository.getAlbumList()
        albums.forEach { album ->
            Log.d("@dev", "Álbum: ${album.title}")
            Log.d("@dev","Cromos:")
            Log.d("@dev"," - ${album.card.mushroom.name}: ${album.card}")
        }

        val newAlbum = Album(
            title = "Álbum de Setas Raras",
            card = Card(
                mushroom = Mushroom("6", "Trufa Negra", "Tuberaceae", "Seta subterránea muy apreciada"),
                mushroomImg = "foto_trufa.jpg",
                latitude = "12.0",
                altitude = "5.0",
                date = "10/08/2024"
            )
        )
        sharedRepository.setAlbum(newAlbum)
        Log.d("@dev","Álbum creado: ${newAlbum.title}")

        val albumToDelete = albums.firstOrNull()
        albumToDelete?.let {
            sharedRepository.deleteAlbum(it)
            Log.d("@dev","Álbum eliminado: ${it.title}")
        }

        val cardToDelete = albums.firstOrNull()?.card
        cardToDelete?.let {
            sharedRepository.deleteCard(it)
            Log.d("@dev","Cromo eliminado: ${it.mushroom.name}")
        }
    }
}