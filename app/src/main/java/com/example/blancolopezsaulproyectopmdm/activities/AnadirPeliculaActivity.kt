package com.example.blancolopezsaulproyectopmdm.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AlertDialog
import com.example.blancolopezsaulproyectopmdm.modelo.dao.App.Companion.peliculas
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityAnadirPeliculaBinding
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import com.squareup.picasso.Picasso
import java.util.regex.Matcher
import java.util.regex.Pattern

class AnadirPeliculaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnadirPeliculaBinding
    private val SELECCIONADA = 100
    var imageUri: Uri? = null
    private val TIEMPO_PATTERN = "^[0-9]+h+\\s+[0-9]+[0-9]+min"

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
            val caratula = imageUri.toString()
            val tel = binding.etAnadirTelefono.text.toString()

            val pel = Pelicula(
                titulo,
                genero,
                director,
                nota,
                plataforma,
                tiempo,
                descripcion,
                caratula,
                tel
            )

            //Patrones para el tiempo de la película
            val patTiempo: Pattern = Pattern.compile(TIEMPO_PATTERN)
            val matTiempo: Matcher = patTiempo.matcher(tiempo)



            if (titulo == "" || genero == "" || director == "" || nota == "" || plataforma == "" || tiempo == "" || descripcion == "" || tel == "") {
                val adb = AlertDialog.Builder(this)
                adb.setIcon(R.drawable.outline_error_24)
                adb.setTitle("Campos vacios")
                adb.setMessage("Algún campo está vacio, porfavor rellene todos los campos")
                adb.setPositiveButton("Aceptar") { dialog, which -> }
                adb.show()
            } else if (!matTiempo.matches()) {
                val adb = AlertDialog.Builder(this)
                adb.setIcon(R.drawable.outline_error_24)
                adb.setTitle("Tiempo Incorrecto")
                adb.setMessage("La duración de la película no cumple el patrón \"0h 00min\" ")
                adb.setPositiveButton("Aceptar") { dialog, which -> }
                adb.show()
            } else {
                peliculas.add(pel)
                finish()
            }
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