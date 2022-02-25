package com.example.zooanimalapi.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.zooanimalapi.client.ZooAnimalsClient
import com.example.zooanimalapi.dao.ZooAnimalDAO
import com.example.zooanimalapi.model.AnimalListItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimalsRepo (private val animalesDao: ZooAnimalDAO) {

    private val service = ZooAnimalsClient.obtenCliente()
    val miLiveData = animalesDao.obtenerAnimales()

    fun obtenDataDelServer() {

        val call = service.listaAnimales()
        call.enqueue(object : Callback<List<AnimalListItem>> {
            override fun onResponse(
                call: Call<List<AnimalListItem>>,
                response: Response<List<AnimalListItem>>
            ) {
                CoroutineScope(Dispatchers.IO).launch {
                    Log.v("log_enrepo1", response.body().toString())
                    response.body()?.let {

                        Log.v("log_enrepo2", response.body().toString())
                        animalesDao.insertarAnimales(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<AnimalListItem>>, t: Throwable) {
                call.cancel()
            }

        })
    }

    fun exponeDatosDeBaseDeDatos(): LiveData<List<AnimalListItem>> {
        return animalesDao.obtenerAnimales()
    }
}