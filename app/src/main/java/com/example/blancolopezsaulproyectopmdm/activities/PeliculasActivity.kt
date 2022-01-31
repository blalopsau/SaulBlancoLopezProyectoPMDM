package com.example.blancolopezsaulproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blancolopezsaulproyectopmdm.modelo.dao.App
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.RetrofitCliente
import com.example.blancolopezsaulproyectopmdm.adapters.PeliculasListAdapter
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityPeliculasBinding
import com.example.blancolopezsaulproyectopmdm.modelo.dao.PeliculasDaoMockImpl
import com.example.blancolopezsaulproyectopmdm.modelo.dao.Preferences
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Token
import com.example.blancolopezsaulproyectopmdm.modelo.entities.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeliculasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPeliculasBinding
    private lateinit var pref: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peliculas)

        binding = ActivityPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref=Preferences(applicationContext)

        val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { tengoPermiso: Boolean ->
                if (!tengoPermiso) {
                    ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1)
                }
            }

        requestPermissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
//        val peliculasDao = PeliculasDaoMockImpl()
//        val listaPelicula = peliculasDao.getTodos()
//
//        val layoutManager = LinearLayoutManager(this)
//        val adapter = PeliculasListAdapter(listaPelicula, this)
//
//        binding.rvListaPelis.adapter = adapter
//        binding.rvListaPelis.layoutManager = layoutManager

        binding.fab.setOnClickListener {
            val intent = Intent(this, AnadirPeliculaActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val context=this
        val token=pref.sacarToken()

        val call: Call<Token> = RetrofitCliente.apiRetrofit.getAll("Bearer" + token) //Llamamos a Retrofit

        call.enqueue(object : Callback<Token> {
            override fun onFailure(call: Call<Token>, t: Throwable) {
                Log.d("respuesta: onFailure", t.toString())
            }

            override fun onResponse(call: Call<Token>, response: Response<Token>) {
                if (response.code() > 299 || response.code() < 200) {
                    val adb = AlertDialog.Builder(context)
                    adb.setIcon(R.drawable.outline_error_24)
                    adb.setTitle("Lista de peliculas")
                    adb.setMessage("La lista de películas no pudo cargarse correctamente")
                    adb.setPositiveButton("Aceptar") { dialog, which -> }
                    adb.show()
                } else {
                    val adb = AlertDialog.Builder(context)
                    adb.setIcon(R.drawable.outline_error_24)
                    adb.setTitle("Lista de peliculas")
                    adb.setMessage("La lista de películas no pudo cargarse correctamente")
                    adb.setPositiveButton("Aceptar") { dialog, which -> }
                    adb.show()
                }
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true)
    }
}