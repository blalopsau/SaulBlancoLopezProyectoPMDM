package com.example.blancolopezsaulproyectopmdm.modelo.dao

import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula

interface PeliculasDao {
    fun getTodos():List<Pelicula>
}