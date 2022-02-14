package com.example.blancolopezsaulproyectopmdm.activities

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.blancolopezsaulproyectopmdm.databinding.ActivityCrearcuentaBinding
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.RetrofitCliente
import com.example.blancolopezsaulproyectopmdm.modelo.dao.Preferences
import com.example.blancolopezsaulproyectopmdm.modelo.entities.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern


class CrearcuentaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCrearcuentaBinding
    private lateinit var pref: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crearcuenta)

        binding = ActivityCrearcuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val context = this

        pref=Preferences(applicationContext)
        binding.btAceptar.setOnClickListener {//En el botón aceptar creamos el usuario en la api y pasamos a la pantalla de login

            if (comprobarDatos() == true) {//Si los datos son correctos cargamos los datos en la api

                //Le damos a las variables el valor de los textBoxs
            val usuario = binding.tietEmail.text.toString()
            val contrasenha = binding.tietContraseA.text.toString()

            val call: Call<User> =RetrofitCliente.apiRetrofit.signup(User(null, usuario, contrasenha)) //Llamamos a Retrofit

            call.enqueue(object : Callback<User> { //Lo ponemos en la cola
                override fun onResponse(call: Call<User>,response: Response<User>) { //En la respuesta del retrofit
                    //Si el código es válido
                    if (response.isSuccessful) {
                        val adb = AlertDialog.Builder(context)
                        adb.setIcon(R.drawable.outline_check_circle_24)
                        adb.setTitle("Cuenta creada")
                        adb.setMessage("Cuenta creada con éxito.")
                        adb.setPositiveButton("Aceptar",DialogInterface.OnClickListener { dialog, id ->finish()
                                    val intent = Intent(context, MainActivity::class.java)
                                    startActivity(intent)
                                })
                        adb.show()
                    }else if(response.code()==401) {
                        pref.guardar("")
                    }
                    else {
                        val adb = AlertDialog.Builder(context)
                        adb.setIcon(R.drawable.outline_error_24)
                        adb.setTitle("Cuenta no creada")
                        adb.setMessage("La cuenta no pudo ser creada.")
                        adb.setPositiveButton("Aceptar") { dialog, which -> }
                        adb.show()
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.d("respuesta: onFailure", t.toString())
                }
            })
            }
        }
    }

    private fun validarEmail(email: String): Boolean { //Metodo que comprueba si el email es correcto
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    private fun comprobarDatos(): Boolean {//Metodo que comprueba si el email es correcto y las contraseñas son validas y coinciden
        val contraseña = binding.tietContraseA.text.toString()
        val repcontraseña = binding.tietRepetirContraseA.text.toString()

        if (validarEmail(binding.tietEmail.text.toString()) == false) {//Si el email es incorrecto
            Toast.makeText(this, "El email no es correcto", Toast.LENGTH_SHORT)
                .show()//Mensaje de que el email es incorrecto
            return false
        } else if (contraseña.length < 5 || contraseña.length > 10) {//Comprobamos la longitud de la contraseña
            Toast.makeText(this, "La contraseña no tiene la longitud correcta", Toast.LENGTH_SHORT)
                .show()//Mensaje de que el email es incorrecto
            return false
        } else if (!contraseña.equals(repcontraseña)) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT)
                .show()//Mensaje de que el email es incorrecto
            return false
        }
        return true
    }

}