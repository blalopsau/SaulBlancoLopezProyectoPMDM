package com.example.blancolopezsaulproyectopmdm.modelo.entities

import java.io.Serializable

data class Pelicula (var titulo:String, var genero:String,var director:String,var nota:String,var plataforma:String,var tiempo:String ,var descripcion:String,var caratula:String,var tel:String) :
    Serializable