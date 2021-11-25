package com.example.blancolopezsaulproyectopmdm.modelo.dao

import android.app.Application
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula

class App : Application() {

    companion object {
        var peliculas:ArrayList<Pelicula> = ArrayList()
    }

    override fun onCreate() {
        super.onCreate()

        val dao=PeliculasDaoMockImpl()

        peliculas = dao.getTodos()
    }
}