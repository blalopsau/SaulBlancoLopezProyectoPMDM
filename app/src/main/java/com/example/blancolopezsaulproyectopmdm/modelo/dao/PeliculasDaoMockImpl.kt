package com.example.blancolopezsaulproyectopmdm.modelo.dao

import com.example.blancolopezsaulproyectopmdm.modelo.entities.Pelicula

class PeliculasDaoMockImpl : PeliculasDao {
    override fun getTodos(): List<Pelicula> {

        val p0 = Pelicula(
            "Venom: Let There Be Carnage",
            "Ciencia ficción, Acción",
            "Andy Serkis",
            "6,9",
            "Amazon Prime Video",
            "1h 37m",
            "Eddie Brock (Tom Hardy) y su simbionte Venom todavía están intentando descubrir cómo vivir juntos cuando un preso que está en el corredor de la muerte (Woody Harrelson) se infecta con un simbionte propio.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2jVVDtDaeMxmcvrz2SNyhMcYtWc.jpg",
            "https://www.youtube.com/watch?v=0fWmQE05D88"

        )
        val p1 = Pelicula(
            "Coco",
            "Familia, Animación, Fantasía",
            "Lee Unkrich",
            "8.2",
            "Disney+",
            "1h 49m",
            "Miguel es un joven con el sueño de convertirse en leyenda de la música a pesar de la prohibición de su familia. Su pasión le llevará a adentrarse en la \"Tierra de los Muertos\" para conocer su verdadero legado familiar.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lhXiY2xyEFUfJLyhSUz4bqyUmsD.jpg",
            ""
        )
        val p2 = Pelicula(
            "El bebé jefazo 2: negocios de familia",
            "Animación, Comedia, Aventura, Familia",
            "Tom McGrath",
            "7,7",
            "Netflix",
            "1h 47m",
            "Los hermanos Templeton se han convertido en adultos y se han alejado el uno del otro, pero un nuevo jefe bebé con un enfoque de vanguardia está a punto de unirlos nuevamente e inspirar un nuevo negocio familiar.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hvO2pc9X7kt7HZr5liSlk2MQA0Z.jpg",
            ""
        )
        val p3 = Pelicula(
            "Fast & Furious 9",
            "Acción, Crimen, Suspense",
            "Justin Lin",
            "7,4",
            "Moviestar+",
            "2h 22m",
            "Dom Toretto lleva una vida tranquila con Letty y su hijo, el pequeño Brian, pero saben que el peligro siempre acecha. Esta vez, esa amenaza obligará a Dom a enfrentarse a los pecados de su pasado si quiere salvar a quienes más quiere. El equipo se vuelve a reunir para impedir un complot a escala mundial, liderado por uno de los asesinos más peligrosos y mejor conductor a los que se han enfrentado; un hombre que además es el hermano desaparecido de Dom, Jakob. Novena entrega de la famosa franquicia.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vdRgVlkkw1eHOdgYKXbzj0qSLB0.jpg",
            ""
        )
        val p4 = Pelicula(
            "Operación Camarón",
            "Comedia",
            "Carlos Therón",
            "5,7",
            "Moviestar+",
            "1h 30m",
            "Desconocido en el mundo del hampa, con aspecto de pringado y dotes de concertista clásico, Sebas, un policía novato, es perfecto para una peligrosa misión: infiltrarse como teclista en 'Los Lolos', una banda hortera de flamenco-trap que va a tocar en la boda de la hija de un traficante local... Remake del film italiano \"Song 'e Napule\" (2013).",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lfXKIeaghRdRstu1CnRFxtq18VN.jpg",
            ""
        )
        val p5 = Pelicula(
            "Luca",
            "Animación, Comedia, Familia, Fantasía",
            "Enrico Casarosa",
            "8,0",
            "Disney+",
            "1h 41m",
            "Ambientada en un precioso pueblo costero de la Riviera italiana, narra la historia sobre el paso a la edad adulta de un chico que vive un verano inolvidable lleno de helados, pasta e infinitos paseos en scooter. Luca comparte estas aventuras con su nuevo mejor amigo, pero toda la diversión se ve amenazada por un secreto muy profundo: él es un monstruo marino de un mundo que yace bajo la superficie del agua.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/j93NHWoTjdsL4sdz058M3AvKrMy.jpg",
            ""
        )
        val p6 = Pelicula(
            "Space Jam: Nuevas Leyendas",
            "Animación, Comedia, Ciencia ficción",
            "Malcolm D. Lee",
            "7,3",
            "Apple TV+",
            "2h",
            "Secuela de la cinta original de 1996, Space Jam, protagonizada por Michael Jordan. En esta segunda parte, la super estrella de la NBA es LeBron James, quien queda atrapado junto a su hijo Dom en un extraño lugar, un espacio digital de una fuerza todopoderosa y malvada conocida como A.I. Para volver a casa y poner a salvo a su hijo, el jugador de baloncesto deberá unir fuerzas con Bugs Bunny, Lola Bunny y el resto de personajes de los Looney Tunes para enfrentarse en un partido de baloncesto a los campeones digitalizados por inteligencia artificial.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/i6E8fx8lAEI0PGGCUlaA2Ap1gWi.jpg",
            ""
        )
        val p7 = Pelicula(
            "It: Capítulo 2",
            "Terror, Fantasía",
            "Andy Muschietti",
            "6,9",
            "HBO Max",
            "2h 49m",
            "Han pasado casi 30 años desde que el \"Club de los Perdedores\", formado por Bill, Beverly, Richie, Ben, Eddie, Mike y Stanley, se enfrentaran al macabro y despiadado Pennywise (Bill Skarsgård). En cuanto tuvieron oportunidad, abandonaron el pueblo de Derry, en el estado de Maine, que tantos problemas les había ocasionado. Sin embargo, ahora, siendo adultos, parece que no pueden escapar de su pasado. Todos deberán enfrentarse de nuevo al temible payaso para descubrir si de verdad están preparados para superar sus traumas de la infancia.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9oERKIVyTWpHNum3STVsAGD4ojz.jpg",
            ""
        )
        val p8 = Pelicula(
            "Bohemian Rhapsody",
            "Música, Drama, Historia",
            "Bryan Singer",
            "8,0",
            "HBO Max",
            "2h 14m",
            "Bohemian Rhapsody es una rotunda y sonora celebración de Queen, de su música y de su extraordinario cantante Freddie Mercury, que desafió estereotipos e hizo añicos tradiciones para convertirse en uno de los showmans más queridos del mundo. La película plasma el meteórico ascenso al olimpo de la música de la banda a través de sus icónicas canciones y su revolucionario sonido, su crisis cuando el estilo de vida de Mercury estuvo fuera de control, y su triunfal reunión en la víspera del Live Aid, en la que Mercury, mientras sufría una enfermedad que amenazaba su vida, lidera a la banda en uno de los conciertos de rock más grandes de la historia. Veremos cómo se cimentó el legado de una banda que siempre se pareció más a una familia, y que continúa inspirando a propios y extraños, soñadores y amantes de la música hasta nuestros días.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
            ""
        )
        val p9 = Pelicula(
            "El pianista",
            "Drama, Bélica",
            "Roman Polanski",
            "8,4",
            "Amazon Prime Video",
            "2h 30m",
            "Varsovia, 1939. El pianista polaco de origen judío Wladyslaw Szpilman (Adrien Brody) interpreta un tema de Chopin en la radio nacional de Polonia mientras la aviación alemana bombardea la capital. El régimen nazi ha invadido el país, y como hace en otros países invadidos, lleva a cabo la misma política con respecto a los judíos. Así Szpilman y toda su familia -sus padres, su hermano y sus dos hermanas- se ven obligados a dejar su casa y todo lo que les pertenece para trasladarse con miles de personas de origen judío al ghetto de Varsovia. Mientras Wladyslaw trabaja como pianista en un restaurante propiedad de un judío que colabora con los nazis, su hermano Henryk (Ed Stoppard) prefiere luchar contra los nazis. Pero tres años más tarde, los habitantes del ghetto son trasladados en trenes hacia campos de concentración.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/mxfLOWnHnSlbdraKfzRn5mqoqk7.jpg",
            ""
        )
        val p10 = Pelicula(
            "Soul",
            "Animación, Comedia, Fantasía, Familia",
            "Pete Docter",
            "8,2",
            "Disney+",
            "1h 47m",
            "¿Alguna vez te has preguntado de dónde provienen tu pasión, tus sueños y tus intereses? ¿Qué es lo que te hace ser... tú? Viaja desde las calles de Nueva York a los reinos cósmicos para descubrir las respuestas a las preguntas más importantes de la vida.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xJ7MCAy4oCLerPo3JjnB8lKOhl4.jpg",
            ""
        )
        val p11 = Pelicula(
            "Spirit - Indomable",
            "Animación, Aventura, Familia, Western",
            "Elaine Bogan",
            "7,7",
            "Moviestar+",
            "1h 27m",
            "La vida de Lucky Prescott cambia para siempre cuando se muda de su casa en la gran ciudad a un pequeño pueblo fronterizo en el que entabla amistad con un caballo salvaje llamado Spirit.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bSkqrecf1g2d0h9z0oJlgxXVHwt.jpg",
            ""
        )
        val p12 = Pelicula(
            "Ted 2",
            "Comedia",
            "Characters, Director, Writer",
            "6,3",
            "Netflix",
            "1h 55m",
            "Se trata de una secuela de la exitosa comedia escrita y dirigida por el cómico Seth MacFarlane. Recién casados Ted y Tami-Lynn deciden tener un bebé. John se ofrece en donar su esperma para que su mejor amigo pueda cumplir su sueño de tener un hijo, pero inesperadamente reciben una carta legal que dice que el estado no le permite ser padre ya que no está demostrado que sea una persona. Todos juntos tendrán que unir fuerzas para luchar por sus derechos en un tribunal de justicia",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/220fvwTHqV7nNpRpZItmbVCHLjC.jpg",
            ""
        )
        val p13 = Pelicula(
            "Piratas del Caribe: En mareas misteriosas",
            "Aventura, Acción, Fantasía",
            "Rob Marshall",
            "6,5",
            "Disney+",
            "2h 21m",
            "Cuando Jack Sparrow vuelve a encontrarse con una mujer a la que había conocido años atrás, no está seguro de si se trata de amor o si ella es una estafadora sin escrúpulos que lo está utilizando para encontrar la legendaria Fuente de la Juventud. A todo esto, Jack es capturado por el Venganza de la Reina Ana, el barco del temible pirata Barbanegra, que lo obliga a unirse a su tripulación, lo que le hará vivir una inesperada aventura en la que no sabe quién le inspira más miedo si Barbanegra o esa mujer que regresa del pasado.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/elZ79uhtQ43xUvcCmdDXI3cN5AU.jpg",
            ""
        )
        val p14 = Pelicula(
            "A todo tren: destino Asturias",
            "Comedia, Familia",
            "Santiago Segura",
            "4,7",
            "Moviestar+",
            "1h 30m",
            "Cuando Ricardo, un padre responsable, decide llevar personalmente a su hijo a un campamento en Asturias, otros padres proponen que sea él quien se haga cargo también de sus hijos. Cuando el tren está a punto de partir, Felipe, un extravagante individuo y abuelo de dos de los niños, se presenta en la estación.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wEbBaFX7DBSrv0GbLvJFZXQ7Sdw.jpg",
            ""
        )
        val listaPeliculas = listOf(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14)
        return listaPeliculas
    }
}