package com.example.blancolopezsaulproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityDetallesPeliculaBinding
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import com.squareup.picasso.Picasso
import android.graphics.Color
import androidx.core.graphics.drawable.DrawableCompat
import android.graphics.drawable.Drawable
import android.net.Uri
import android.text.TextUtils
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.blancolopezsaulproyectopmdm.RetrofitCliente
import com.example.blancolopezsaulproyectopmdm.modelo.dao.Preferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetallesPeliculaActivity : AppCompatActivity() {

    private lateinit var pelicula: Pelicula
    private lateinit var binding: ActivityDetallesPeliculaBinding
    private lateinit var pref: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_pelicula)


        binding = ActivityDetallesPeliculaBinding.inflate(layoutInflater)
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
                    val adb = AlertDialog.Builder(applicationContext)
                    adb.setIcon(R.drawable.outline_error_24)
                    adb.setTitle("Error en el borrado")
                    adb.setMessage("La película no pudo eliminarse correctamente")
                    adb.setPositiveButton("Aceptar") { dialog, which -> }
                    adb.show()
                } else if (response.code() == 401) {
                    pref.guardar("")
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

                    pelicula = Pelicula(
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

                    rellenarDatos()
                }
            }
        })
    }

    fun rellenarDatos() {
        Picasso.get().load(pelicula.caratula).into(binding.ivCaratulaDetalle)
        Picasso.get().load(pelicula.caratula).into(binding.ivCaratulaDetalle)
        binding.tvTituloDetalle.text = pelicula.titulo
        binding.tvDescripcionDetalle.text = pelicula.descripcion
        binding.rbNota.rating = pelicula.nota.toFloat()

        if (pelicula.nota.toFloat() < 5) {
            val progress: Drawable = binding.rbNota.getProgressDrawable()
            DrawableCompat.setTint(progress, Color.RED)
        }
        binding.tvGeneroDetalle.text = pelicula.genero
        binding.tvPlataformaDetalle.text = pelicula.plataforma
        binding.tvDirectorDetalle.text = pelicula.director
        binding.tvTiempoDetalle.text = pelicula.tiempo
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_borrar -> {
                val context = this

                val token = pref.sacarToken()
                val id = intent.extras?.get("id") as String?
                pelicula.id = id
                val call = RetrofitCliente.apiRetrofit.delete(
                    "Bearer" + token,
                    pelicula.id!!
                ) //Llamamos a Retrofit

                call.enqueue(object : Callback<Pelicula> {
                    override fun onFailure(call: Call<Pelicula>, t: Throwable) {
                        Log.d("respuesta: onFailure", t.toString())
                    }

                    override fun onResponse(call: Call<Pelicula>, response: Response<Pelicula>) {
                        if (response.code() > 299 || response.code() < 200) {
                            val adb = AlertDialog.Builder(context)
                            adb.setIcon(R.drawable.outline_error_24)
                            adb.setTitle("Error en el borrado")
                            adb.setMessage("La película no pudo eliminarse correctamente")
                            adb.setPositiveButton("Aceptar") { dialog, which -> }
                            adb.show()
                        } else if (response.code() == 401 || response.code() == 500) {
                            val adb = AlertDialog.Builder(context)
                            adb.setIcon(R.drawable.outline_error_24)
                            adb.setTitle("Inicio de sesión caducado")
                            adb.setMessage("La sesión ha caducado, inicie desión de nuevo")
                            adb.setPositiveButton("Aceptar") { dialog, which -> }
                            adb.show()
                            pref.guardar("")
                        } else {
                            Toast.makeText(
                                context,
                                "La pelicula ha sido eliminada correctamente",
                                Toast.LENGTH_SHORT
                            ).show()
                            finish()
                        }
                    }
                })
            }
            R.id.menu_llamar -> {
                val numero: String? = pelicula.tel
                if (!TextUtils.isEmpty(numero)) {
                    val dial = "tel:$numero"
                    startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(dial)))
                } else {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
                return false
            }
        }
        return super.onOptionsItemSelected(item)
    }
}