package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{

    private String nombre;
    private int fechaLanzamiento;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaEvaluaciones;
    private int totalEvaluaciones;


    public Titulo(String nombre, int fechaLanzamiento) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();
        this.fechaLanzamiento = Integer.valueOf(miTituloOmdb.year());
        if(miTituloOmdb.runtime().contains("N/A")){
            this.duracionEnMinutos = 0;
            throw new ErrorEnConversionDeDuracionException("No se pudo convertir la duracion,"+
                    "porque no está disponible (se le asignó N/A)");
        }
        this.duracionEnMinutos = Integer.valueOf(
                miTituloOmdb.runtime()
                        .substring(0,3)
                        .replace(" ", ""));
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaLanzamiento(int fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public void showReview(){
        System.out.println("El nombre de la pelicula es: " + nombre);
        System.out.println("Lanzada en " + fechaLanzamiento);
        System.out.println("Con una duración de " + getDuracionEnMinutos() + " minutos.");
//        System.out.println("Puntaje promedio de: " + calcularMedia() + ", con un total de: "+ totalEvaluaciones + " evaluaciones.");
    }

    public void ponerNota(double nota){
        sumaEvaluaciones += nota;
        totalEvaluaciones ++;
    }

    public double calcularMedia(){
        return sumaEvaluaciones/totalEvaluaciones;
    }

    int getTotalEvaluaciones(){
        return totalEvaluaciones;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "(nombre='" + nombre + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento+
                ", duracion="+duracionEnMinutos+")";
    }
}
