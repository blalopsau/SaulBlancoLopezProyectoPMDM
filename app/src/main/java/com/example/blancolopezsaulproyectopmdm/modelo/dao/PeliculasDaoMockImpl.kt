package com.example.blancolopezsaulproyectopmdm.modelo.dao

import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula

class PeliculasDaoMockImpl : PeliculasDao{
    override fun getTodos(): List<Pelicula> {

        val p0 = Pelicula(
            "Venom: Let There Be Carnage",
            "Ciencia ficción, Acción",
            "Andy Serkis",
            "6,9",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2jVVDtDaeMxmcvrz2SNyhMcYtWc.jpg"
        )
        val p1 = Pelicula(
            "Coco",
            "Familia, Animación, Fantasía",
            "Lee Unkrich",
            "8.2",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lhXiY2xyEFUfJLyhSUz4bqyUmsD.jpg"
        )
        val p2 = Pelicula(
            "El bebé jefazo 2: negocios de familia",
            "Animación, Comedia, Aventura, Familia",
            "Tom McGrath",
            "7,7",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hvO2pc9X7kt7HZr5liSlk2MQA0Z.jpg"
        )
        val p3 = Pelicula(
            "Fast & Furious 9",
            "Acción, Crimen, Suspense",
            "Justin Lin",
            "7,4",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vdRgVlkkw1eHOdgYKXbzj0qSLB0.jpg"
        )
        val p4 = Pelicula(
            "Operación Camarón",
            "Comedia",
            "Carlos Therón",
            "5,7",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lfXKIeaghRdRstu1CnRFxtq18VN.jpg"
        )
        val p5 = Pelicula(
            "Luca",
            "Animación, Comedia, Familia, Fantasía",
            "Enrico Casarosa",
            "8,0",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/j93NHWoTjdsL4sdz058M3AvKrMy.jpg"
        )
        val p6 = Pelicula(
            "Space Jam: Nuevas Leyendas",
            "Animación, Comedia, Familia, Ciencia ficción",
            "Malcolm D. Lee",
            "7,3",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/i6E8fx8lAEI0PGGCUlaA2Ap1gWi.jpg"
        )
        val p7 = Pelicula(
            "It: Capítulo 2",
            "Terror, Fantasía",
            "Andy Muschietti",
            "6,9",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9oERKIVyTWpHNum3STVsAGD4ojz.jpg"
        )
        val p8 = Pelicula(
            "Bohemian Rhapsody",
            "Música, Drama, Historia",
            "Bryan Singer",
            "8,0",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"
        )
        val p9 = Pelicula(
            "El pianista",
            "Drama, Bélica",
            "Roman Polanski",
            "8,4",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/mxfLOWnHnSlbdraKfzRn5mqoqk7.jpg"
        )
        val p10 = Pelicula(
            "Soul",
            "Animación, Comedia, Fantasía, Familia",
            "Pete Docter",
            "8,2",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xJ7MCAy4oCLerPo3JjnB8lKOhl4.jpg"
        )
        val p11 = Pelicula(
            "Spirit - Indomable",
            "Animación, Aventura, Familia, Western",
            "Elaine Bogan",
            "7,7",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bSkqrecf1g2d0h9z0oJlgxXVHwt.jpg"
        )
        val p12 = Pelicula(
            "Ted 2",
            "Comedia",
            "Characters, Director, Writer",
            "6,3",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/220fvwTHqV7nNpRpZItmbVCHLjC.jpg"
        )
        val p13 = Pelicula(
            "Piratas del Caribe: En mareas misteriosas",
            "Aventura, Acción, Fantasía",
            "Rob Marshall",
            "6,5",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/elZ79uhtQ43xUvcCmdDXI3cN5AU.jpg"
        )
        val p14 = Pelicula(
            "A todo tren: destino Asturias",
            "Comedia, Familia",
            "Santiago Segura",
            "4,7",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wEbBaFX7DBSrv0GbLvJFZXQ7Sdw.jpg"
        )
        val listaPeliculas= listOf(p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14)
        return listaPeliculas
    }
}