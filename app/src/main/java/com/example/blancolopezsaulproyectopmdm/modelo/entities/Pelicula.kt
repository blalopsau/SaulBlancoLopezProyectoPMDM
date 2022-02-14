package com.example.blancolopezsaulproyectopmdm.modelo.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Pelicula(
    var id:String?,
    @SerializedName("title") var titulo: String,
    @SerializedName("genre")var genero: String?,
    @SerializedName("directorFullname")var director: String?,
    @SerializedName("rating")var nota: String,
    @SerializedName("platform")var plataforma: String?,
    @SerializedName("runtimeMinutes")var tiempo: String,
    @SerializedName("description")var descripcion: String?,
    @SerializedName("imageUrl")var caratula: String?,
    @SerializedName("directorPhone")var tel: String?
):Serializable