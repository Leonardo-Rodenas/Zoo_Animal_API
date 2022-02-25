package com.example.zooanimalapi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.zooanimalapi.database.AnimalsDatabase
import com.example.zooanimalapi.model.AnimalListItem
import com.example.zooanimalapi.repository.AnimalsRepo

class AnimalsViewModel(application: Application) : AndroidViewModel(application) {

    private var repositorio : AnimalsRepo

    init {

        val animalesDelDao = AnimalsDatabase.crearDatabase(application).obtenListaAnimalesDelDao()
        repositorio = AnimalsRepo(animalesDelDao)

    }

    fun traemeLoDelServer() {

        repositorio.obtenDataDelServer()

    }

    fun exponeDatosDeDB(): LiveData<List<AnimalListItem>> {
        return repositorio.exponeDatosDeBaseDeDatos()
    }

}