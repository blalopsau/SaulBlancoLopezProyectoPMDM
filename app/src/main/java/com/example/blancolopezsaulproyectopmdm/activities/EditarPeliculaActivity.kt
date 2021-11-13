package com.example.blancolopezsaulproyectopmdm.activities

import android.R.attr
import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityEditarPeliculaBinding
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import android.provider.MediaStore
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Environment
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toUri
import com.squareup.picasso.Picasso
import android.graphics.BitmapFactory

import android.graphics.Bitmap
import android.preference.PreferenceManager
import android.util.Log
import android.widget.ImageView
import java.io.File
import java.io.InputStream
import android.R.attr.data
import android.provider.ContactsContract
import android.view.View
import android.widget.Toast

import androidx.core.app.ActivityCompat.startActivityForResult
import java.lang.String


class EditarPeliculaActivity : AppCompatActivity() {
    companion object {
        lateinit var pelicula: Pelicula
    }

    private val SELECCIONADA = 100
    var imageUri: Uri? = null

    private lateinit var binding: ActivityEditarPeliculaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_pelicula)

        binding = ActivityEditarPeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pelicula = intent.extras?.get("pelicula") as Pelicula

        binding.etTitulo.setText(pelicula.titulo)
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
            //TODO("CAMBIAR DATOS DE PeliculasDaoMockImpl")
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