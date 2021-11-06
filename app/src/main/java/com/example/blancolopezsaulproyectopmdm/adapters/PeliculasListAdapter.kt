package com.example.blancolopezsaulproyectopmdm.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.activities.DetallesPeliculaActivity
import com.example.blancolopezsaulproyectopmdm.activities.PeliculasActivity
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import com.squareup.picasso.Picasso


class PeliculasListAdapter(val peliculas: List<Pelicula>, val context: Context) :
    RecyclerView.Adapter<PeliculasListAdapter.PeliculasViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculasViewHolder {
        val layoutInflater =LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula, parent, false)
        return PeliculasViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: PeliculasViewHolder, position: Int) {
        val pelicula = peliculas.get(position)

        holder.tvTitulo.setText(pelicula.titulo)
        holder.tvGenero.setText(pelicula.genero)
        holder.tvDirector.setText(pelicula.director)
        holder.tvNota.setText(pelicula.nota)

        holder.ivCardView.setOnClickListener() {
            val intent = Intent(context,DetallesPeliculaActivity::class.java)
            intent.putExtra("pelicula",pelicula)
            context.startActivity(intent)

        }
        Picasso.get().load(pelicula.caratula).into(holder.ivCaratula)
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