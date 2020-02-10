/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclubjavaversion;

import java.util.Scanner;

/**
 *
 * @author juang
 */
public class Pelicula {

    private String titulo;
    private String Director;
    private String Duracion;
    private String Genero;
    private String Año;
    private boolean Disponibilidad;
    private int copiasPeliculas;
    private int copiasPeliculasReservadas;
    
    
    //constructor normal
    public Pelicula(String titulo, String Director, String Duracion, String Genero, String Año, boolean Disponibilidad, int copiasPeliculas, int copiasPeliculasReservadas) {
        this.titulo = titulo;
        this.Director = Director;
        this.Duracion = Duracion;
        this.Genero = Genero;
        this.Año = Año;
        this.Disponibilidad = Disponibilidad;
        this.copiasPeliculas = copiasPeliculas;
        this.copiasPeliculasReservadas = copiasPeliculasReservadas;
    }
    //constructor copia

    public Pelicula(Pelicula c1) {
        this.titulo = c1.titulo;
        this.Director = c1.Director;
        this.Duracion = c1.Duracion;
        this.Genero = c1.Genero;
        this.Año = c1.Año;
        this.Disponibilidad = c1.Disponibilidad;
        this.copiasPeliculas = c1.copiasPeliculas;
        this.copiasPeliculasReservadas = c1.copiasPeliculasReservadas;
    }

    //constructor vacio
    public Pelicula() {
    }
    
    //getters y setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String Duracion) {
        this.Duracion = Duracion;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getAño() {
        return Año;
    }

    public void setAño(String Año) {
        this.Año = Año;
    }

    public boolean isDisponibilidad() {
        return Disponibilidad;
    }

    public void setDisponibilidad(boolean Disponibilidad) {
        this.Disponibilidad = Disponibilidad;
    }

    public int getCopiasPeliculas() {
        return copiasPeliculas;
    }

    public void setCopiasPeliculas(int copiasPeliculas) {
        this.copiasPeliculas = copiasPeliculas;
    }

    public int getCopiasPeliculasReservadas() {
        return copiasPeliculasReservadas;
    }

    public void setCopiasPeliculasReservadas(int copiasPeliculasReservadas) {
        this.copiasPeliculasReservadas = copiasPeliculasReservadas;
    }
    
    
    public void añadirPelicula(int copias){
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el titulo de la pelicula");
        this.setTitulo(lector.nextLine());
        System.out.println("Introduce el nombre del director");
        this.setDirector(lector.nextLine());
        System.out.println("Introduce la duracion de la pelicula");
        this.setDuracion(lector.next());
        System.out.println("Introduce el genero de la pelicula");
        this.setGenero(lector.next());
        System.out.println("Introduce el año de la pelicula");
        this.setAño(lector.next());
        this.Disponibilidad=true;
        this.setCopiasPeliculas(copias);
        this.copiasPeliculasReservadas=0;
    }
    
    public void verPeliculas(){
        System.out.print("titulo ");
        System.out.print(this.getTitulo()+" ");
        System.out.print("Director: ");
        System.out.print(this.getDirector()+" ");
        System.out.print("Duracion: ");
        System.out.print(this.getDuracion()+" ");
        System.out.print("Genero: ");
        System.out.print(this.getGenero()+" ");
        System.out.print("año: ");
        System.out.print(this.getAño()+" ");
        System.out.print("disponibilidad: ");
        System.out.print(this.isDisponibilidad()+" ");
        System.out.print("cantidad de copias disponibles: ");
        System.out.println(this.copiasPeliculas-this.copiasPeliculasReservadas);
    }
    
    public void reservarPelicula(){
        if(this.Disponibilidad==true){
            this.copiasPeliculasReservadas++;
            if (this.copiasPeliculasReservadas==this.copiasPeliculas){
                this.Disponibilidad=false;
            }
        }else{
            System.out.println("Lo sentimos la pelicula no esta disponible");
        }
    }
}
