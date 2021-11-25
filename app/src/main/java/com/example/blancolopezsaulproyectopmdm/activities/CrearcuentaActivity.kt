package com.example.blancolopezsaulproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityCrearcuentaBinding

import android.util.Patterns
import android.widget.Toast
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.modelo.dao.Preferences
import java.util.regex.Pattern


class CrearcuentaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCrearcuentaBinding

    private  lateinit var pref: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crearcuenta)
        pref = Preferences(applicationContext)

        binding = ActivityCrearcuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btAceptar.setOnClickListener {//En el botón aceptar creamos el usuario en el sharedPreferences y pasamos a la pantalla de login
            val intent = Intent(this, MainActivity::class.java)
            comprobarDatos()//Comprobamos que la contraseña cumpla los parámetros

            if (comprobarDatos() == true) {//Si los datos son correctos cargamos los datos en el sharedPreferences

                val usuario = binding.tietNombreUsuario.text.toString().trim()
                val contraseña = binding.tietContraseA.text.toString().trim()

                pref.guardar(usuario, contraseña)
                startActivity(intent)
            }
        }
    }

    private fun validarEmail(email: String): Boolean { //Metodo que comprueba si el email es correcto
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    private fun comprobarDatos(): Boolean {//Metodo que comprueba si el email es correcto y las contraseñas son validas y coinciden
        val contraseña = binding.tietContraseA.text.toString()
        val repcontraseña = binding.tietRepetirContraseA.text.toString()

        if (validarEmail(binding.tietEmail.text.toString()) == false) {//Si el email es incorrecto
            Toast.makeText(this, "El email no es correcto", Toast.LENGTH_SHORT)
                .show()//Mensaje de que el email es incorrecto
            return false
        } else if (contraseña.length < 5 || contraseña.length > 10) {//Comprobamos la longitud de la contraseña
            Toast.makeText(this, "La contraseña no tiene la longitud correcta", Toast.LENGTH_SHORT)
                .show()//Mensaje de que el email es incorrecto
            return false
        } else if (!contraseña.equals(repcontraseña)) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT)
                .show()//Mensaje de que el email es incorrecto
            return false
        }
        return true
    }

}