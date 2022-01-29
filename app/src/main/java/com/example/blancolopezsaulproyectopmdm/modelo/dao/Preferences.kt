package com.example.blancolopezsaulproyectopmdm.modelo.dao

import android.content.Context

class Preferences(val context: Context) {
    val NOMBREARCHIVO = "MiBaseDatos"
    val pref = context.getSharedPreferences(NOMBREARCHIVO, 0)

    fun guardar(token: String) {
        pref.edit().putString("token", token).commit()
    }
}