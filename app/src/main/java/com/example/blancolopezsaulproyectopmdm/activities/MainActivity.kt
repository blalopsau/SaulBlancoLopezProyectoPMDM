package com.example.blancolopezsaulproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.blancolopezsaulproyectopmdm.modelo.dao.Preferences
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    private  lateinit var pref: Preferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        pref = Preferences(applicationContext)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = pref.recuperarDatos("nombre")
        val contraseña = pref.recuperarDatos("contraseña")

        binding.tietUsuario.setText(nombre)
        binding.tietContrasenha.setText(contraseña)

        binding.btCrearCuenta.setOnClickListener {//Cuando se pulsa el boton crear se va a la pantalla CrearcuentaActivity
            val intent = Intent(this, CrearcuentaActivity::class.java)
            startActivity(intent)
        }

        binding.btLogin.setOnClickListener {
            if (binding.tietUsuario.text.toString().length==0 || binding.tietContrasenha.text.toString().length==0 ){

                val adb = AlertDialog.Builder(this)
                adb.setIcon(R.drawable.outline_error_24)
                adb.setTitle("Datos incorrectos")
                adb.setMessage("El usuario y/o la contraseña están vacíos.")
                adb.setPositiveButton("Aceptar") { dialog, which ->}
                adb.show()
            }
            else if (!nombre.equals(binding.tietUsuario.text.toString())) {
                binding.tietUsuario.setError("El usuario no existe")
            } else if (!contraseña.equals(binding.tietContrasenha.text.toString())) {
                binding.tietContrasenha.setError("La contraseña no es correcta")
            } else {
                val intent = Intent(this, PeliculasActivity::class.java)
                startActivity(intent)
            }
        }
    }
}