package com.example.blancolopezsaulproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityDetallesPeliculaBinding
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import com.squareup.picasso.Picasso
import android.text.method.ScrollingMovementMethod
import android.graphics.Color
import androidx.core.graphics.drawable.DrawableCompat
import android.graphics.drawable.Drawable
import android.net.Uri
import android.provider.ContactsContract
import android.provider.MediaStore
import android.text.TextUtils
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.blancolopezsaulproyectopmdm.modelo.dao.App
import java.util.jar.Manifest

class DetallesPeliculaActivity : AppCompatActivity() {

    private lateinit var pelicula: Pelicula

    private lateinit var binding: ActivityDetallesPeliculaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_pelicula)

        binding = ActivityDetallesPeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pelicula = intent.extras?.get("pelicula") as Pelicula

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
        when(item.itemId){
            R.id.menu_borrar ->{
                App.peliculas.remove(pelicula)
                finish()
            }
            R.id.menu_llamar ->{
                val numero: String = pelicula.tel
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