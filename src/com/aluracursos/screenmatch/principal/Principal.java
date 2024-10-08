package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendaciones;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Matrix", 1999);
        miPelicula.setDuracionEnMinutos(120);

        miPelicula.ponerNota(8.5);
        miPelicula.ponerNota(8.1);
        miPelicula.ponerNota(7.4);

        Pelicula otraPelicula = new Pelicula("Lord of the Rings", 2002);
        otraPelicula.setFechaLanzamiento(2002);
        otraPelicula.setDuracionEnMinutos(140);

        otraPelicula.ponerNota(9.5);
        otraPelicula.ponerNota(5.1);
        otraPelicula.ponerNota(7.4);

        miPelicula.showReview();
        System.out.println("\n***********************");
        Serie casaDragon = new Serie("La casa del Dragón", 2022);
        casaDragon.setTemporadas(2);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.setMinutosPorEpisodio(50);
        System.out.println("\n Serie");
        casaDragon.showReview();
        System.out.println(casaDragon.getDuracionEnMinutos());

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        System.out.println(calculadora.getTiempoTotal());

        FiltroRecomendaciones filtroRecomendaciones = new FiltroRecomendaciones();
        filtroRecomendaciones.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("El primer capitulo");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(3);

        filtroRecomendaciones.filtra(episodio);

        ArrayList listaDePeliculas = new ArrayList<Pelicula>();
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);
        System.out.println("Tamaño de la lista: " + listaDePeliculas.size());
        System.out.println("Primera película: " + listaDePeliculas.get(0));
        System.out.println(listaDePeliculas);
    }
}
