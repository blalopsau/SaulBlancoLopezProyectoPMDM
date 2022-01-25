package com.example.blancolopezsaulproyectopmdm.modelo.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Pelicula(
    @SerializedName("title") var titulo: String,
    var genero: String,
    var director: String,
    var nota: String,
    var plataforma: String,
    @SerializedName("runtimeMinutes")var tiempo: String,
    var descripcion: String,
    var caratula: String,
    var tel: String
):Serializable