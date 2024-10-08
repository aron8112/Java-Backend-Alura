package com.aluracursos.screenmatch.calculos;

public class FiltroRecomendaciones {

    public void filtra(Clasificacion clasificacion){
        if(clasificacion.getClasificacion() >= 4){
            System.out.println("Mejores evaluados");
        } else if (clasificacion.getClasificacion() >=2){
            System.out.println("Popular en el momento");
        } else {
            System.out.println("Colocalo en tu lista para verlo despues.");
        }
    }
}
