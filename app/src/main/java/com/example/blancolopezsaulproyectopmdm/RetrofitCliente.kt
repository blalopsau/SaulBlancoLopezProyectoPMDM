package com.example.blancolopezsaulproyectopmdm

import com.example.blancolopezsaulproyectopmdm.modelo.dao.retrofit.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    private fun getRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder().baseUrl("https://damapi.herokuapp.com/api/v1")
            .addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit
    }
    val apiRetrofit: Api = getRetrofit().create(Api::class.java)
}