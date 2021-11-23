package com.example.blancolopezsaulproyectopmdm.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log

import com.example.blancolopezsaulproyectopmdm.modelo.dao.App.Companion.peliculas
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityAnadirPeliculaBinding
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import com.squareup.picasso.Picasso

class AnadirPeliculaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnadirPeliculaBinding
    private val SELECCIONADA = 100
    var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_pelicula)

        binding = ActivityAnadirPeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btAnadirCaratula.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.setType("image/*")
            startActivityForResult(intent, SELECCIONADA)
        }

        binding.btAnadirPelicula.setOnClickListener {

            val titulo = binding.etAnadirTitulo.text.toString()
            val genero = binding.etAnadirGenero.text.toString()
            val director = binding.etAnadirDirector.text.toString()
            val nota = binding.etAnadirNota.text.toString()
            val plataforma = binding.etAnadirPlataforma.text.toString()
            val tiempo = binding.etAnadirTiempo.text.toString()
            val descripcion = binding.etAnadirDescripcion.text.toString()
            val caratula=imageUri.toString()

            val pel =  Pelicula(titulo, genero, director, nota, plataforma, tiempo, descripcion, caratula)
            peliculas.add(pel)
            Log.d("añadir pelicula", imageUri.toString())
            finish()
            //TODO("No carga la foto")

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == SELECCIONADA) {
            imageUri = data?.data
            Picasso.get().load(imageUri).into(binding.ivCaratulaAAdir)
        }
    }
}