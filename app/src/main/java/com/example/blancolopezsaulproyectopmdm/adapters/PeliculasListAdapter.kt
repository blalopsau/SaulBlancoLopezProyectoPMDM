package com.example.blancolopezsaulproyectopmdm.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.blancolopezsaulproyectopmdm.R
import com.example.blancolopezsaulproyectopmdm.databinding.ItemPeliculaBinding
import com.example.blancolopezsaulproyectopmdm.entities.Pelicula
private lateinit var binding: ItemPeliculaBinding

class PeliculasListAdapter(val peliculas: List<Pelicula>, val context: Context) :
    RecyclerView.Adapter<PeliculasListAdapter.PelisHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): PeliculasListAdapter.PelisHolder {
        return PelisHolder(LayoutInflater.from(context).inflate(R.layout.item_pelicula, parent, false))
    }

    override fun getItemCount() = peliculas.size

    override fun onBindViewHolder(holder: PelisHolder, position: Int) {
    }

    class PelisHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}