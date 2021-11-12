package com.example.blancolopezsaulproyectopmdm.activities

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityEditarPeliculaBinding
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import android.provider.MediaStore
import android.content.Intent
import android.net.Uri
import android.os.Environment
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toUri
import com.squareup.picasso.Picasso
import android.graphics.BitmapFactory

import android.graphics.Bitmap
import android.util.Log
import android.widget.ImageView
import java.io.File
import java.io.InputStream


class EditarPeliculaActivity : AppCompatActivity() {
    companion object {
        lateinit var pelicula: Pelicula
    }

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

        val resultContract =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult? ->
                if (result?.resultCode == Activity.RESULT_OK) {
                    val ruta = Environment.getExternalStorageDirectory().path

                    Log.d("EditarPeliculaActivity", "Resultado: ${result.data}")

                    Log.d("EditarPeliculaActivity", ruta)

                    binding.etDescripcion.setText(ruta.toString())
                    val file = File(ruta + "/Pictures")
                    Picasso.get().load("content://media/external/images/media/32").into(binding.ivCaratulaEditar)
                    //TODO("ERROR DE CARGA DE LA IMAGEN EN EL IMAGEVIEW")
                }
            }
        binding.btSeleccionar.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.setType("image/*")
            resultContract.launch(intent)

        }

        binding.btEditar.setOnClickListener {
            //TODO("CAMBIAR DATOS DE PeliculasDaoMockImpl")
        }

    }


}