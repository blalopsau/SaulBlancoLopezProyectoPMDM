package com.example.blancolopezsaulproyectopmdm.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityEditarPeliculaBinding
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import android.provider.MediaStore
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.example.blancolopezsaulproyectopmdm.RetrofitCliente
import com.example.blancolopezsaulproyectopmdm.modelo.dao.Preferences
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.jar.Manifest

class EditarPeliculaActivity : AppCompatActivity() {

    private lateinit var pelicula: Pelicula

    private lateinit var binding: ActivityEditarPeliculaBinding
    private lateinit var pref: Preferences

    val context=this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_pelicula)

        binding = ActivityEditarPeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = Preferences(applicationContext)

        val id = intent.extras?.get("id") as String?
        val token = pref.sacarToken()
        val call = RetrofitCliente.apiRetrofit.getId("Bearer" + token, id)

        call.enqueue(object : Callback<Pelicula> {
            override fun onFailure(call: Call<Pelicula>, t: Throwable) {
                Log.d("respuesta: onFailure", t.toString())
            }

            override fun onResponse(call: Call<Pelicula>, response: Response<Pelicula>) {
                if (response.code() > 299 || response.code() < 200) {
                    val adb = AlertDialog.Builder(context)
                    adb.setIcon(R.drawable.outline_error_24)
                    adb.setTitle("Error en la recuperación de la película")
                    adb.setMessage("La película no pudo recuperarse correctamente")
                    adb.setPositiveButton("Aceptar") { dialog, which -> }
                    adb.show()
                } else {
                    val titulo = response.body()?.titulo.toString()
                    val caratula = response.body()?.caratula.toString()
                    val descripcion = response.body()?.descripcion.toString()
                    val director = response.body()?.director.toString()
                    val genero = response.body()?.genero.toString()
                    val nota = response.body()?.nota.toString()
                    val plataforma = response.body()?.plataforma.toString()
                    val tel = response.body()?.tel.toString()
                    val tiempo = response.body()?.tiempo.toString()

                    pelicula = Pelicula(null,titulo,genero,director,nota,plataforma,tiempo,descripcion,caratula,tel)
                    rellenarDatos()
                }
            }
        })

        binding.btEditar.setOnClickListener{
            val titulo=binding.etAnadirTitulo.text.toString()
            val genero=binding.etGenero.text.toString()
            val director=binding.etDirectorDetalle.text.toString()
            val nota=binding.etNotaDetalle.text.toString()
            val plataforma=binding.etPlataforma.text.toString()
            val tiempo=binding.etTiempo.text.toString()
            val descripcion=binding.etDescripcion.text.toString()
            val caratula=binding.etUrlImagenEditar.text.toString()
            val tel=binding.etTelefonoEditar.text.toString()

            pelicula = Pelicula(id,titulo,genero,director,nota,plataforma,tiempo,descripcion,caratula,tel)

            val call = RetrofitCliente.apiRetrofit.editar("Bearer " + token,pelicula)
            call.enqueue(object : Callback<Pelicula> {
                override fun onFailure(call: Call<Pelicula>, t: Throwable) {
                    Log.d("respuesta: onFailure", t.toString())
                }

                override fun onResponse(call: Call<Pelicula>, response: Response<Pelicula>) {
                    if (response.code() > 299 || response.code() < 200) {
                        val adb = AlertDialog.Builder(context)
                        adb.setIcon(R.drawable.outline_error_24)
                        adb.setTitle("Error en la recuperación de la película")
                        adb.setMessage("La película no pudo recuperarse correctamente")
                        adb.setPositiveButton("Aceptar") { dialog, which -> }
                        adb.show()
                    } else {
                        val adb = AlertDialog.Builder(applicationContext)
                        adb.setIcon(R.drawable.outline_check_circle_24)
                        adb.setTitle("Actualización de la película")
                        adb.setMessage("La película fue actualizada correctamente")
                        adb.setPositiveButton("Aceptar") { dialog, which -> }
                        adb.show()
                        finish()
                    }
                }
            })
        }
        binding.btPrevisualizarFoto.setOnClickListener{
            Picasso.get().load(binding.etUrlImagenEditar.text.toString()).into(binding.ivCaratulaEditar)
        }
    }

    fun rellenarDatos() {
        Picasso.get().load(pelicula.caratula).into(binding.ivCaratulaEditar)
        binding.etAnadirTitulo.setText(pelicula.titulo)
        binding.etDescripcion.setText( pelicula.descripcion)
        binding.etNotaDetalle.setText(pelicula.nota)
        binding.etGenero.setText(pelicula.genero)
        binding.etPlataforma.setText(pelicula.plataforma)
        binding.etDirectorDetalle.setText(pelicula.director)
        binding.etTiempo.setText(pelicula.tiempo)
        binding.etTelefonoEditar.setText(pelicula.tel)
    }
}