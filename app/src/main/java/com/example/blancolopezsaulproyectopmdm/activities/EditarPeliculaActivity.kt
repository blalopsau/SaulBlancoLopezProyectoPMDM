package com.example.blancolopezsaulproyectopmdm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityEditarPeliculaBinding

class EditarPeliculaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditarPeliculaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_pelicula)

        binding = ActivityEditarPeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etTitulo.setText("Venom: Let There Be Carnage")
        binding.etDescripcion.setText("After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady.")

    }
}