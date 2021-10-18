package com.example.blancolopezsaulproyectopmdm


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        lateinit var pref: Preferences
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        pref = Preferences(applicationContext)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCrearCuenta.setOnClickListener {//Cuando se pulsa el boton crear se va a la pantalla CrearcuentaActivity
            val intent = Intent(this, CrearcuentaActivity::class.java)
            startActivity(intent)
        }

        binding.btLogin.setOnClickListener {
            val nombre =pref.recuperarDatos("nombre")
            val contraseña =pref.recuperarDatos("contraseña")


           if (!nombre.equals(binding.tietUsuario.text.toString()) || !contraseña.equals(binding.tietContrasenha.text.toString())){
                Toast.makeText(this,"El usuario o la contraseña no existen",Toast.LENGTH_SHORT).show()
            }
        }
    }

}