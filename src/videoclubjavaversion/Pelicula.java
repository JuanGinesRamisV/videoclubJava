/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclubjavaversion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juang
 */
public class Pelicula {
    
    private static int contadorId;
    private int id;
    private String titulo;
    private String Director;
    private String Duracion;
    private String Genero;
    private String Año;
    private boolean Disponibilidad;
    private int copiasPeliculas;
    private int copiasPeliculasReservadas;
    private ArrayList<Cliente> clientes;

    //constructor normal

    public Pelicula(int id, String titulo, String Director, String Duracion, String Genero, String Año, boolean Disponibilidad, int copiasPeliculas, int copiasPeliculasReservadas, ArrayList<Cliente> clientes) {
        this.id = id;
        this.titulo = titulo;
        this.Director = Director;
        this.Duracion = Duracion;
        this.Genero = Genero;
        this.Año = Año;
        this.Disponibilidad = Disponibilidad;
        this.copiasPeliculas = copiasPeliculas;
        this.copiasPeliculasReservadas = copiasPeliculasReservadas;
        this.clientes = clientes;
    }



    //constructor copia
    public Pelicula(Pelicula c1) {
        this.id = c1.id;
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

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Pelicula.contadorId = contadorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
    public void añadirPelicula(int copias) {
        this.id=contadorId;
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
        this.Disponibilidad = true;
        this.setCopiasPeliculas(copias);
        this.copiasPeliculasReservadas = 0;
        contadorId++;
        this.clientes = new ArrayList<Cliente>();
    }

    public void verPeliculas() {
        System.out.print("id: ");
        System.out.print(this.id);
        System.out.print("titulo ");
        System.out.print(this.getTitulo() + " ");
        System.out.print("Director: ");
        System.out.print(this.getDirector() + " ");
        System.out.print("Duracion: ");
        System.out.print(this.getDuracion() + " ");
        System.out.print("Genero: ");
        System.out.print(this.getGenero() + " ");
        System.out.print("año: ");
        System.out.print(this.getAño() + " ");
        System.out.print("disponibilidad: ");
        if(this.Disponibilidad==true){
                    System.out.print("disponible ");
        }else{
            System.out.println("No disponible ");
        }
        System.out.print("cantidad de copias disponibles: ");
        System.out.println(this.copiasPeliculas - this.copiasPeliculasReservadas);
    }

    public void reservarPelicula(Cliente reservante) {
        if (this.Disponibilidad == true) {
            Cliente clienteAux = new Cliente(reservante);
            Pelicula peliculaAux = new Pelicula(this);
            this.clientes.add(clienteAux);
            reservante.añadirPelicula(peliculaAux);
            this.copiasPeliculasReservadas++;
            System.out.println("Gracias por reservar la pelicula");
            if (this.copiasPeliculasReservadas == this.copiasPeliculas) {
                this.Disponibilidad = false;
            }
        } else {
            System.out.println("Lo sentimos la pelicula no esta disponible");
        }
    }

    public static void buscarPeliculas(ArrayList<Pelicula> lista) {
        int aux;
        int i;
        String busquedaString;
        boolean encontrado = false;
        Scanner lector = new Scanner(System.in);
        System.out.println("¿que tipo de busqueda quieres realizar");
        System.out.println("1) por titulo");
        System.out.println("2)Por director");
        System.out.println("3)Por genero");
        System.out.println("4)por año");
        System.out.println("5)Por duración");
        System.out.println("==========");
        aux = lector.nextInt();
        lector.nextLine();
        switch (aux) {
            case 1:
                System.out.println("introduce el titulo de la pelicula");
                busquedaString = lector.nextLine();
                for (i = 0; i <= lista.size() - 1; i++) {
                    if (lista.get(i).getTitulo().contains(busquedaString) == true) {
                        encontrado = true;
                        lista.get(i).verPeliculas();
                    }
                }
                break;
            case 2:
                System.out.println("introduce el director de la pelicula");
                busquedaString = lector.nextLine();
                for (i = 0; i <= lista.size() - 1; i++) {
                    if (lista.get(i).getDirector().contains(busquedaString) == true) {
                        encontrado = true;
                        lista.get(i).verPeliculas();
                    }
                }
                break;
            case 3:
                System.out.println("Introduce el genero de la pelicula");
                busquedaString = lector.nextLine();
                for (i = 0; i <= lista.size() - 1; i++) {
                    if (lista.get(i).getGenero().contains(busquedaString) == true) {
                        encontrado = true;
                        lista.get(i).verPeliculas();
                    }
                }
                break;
            case 4:
                System.out.println("Introduce el año de la pelicula");
                busquedaString = lector.nextLine();
                for (i = 0; i <= lista.size() - 1; i++) {
                    if (lista.get(i).getAño().contains(busquedaString) == true) {
                        encontrado = true;
                        lista.get(i).verPeliculas();
                    }
                }
                break;
            case 5:
                System.out.println("Introduce la duración de la pelicula");
                busquedaString = lector.nextLine();
                for (i = 0; i <= lista.size() - 1; i++) {
                    if (lista.get(i).getDuracion().contains(busquedaString) == true) {
                        encontrado = true;
                        lista.get(i).verPeliculas();
                    }
                }
                break;
        }
        if (encontrado == false) {
            System.out.println("Lo sentimos no tenemos esta pelicula");
        }
    }

    public static void añadirPelicula(ArrayList<Pelicula> lista, int peliculasAñadir) {
        Pelicula aux = new Pelicula();
        aux.añadirPelicula(peliculasAñadir);
        lista.add(aux);
    }

    public static void listarPeliculas(ArrayList<Pelicula> lista) {
        int i;
        for (i = 0; i <= lista.size() - 1; i++) {
            lista.get(i).verPeliculas();
        }
    }
    
    public void listarClientes(){
        int i;
        if(this.clientes.size()>0){
        for(i=0;i<=this.clientes.size()-1;i++){
            this.clientes.get(i).verDatosCliente();
        }
        }else{
            System.out.println("Esta pelicula no esta reservada por ningun"
                    + " cliente");
        }
    }
    
}
