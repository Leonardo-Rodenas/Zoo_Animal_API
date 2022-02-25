package com.example.zooanimalapi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.zooanimalapi.dao.ZooAnimalDAO
import com.example.zooanimalapi.model.AnimalListItem
import com.example.zooanimalapi.service.ZooAnimalService

@Database(entities = [AnimalListItem::class], version = 1)
abstract class AnimalsDatabase : RoomDatabase() {

    abstract fun obtenListaAnimalesDelDao(): ZooAnimalDAO

    companion object {

        @Volatile
        private var baseDeDatosCreada: AnimalsDatabase? = null

        fun crearDatabase(context: Context): AnimalsDatabase {

            if (baseDeDatosCreada == null) {
                synchronized(this)
                {
                    baseDeDatosCreada = Room.databaseBuilder(
                        context,
                        AnimalsDatabase::class.java,
                        "base_De_Datos_Animales"
                    ).build()
                }
            }
            return baseDeDatosCreada!!
        }
    }

}