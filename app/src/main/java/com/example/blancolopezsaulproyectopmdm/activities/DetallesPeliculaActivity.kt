package com.example.blancolopezsaulproyectopmdm.activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityDetallesPeliculaBinding
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import com.squareup.picasso.Picasso
import android.text.method.ScrollingMovementMethod
import java.net.URL
import android.content.Intent





class DetallesPeliculaActivity : AppCompatActivity() {

    companion object {
        lateinit var pelicula: Pelicula
    }

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
        binding.tvNotaDetalle.text = pelicula.nota
        binding.tvDescripcionDetalle.setMovementMethod(ScrollingMovementMethod())
        binding.tvGeneroDetalle.text = pelicula.genero
        binding.tvPlataformaDetalle.text = pelicula.plataforma
        binding.tvTiempoDetalle.text = pelicula.tiempo



    }
}