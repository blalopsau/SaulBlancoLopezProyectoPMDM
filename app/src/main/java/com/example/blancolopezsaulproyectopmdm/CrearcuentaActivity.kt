package com.example.blancolopezsaulproyectopmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityCrearcuentaBinding
import android.content.Intent
import android.net.Uri


class CrearcuentaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCrearcuentaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crearcuenta)

        binding= ActivityCrearcuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTerminos.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.edu.xunta.gal/centros/iesmurallaromana/"))
            startActivity(intent)
        }
        binding.btAceptar.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}