package com.example.zooanimalapi.client

import com.example.zooanimalapi.service.ZooAnimalService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ZooAnimalsClient {

    companion object {

        private val urlBase = "https://zoo-animal-api.herokuapp.com/"

        fun obtenCliente(): ZooAnimalService {
            val retrofit = Retrofit.Builder().baseUrl(urlBase).addConverterFactory(
                GsonConverterFactory.create()
            ).build()
            return retrofit.create(ZooAnimalService::class.java)
        }

        //usar para pruebas, comentar obtencliente de arriba y descomentar el de abajo
/*
          fun obtenCliente(url:String): CriptomonedasService{
               val retrofit = Retrofit.Builder().baseUrl(url).addConverterFactory(
                   GsonConverterFactory.create()).build()
               return retrofit.create(CriptomonedasService::class.java)
           }*/

    }


}