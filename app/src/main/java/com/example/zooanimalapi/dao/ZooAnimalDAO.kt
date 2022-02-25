package com.example.zooanimalapi.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.zooanimalapi.model.AnimalList
import com.example.zooanimalapi.model.AnimalListItem

@Dao
interface ZooAnimalDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertarAnimales(animal:List<AnimalListItem>)

    @Query("SELECT * FROM tabla_animales_zoo")
    fun obtenerAnimales(): LiveData<List<AnimalListItem>>


}