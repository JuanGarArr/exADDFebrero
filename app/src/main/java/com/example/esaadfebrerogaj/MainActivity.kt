package com.example.esaadfebrerogaj

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.esaadfebrerogaj.data.ModelsDataRepository
import com.example.esaadfebrerogaj.data.local.ModelsXmlDataSource
import com.example.esaadfebrerogaj.data.local.room.ModelsDbDataSource
import com.example.esaadfebrerogaj.data.remote.ModelsMockDataSource
import com.example.esaadfebrerogaj.data.remote.firestore.ModelsFirestoreDataSource
import com.example.esaadfebrerogaj.db.DatabaseProvider
import com.example.esaadfebrerogaj.domain.Album
import com.example.esaadfebrerogaj.domain.Card
import com.example.esaadfebrerogaj.domain.Mushroom
import com.google.gson.Gson
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    //examExersice1()
    //examExersice2()
    //examExersice3()
    }


    private fun examExersice1() {
        val sharedRepository = ModelsDataRepository(
            localShared = ModelsXmlDataSource(this),
            localRoom = ModelsDbDataSource(
                DatabaseProvider.getDatabase(this)
            ),
            remoteMock = ModelsMockDataSource(),
            remoteFirestore = ModelsFirestoreDataSource()
        )

        val albums = sharedRepository.getAlbumList()
        albums.forEach { album ->
            Log.d("@dev", "Álbum: ${album.title}")
            Log.d("@dev", "Cromos:")
            Log.d("@dev", " - ${album.card.mushroom.name}: ${album.card}")
        }

        val newAlbum = Album(
            title = "Álbum de Setas Raras",
            card = Card(
                mushroom = Mushroom(
                    idMushroom = "6",
                    name = "Trufa Negra",
                    family = "Tuberaceae",
                    description = "Seta subterránea muy apreciada"
                ),
                mushroomImg = "foto_trufa.jpg",
                latitude = "12.0",
                altitude = "5.0",
                date = "10/08/2024"
            )
        )
        sharedRepository.setAlbum(newAlbum)
        Log.d("@dev", "Álbum creado: ${newAlbum.title}")

        val albumToDelete = albums.firstOrNull()
        albumToDelete?.let {
            sharedRepository.deleteAlbum(it)
            Log.d("@dev", "Álbum eliminado: ${it.title}")
        }

        val cardToDelete = albums.firstOrNull()?.card
        cardToDelete?.let {
            sharedRepository.deleteCard(it)
            Log.d("@dev", "Cromo eliminado: ${it.mushroom}")
        }

    }

    private fun examExersice2() {
        thread {
            val sharedRepository = ModelsDataRepository(
                localShared = ModelsXmlDataSource(this),
                localRoom = ModelsDbDataSource(DatabaseProvider.getDatabase(this)),
                remoteMock = ModelsMockDataSource(),
                remoteFirestore = ModelsFirestoreDataSource()
            )

            val albums = sharedRepository.getAlbumList()
            albums.forEach { album ->
                Log.d("@dev", "📖 Álbum: ${album.title}")
                Log.d("@dev", "   📌 Cromo:")
                Log.d("@dev", "      🏷️ Seta: ${album.card.mushroom.name}")
                Log.d("@dev", "      🖼️ Imagen: ${album.card.mushroomImg}")
                Log.d("@dev", "      📍 Ubicación: Latitud ${album.card.latitude}, Altitud ${album.card.altitude}")
                Log.d("@dev", "      📅 Fecha: ${album.card.date}")
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
            Log.d("@dev", "✅ Álbum creado: ${newAlbum.title}")

            val albumToDelete = albums.firstOrNull()
            albumToDelete?.let {
                sharedRepository.deleteAlbum(it)
                Log.d("@dev", "🗑️ Álbum eliminado: ${it.title}")
            }

        }
    }

    private fun examExersice3(){
        val sharedRepository = ModelsDataRepository(
            localShared = ModelsXmlDataSource(this),
            localRoom = ModelsDbDataSource(DatabaseProvider.getDatabase(this)),
            remoteMock = ModelsMockDataSource(),
            remoteFirestore = ModelsFirestoreDataSource()
        )

        //Evidentemente no funciona
        Log.d("@dev", sharedRepository.getAlbumList().toString())

    }
}