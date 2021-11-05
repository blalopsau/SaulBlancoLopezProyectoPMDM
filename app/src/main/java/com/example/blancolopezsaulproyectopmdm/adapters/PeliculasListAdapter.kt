package com.example.blancolopezsaulproyectopmdm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.databinding.ItemPeliculaBinding
import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula
import com.squareup.picasso.Picasso

private lateinit var binding: ItemPeliculaBinding

class PeliculasListAdapter(val peliculas: List<Pelicula>) :
    RecyclerView.Adapter<PeliculasListAdapter.PeliculasViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculasViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula, parent, false)
        return PeliculasViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: PeliculasViewHolder, position: Int) {
        val pelicula=peliculas.get(position)

        holder.tvTitulo.setText(pelicula.titulo)
        holder.tvGenero.setText(pelicula.genero)
        holder.tvDirector.setText(pelicula.director)
        holder.tvNota.setText(pelicula.nota)
        Picasso.get().load(pelicula.caratula).into(holder.ivCaratula)
    }

    override fun getItemCount() = peliculas.size

    class PeliculasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo = itemView.findViewById<TextView>(R.id.tvTitulo);
        val tvGenero = itemView.findViewById<TextView>(R.id.tvGenero);
        val tvDirector = itemView.findViewById<TextView>(R.id.tvDirector);
        val tvNota = itemView.findViewById<TextView>(R.id.tvNota);
        val ivCaratula = itemView.findViewById<ImageView>(R.id.ivCaratula);
    }
}