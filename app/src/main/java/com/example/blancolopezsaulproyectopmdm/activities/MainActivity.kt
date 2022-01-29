package com.example.blancolopezsaulproyectopmdm.activities

import android.content.DialogInterface
import android.content.Intent
import android.media.session.MediaSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.example.blancolopezsaulproyectopmdm.modelo.dao.Preferences
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.RetrofitCliente
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityMainBinding
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Token
import com.example.blancolopezsaulproyectopmdm.modelo.entities.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var pref: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val context = this
        pref = Preferences(applicationContext)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btCrearCuenta.setOnClickListener {//Cuando se pulsa el boton crear se va a la pantalla CrearcuentaActivity
            val intent = Intent(this, CrearcuentaActivity::class.java)
            startActivity(intent)
        }

        binding.btLogin.setOnClickListener {
            val usuario = binding.tietUsuario.text.toString()
            val contrasenha = binding.tietContrasenha.text.toString()

            if (binding.tietUsuario.text.toString().length == 0 || binding.tietContrasenha.text.toString().length == 0) {

                val adb = AlertDialog.Builder(this)
                adb.setIcon(R.drawable.outline_error_24)
                adb.setTitle("Datos incorrectos")
                adb.setMessage("El usuario y/o la contraseña están vacíos.")
                adb.setPositiveButton("Aceptar") { dialog, which -> }
                adb.show()
            } else {

                val call: Call<Token> = RetrofitCliente.apiRetrofit.login(User(null,usuario,contrasenha)) //Llamamos a Retrofit

                call.enqueue(object : Callback<Token> {
                    override fun onFailure(call: Call<Token>, t: Throwable) {
                        Log.d("respuesta: onFailure", t.toString())
                    }

                    override fun onResponse(call: Call<Token>, response: Response<Token>) {
                        if (response.code() > 299 || response.code() < 200) {
                            val adb = AlertDialog.Builder(context)
                            adb.setIcon(R.drawable.outline_error_24)
                            adb.setTitle("Inicio de sesión fallido")
                            adb.setMessage("El usuario o la contraseña no coinciden con ningún usuario")
                            adb.setPositiveButton("Aceptar") { dialog, which -> }
                            adb.show()
                        } else {
                            val token = response.body()?.token.toString()
                           pref.guardar(token)
                            val intent = Intent(context, PeliculasActivity::class.java)
                            startActivity(intent)
                        }
                    }
                })
            }
        }
    }
}