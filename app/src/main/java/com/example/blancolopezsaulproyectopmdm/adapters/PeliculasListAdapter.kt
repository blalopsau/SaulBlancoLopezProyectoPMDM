package com.example.blancolopezsaulproyectopmdm.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.entities.Pelicula


class PeliculaListAdapter (val peliculas:List<Pelicula>, val context: Context) :
    RecyclerView.Adapter<PeliculaListAdapter.PeliculaHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaHolder {
        val inflater=LayoutInflater.from(context).inflate(R.layout.item_pelicula, parent,false)
        return PeliculaHolder(inflater)
    }
    override fun getItemCount(): Int {
       return peliculas.size
    }
    override fun onBindViewHolder(holder: PeliculaHolder, position: Int) {
       val pelicula=peliculas.get(position)
       // holder.tvTitulo.=pelicula.titulo
    }
    class PeliculaHolder(view: View):RecyclerView.ViewHolder(view){
//val tvTitulo=view.tvTitulo
    }
}