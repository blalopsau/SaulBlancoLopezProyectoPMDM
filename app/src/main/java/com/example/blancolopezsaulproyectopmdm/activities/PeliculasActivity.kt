package com.example.blancolopezsaulproyectopmdm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.adapters.PeliculasListAdapter
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityPeliculasBinding
import com.example.blancolopezsaulproyectopmdm.modelo.dao.PeliculasDaoMockImpl


private lateinit var binding: ActivityPeliculasBinding

class PeliculasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peliculas)

        binding = ActivityPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val peliculasDao= PeliculasDaoMockImpl()
        val listaPelicula=peliculasDao.getTodos()

        val layoutManager = LinearLayoutManager(this)
        val adapter=PeliculasListAdapter(listaPelicula)

        binding.rvListaPelis.adapter=adapter
        binding.rvListaPelis.layoutManager=layoutManager

    }
}