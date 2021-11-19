package com.example.blancolopezsaulproyectopmdm.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityEditarPeliculaBinding
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import android.provider.MediaStore
import android.content.Intent
import android.net.Uri
import com.squareup.picasso.Picasso


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
        binding.etPlataforma.setText(pelicula.plataforma)
        binding.etTiempo.setText(pelicula.tiempo)
        binding.etNotaDetalle.setText(pelicula.nota)
        Picasso.get().load(pelicula.caratula).into(binding.ivCaratulaEditar)

        binding.btSeleccionar.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.setType("image/*")
            startActivityForResult(intent, SELECCIONADA)
        }

        binding.btEditar.setOnClickListener {
            //TODO("Cambiar datos de la película")
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