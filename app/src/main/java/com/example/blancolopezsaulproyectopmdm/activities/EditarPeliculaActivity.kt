package com.example.blancolopezsaulproyectopmdm.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityEditarPeliculaBinding
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import android.provider.MediaStore
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.example.blancolopezsaulproyectopmdm.modelo.dao.App.Companion.peliculas
import com.squareup.picasso.Picasso
import java.util.jar.Manifest

class EditarPeliculaActivity : AppCompatActivity() {

    private lateinit var pelicula: Pelicula

    private val SELECCIONADA = 100
    var imageUri: Uri? = null

    private lateinit var binding: ActivityEditarPeliculaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_pelicula)

        binding = ActivityEditarPeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pelicula = intent.extras?.get("pelicula") as Pelicula

        binding.etAnadirTitulo.setText(pelicula.titulo)
        binding.etDescripcion.setText(pelicula.descripcion)
        binding.etGenero.setText(pelicula.genero)
        binding.etDirectorDetalle.setText(pelicula.director)
        binding.etPlataforma.setText(pelicula.plataforma)
        binding.etTiempo.setText(pelicula.tiempo)
        binding.etNotaDetalle.setText(pelicula.nota)
        binding.etTelefonoEditar.setText(pelicula.tel)
        Picasso.get().load(pelicula.caratula).into(binding.ivCaratulaEditar)

        binding.btSeleccionar.setOnClickListener {

            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.setType("image/*")
            startActivityForResult(intent, SELECCIONADA)
        }

        binding.btEditar.setOnClickListener {
            peliculas.remove(pelicula)

            val titulo = binding.etAnadirTitulo.text.toString()
            val genero = binding.etGenero.text.toString()
            val director = binding.etDirectorDetalle.text.toString()
            val nota = binding.etNotaDetalle.text.toString()
            val plataforma = binding.etPlataforma.text.toString()
            val tiempo = binding.etTiempo.text.toString()
            val descripcion = binding.etDescripcion.text.toString()
            val caratula = imageUri.toString()
            val tel = binding.etTelefonoEditar.toString()
            Log.d("url imagen", caratula)

            val pel = Pelicula(titulo,genero,director,nota,plataforma,tiempo,descripcion,caratula,tel)
            peliculas.add(pel)
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == SELECCIONADA) {
            imageUri = data?.data
            Picasso.get().load(imageUri).into(binding.ivCaratulaEditar)
        }
    }
}