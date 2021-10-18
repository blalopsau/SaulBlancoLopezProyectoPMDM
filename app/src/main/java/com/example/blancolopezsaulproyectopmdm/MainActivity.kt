package com.example.blancolopezsaulproyectopmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCrearCuenta.setOnClickListener {//Cuando se pulsa el boton crear se va a la pantalla CrearcuentaActivity
            val intent = Intent(this, CrearcuentaActivity::class.java)
            startActivity(intent)
        }
    }
}