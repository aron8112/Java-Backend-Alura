package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Matrix", 1999);
        miPelicula.ponerNota(8.9);
        Pelicula otraPelicula = new Pelicula("Lord of the Rings", 2002);
        otraPelicula.ponerNota(9.1);
        Pelicula otraPelicula2 = new Pelicula("Avatar", 2013);
        otraPelicula2.ponerNota(8);
        Pelicula otraPelicula3 = new Pelicula("Avatar 2", 2023);
        otraPelicula3.ponerNota(7);
        Pelicula otraPelicula4 = new Pelicula("Encanto", 2021);
        otraPelicula4.ponerNota(6);

        Serie casaDragon = new Serie("La casa del Dragón", 2022);
        Serie otraSerie = new Serie("Lost", 2002);
        Serie otraSerie2 = new Serie("Game of Thrones", 2012);

        List<Titulo> listaDeTitulos = new ArrayList<>();
        //Agregado de películas
        listaDeTitulos.add(miPelicula);
        listaDeTitulos.add(otraPelicula);
        listaDeTitulos.add(otraPelicula2);
        listaDeTitulos.add(otraPelicula3);
        listaDeTitulos.add(otraPelicula4);

        //Agregado de series
        listaDeTitulos.add(casaDragon);
        listaDeTitulos.add(otraSerie);
        listaDeTitulos.add(otraSerie2);

        for(Titulo item: listaDeTitulos){
            System.out.println(item.getNombre());
            if(item instanceof Pelicula pelicula && pelicula.getClasificacion() > 3){
                System.out.println(pelicula.getClasificacion());
            }
        }

        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Alfredo Casero");
        listaDeArtistas.add("Ricardo Darin");
        listaDeArtistas.add("Alfonsina Storni");
        listaDeArtistas.add("Peperino Pomoro");

        Collections.sort(listaDeArtistas);
        System.out.println(listaDeArtistas);

        Collections.sort(listaDeTitulos);
        System.out.println(listaDeTitulos);

        listaDeTitulos.sort(Comparator.comparing(Titulo::getFechaLanzamiento));
        System.out.println(listaDeTitulos);
    }
}
