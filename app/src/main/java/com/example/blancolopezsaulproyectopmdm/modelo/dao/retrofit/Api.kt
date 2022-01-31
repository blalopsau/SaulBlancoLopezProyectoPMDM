package com.example.blancolopezsaulproyectopmdm.modelo.dao.retrofit

import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Token
import com.example.blancolopezsaulproyectopmdm.modelo.entities.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface Api {
    @GET("movies")
    fun getAll(@Header("Authorization:") token:String): Call<Token>

    @POST("users/signup")
    fun signup(@Body users: User): Call<User>

    @POST("users/login")
    fun login(@Body user: User): Call<Token>

}