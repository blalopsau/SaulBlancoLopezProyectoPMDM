package com.example.blancolopezsaulproyectopmdm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityMainBinding
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityPeliculasBinding

private lateinit var binding: ActivityPeliculasBinding

class PeliculasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peliculas)

        binding = ActivityPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvListaPelis.layoutManager=LinearLayoutManager(this)

    }
}