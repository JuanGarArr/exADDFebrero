package com.example.esaadfebrerogaj.data.remote.firestore

import com.example.esaadfebrerogaj.domain.Album
import com.google.firebase.firestore.FirebaseFirestore

class ModelsFirestoreDataSource {

    private val db = FirebaseFirestore.getInstance()
    private val albumCollection = db.collection("albums")

    fun saveAlbumToFirestore(album: Album, onComplete: (Boolean) -> Unit) {
        val albumFirestore = album.toFirestore()
        albumCollection.document(album.title).set(albumFirestore)
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener { onComplete(false) }
    }

    fun getAlbumsFromFirestore(onComplete: (List<Album>) -> Unit) {
        albumCollection.get()
            .addOnSuccessListener { result ->
                val albums = result.documents.mapNotNull { doc ->
                    doc.toObject(AlbumFirestoreEntity::class.java)?.toDomain()
                }
                onComplete(albums)
            }
            .addOnFailureListener {
                onComplete(emptyList())
            }
    }
}
