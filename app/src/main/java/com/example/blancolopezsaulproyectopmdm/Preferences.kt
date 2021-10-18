package com.example.blancolopezsaulproyectopmdm

import android.content.Context

class Preferences(val context: Context) {
    val NOMBREARCHIVO = "MiBaseDatos"
    val pref = context.getSharedPreferences(NOMBREARCHIVO, 0)

    fun guardar(user: String, psswd: String) {
        pref.edit().putString("usuario", user).commit()
        pref.edit().putString("contraseña", psswd).commit()
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