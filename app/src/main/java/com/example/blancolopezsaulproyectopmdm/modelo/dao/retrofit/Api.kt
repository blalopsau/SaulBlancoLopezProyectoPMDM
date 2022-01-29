package com.example.blancolopezsaulproyectopmdm.modelo.dao.retrofit

import android.media.session.MediaSession
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Token
import com.example.blancolopezsaulproyectopmdm.modelo.entities.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("movies")
    fun getPeliculas(): Call<List<Pelicula>>

    @POST("users/signup")
    fun signup(@Body users: User): Call<User>

    @POST("users/login")
    fun login(@Body user: User): Call<Token>

}