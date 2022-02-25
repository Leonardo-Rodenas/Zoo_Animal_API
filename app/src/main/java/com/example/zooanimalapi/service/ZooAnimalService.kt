package com.example.zooanimalapi.service

import com.example.zooanimalapi.model.AnimalListItem
import retrofit2.Call
import retrofit2.http.GET

interface ZooAnimalService {

    @GET("animals/rand/10")

    fun listaAnimales () : Call <List<AnimalListItem>>


}

// direccion completa
// https://zoo-animal-api.herokuapp.com/animals/rand/10

// url base
// https://zoo-animal-api.herokuapp.com/

// endpoint
// animals/rand/10