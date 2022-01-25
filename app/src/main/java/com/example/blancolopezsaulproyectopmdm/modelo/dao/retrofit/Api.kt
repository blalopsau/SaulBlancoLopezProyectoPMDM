package com.example.blancolopezsaulproyectopmdm.modelo.dao.retrofit

import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("movies")
    fun getPeliculas(): Call<List<Pelicula>>

    //TODO: declarar todos los metodos de la API siguiendo documentacion
}