package com.example.blancolopezsaulproyectopmdm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.adapters.PeliculasListAdapter
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityPeliculasBinding
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula

private lateinit var binding: ActivityPeliculasBinding

class PeliculasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peliculas)

        binding= ActivityPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvListaPelis.layoutManager=LinearLayoutManager(this)

        val peliculas= listOf(
            Pelicula("Game of thrones","Ciencia Ficción","George R.R","9.2"),
            Pelicula("El rey","Documental","George R.R","9.2"),
            Pelicula("Ratatuille","animacion","George R.R","10")
        )

        var adapter=PeliculasListAdapter(peliculas,this)

        binding.rvListaPelis.adapter=adapter
    }
}