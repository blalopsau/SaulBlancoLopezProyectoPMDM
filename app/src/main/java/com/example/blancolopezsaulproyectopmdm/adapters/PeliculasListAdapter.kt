package com.example.blancolopezsaulproyectopmdm.adapters

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.activities.DetallesPeliculaActivity
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import com.squareup.picasso.Picasso
import androidx.appcompat.app.AlertDialog
import com.example.blancolopezsaulproyectopmdm.activities.EditarPeliculaActivity


class PeliculasListAdapter(val peliculas: List<Pelicula>, val context: Context) :  RecyclerView.Adapter<PeliculasListAdapter.PeliculasViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculasViewHolder {
        val layoutInflater =LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula, parent,false)
        return PeliculasViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: PeliculasViewHolder, position: Int) {
        val pelicula = peliculas.get(position)

        holder.tvTitulo.setText(pelicula.titulo)
        holder.tvGenero.setText(pelicula.genero)
        holder.tvDirector.setText(pelicula.director)
        holder.tvNota.setText(pelicula.nota)
        Picasso.get().load(pelicula.caratula).into(holder.ivCaratula)

        holder.ivCardView.setOnClickListener{
            val adb = AlertDialog.Builder(context)

            adb.setTitle("Pelicula")
            adb.setMessage("Que quieres hacer con la película?")

            adb.setPositiveButton("Ver los detalles de la pelicula") { dialogInterface, i ->
                val intent = Intent(context,DetallesPeliculaActivity::class.java)
                intent.putExtra("pelicula",pelicula)
                context.startActivity(intent)
            }
            adb.setNegativeButton("Editar la pelicula"){ dialogInterface, i ->
                val intent = Intent(context,EditarPeliculaActivity::class.java)
                intent.putExtra("pelicula",pelicula)
                context.startActivity(intent)
            }
            adb.setNeutralButton("Borrar la pelicula"){ dialogInterface, i ->
                //TODO("BORRAR LA PELICULA")
            }
            adb.show()
        }
    }

    override fun getItemCount() = peliculas.size

    class PeliculasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo = itemView.findViewById<TextView>(R.id.tvTitulo)
        val tvGenero = itemView.findViewById<TextView>(R.id.tvGenero)
        val tvDirector = itemView.findViewById<TextView>(R.id.tvDirector)
        val tvNota = itemView.findViewById<TextView>(R.id.tvNota)
        val ivCaratula = itemView.findViewById<ImageView>(R.id.ivCaratula)
        val ivCardView = itemView.findViewById<CardView>(R.id.ivCardView)
    }


}
