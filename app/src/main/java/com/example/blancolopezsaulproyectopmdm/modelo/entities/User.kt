package com.example.blancolopezsaulproyectopmdm.modelo.entities

import com.google.gson.annotations.SerializedName

class User(
    var id:Int?,
    var email:String,
    @SerializedName("password") var psswd:String
)