package com.example.blancolopezsaulproyectopmdm.modelo.dao.retrofit

import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Token
import com.example.blancolopezsaulproyectopmdm.modelo.entities.User
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @GET("movies")
    fun getAll(@Header("Authorization:") token:String): Call<List<Pelicula>>

    @POST("users/signup")
    fun signup(@Body users: User): Call<User>

    @POST("users/login")
    fun login(@Body user: User): Call<Token>

    @DELETE("movies")
    fun delete(@Header("Authorization:") token: String,
    @Body pelicula: Pelicula): Call<Unit>
}