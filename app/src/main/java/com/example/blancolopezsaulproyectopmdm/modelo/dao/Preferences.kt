package com.example.blancolopezsaulproyectopmdm.modelo.dao

import android.content.Context

class Preferences(val context: Context) {
    val NOMBREARCHIVO = "MiBaseDatos"
    val pref = context.getSharedPreferences(NOMBREARCHIVO, 0)

    fun guardar(token: String) {
        pref.edit().putString("token", token).commit()
    }

    fun recuperarDatos(datoARecuperar: String): String? {
        if (datoARecuperar == "nombre") {
            return pref.getString("usuario", "")
        } else if (datoARecuperar == "contraseña") {
            return pref.getString("contraseña", "")
        }
        return null
    }
}