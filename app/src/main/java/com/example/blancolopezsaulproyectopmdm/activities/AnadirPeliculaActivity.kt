package com.example.blancolopezsaulproyectopmdm.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.RetrofitCliente
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityAnadirPeliculaBinding
import com.example.blancolopezsaulproyectopmdm.modelo.dao.Preferences
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Token
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Matcher
import java.util.regex.Pattern

class AnadirPeliculaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnadirPeliculaBinding
    private val SELECCIONADA = 100
    var imageUri: Uri? = null

    private lateinit var pref: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        pref = Preferences(applicationContext)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_pelicula)

        binding = ActivityAnadirPeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btAnadirPelicula.setOnClickListener {
            val titulo = binding.etAnadirTitulo.text.toString()
            val genero = binding.etAnadirGenero.text.toString()
            val director = binding.etAnadirDirector.text.toString()
            val nota = binding.etAnadirNota.text.toString()
            val plataforma = binding.etAnadirPlataforma.text.toString()
            val tiempo = binding.etAnadirTiempo.text.toString()
            val descripcion = binding.etAnadirDescripcion.text.toString()
            val caratula = binding.etUrlImagen.text.toString()
            val tel = binding.etAnadirTelefono.text.toString()

            val pel = Pelicula(
                null,
                titulo,
                genero,
                director,
                nota,
                plataforma,
                tiempo,
                descripcion,
                caratula,
                tel
            )

            if (titulo == "" || genero == "" || director == "" || nota == "" || plataforma == "" || tiempo == "" || descripcion == "" || tel == "") {
                val adb = AlertDialog.Builder(this)
                adb.setIcon(R.drawable.outline_error_24)
                adb.setTitle("Campos vacios")
                adb.setMessage("Algún campo está vacio, porfavor rellene todos los campos")
                adb.setPositiveButton("Aceptar") { dialog, which -> }
                adb.show()
            } else {

                val token=pref.sacarToken()
                val call = RetrofitCliente.apiRetrofit.crear("Bearer" + token,pel)

                call.enqueue(object : Callback<Unit> {
                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        Log.d("respuesta: onFailure", t.toString())
                    }

                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        if (response.code() > 299 || response.code() < 200) {
                            val adb = AlertDialog.Builder(applicationContext)
                            adb.setIcon(R.drawable.outline_error_24)
                            adb.setTitle("Error en el borrado")
                            adb.setMessage("La película no pudo eliminarse correctamente")
                            adb.setPositiveButton("Aceptar") { dialog, which -> }
                            adb.show()
                        } else {
                            Toast.makeText(applicationContext, "La pelicula ha sido creada correctamente", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    }
                })
            }
        }
        binding.btPrevisualizar.setOnClickListener{
            Picasso.get().load(binding.etUrlImagen.text.toString()).into(binding.ivCaratulaAAdir)
        }
    }
}