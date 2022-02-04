package com.example.blancolopezsaulproyectopmdm.modelo.dao

import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula


class PeliculasDaoMockImpl : PeliculasDao {
    val lista = ArrayList<Pelicula>()

    override fun getTodos(): ArrayList<Pelicula> {
        lista.addAll(
            listOf(
                Pelicula(
                    "",
                    "Venom: Let There Be Carnage",
                    "Ciencia ficción, Acción",
                    "Andy Serkis",
                    "6.9",
                    "Amazon Prime Video",
                    "1h 37m",
                    "Eddie Brock (Tom Hardy) y su simbionte Venom todavía están intentando descubrir cómo vivir juntos cuando un preso que está en el corredor de la muerte (Woody Harrelson) se infecta con un simbionte propio.",
                    "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2jVVDtDaeMxmcvrz2SNyhMcYtWc.jpg",
                    "608378608",
                ),
            )
        )
        return lista
    }
}