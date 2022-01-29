package com.example.blancolopezsaulproyectopmdm.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blancolopezsaulproyectopmdm.modelo.dao.App
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.RetrofitCliente
import com.example.blancolopezsaulproyectopmdm.adapters.PeliculasListAdapter
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityPeliculasBinding
import com.example.blancolopezsaulproyectopmdm.modelo.dao.PeliculasDaoMockImpl
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeliculasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPeliculasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peliculas)

        binding = ActivityPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val requestPermissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) { tengoPermiso: Boolean ->
                if (!tengoPermiso) {
                    ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1)
                }
            }

        requestPermissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        val peliculasDao = PeliculasDaoMockImpl()
        val listaPelicula = peliculasDao.getTodos()

        val layoutManager = LinearLayoutManager(this)
        val adapter = PeliculasListAdapter(listaPelicula, this)

        binding.rvListaPelis.adapter = adapter
        binding.rvListaPelis.layoutManager = layoutManager

        binding.fab.setOnClickListener {
            val intent = Intent(this, AnadirPeliculaActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val adapter = PeliculasListAdapter(App.peliculas, this)
        binding.rvListaPelis.adapter = adapter
    }

    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true)
    }
}