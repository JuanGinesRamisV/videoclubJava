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
public class VideoclubJavaVersion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("fdfdf");
        ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
        int maxPeliculas = 3000;
        int peliculasAñadidas = 0;
        boolean salir = false;
        Scanner lector = new Scanner(System.in);

        while (salir == false) {
            int opcion;
            System.out.println("=====================");
            System.out.println("=MENÚ=");
            System.out.println("=====================");
            System.out.println("1)Añadir pelicula");
            System.out.println("2)Reservar pelicula");
            System.out.println("3)Buscar pelicula");
            System.out.println("4)Salir");
            System.out.println("=====================");

            opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    int peliculasAñadir;
                    System.out.println("Introduce el numero de peliculas");
                    peliculasAñadir = lector.nextInt();
                    if (peliculasAñadidas + peliculasAñadir <= maxPeliculas) {
                        añadirPelicula(peliculas, peliculasAñadir);
                    } else {
                        System.out.println("No se pueden añadir estas peliculas"
                                + "por falta de espacio");
                    }
                    break;
                case 2:
                    int aux;
                    listarPeliculas(peliculas);
                    System.out.println("Introduce la pelicula que quieres reservar");
                    aux = lector.nextInt();
                    if (aux <= peliculas.size() - 1) {
                        peliculas.get(aux).reservarPelicula();
                        System.out.println("Gracias por reservar la pelicula");
                    } else {
                        System.out.println("La pelicula no existe");
                    }
                    break;
                case 3:
                    buscarPeliculas(peliculas);
                    break;
            }

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
            //impirmo el id de la pelicula
            System.out.print("id " + i);
            lista.get(i).verPeliculas();
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
        aux = lector.nextInt();
        lector.nextLine();
        switch (aux) {
            case 1:
                System.out.println("introduce el titulo de la pelicula");
                busquedaString = lector.nextLine();
                for (i = 0; i <= lista.size() - 1; i++) {
                    if (lista.get(i).getTitulo().contains(busquedaString) == true) {
                        encontrado=true;
                        lista.get(i).verPeliculas();
                    }
                }
                break;
            case 2:
                System.out.println("introduce el director de la pelicula");
                busquedaString = lector.nextLine();
                for (i = 0; i <= lista.size() - 1; i++) {
                    if (lista.get(i).getDirector().contains(busquedaString) == true) {
                        encontrado=true;
                        lista.get(i).verPeliculas();
                    }
                }
                break;
            case 3:
                System.out.println("Introduce el genero de la pelicula");
                busquedaString = lector.nextLine();
                for (i = 0; i <= lista.size() - 1; i++) {
                    if (lista.get(i).getGenero().contains(busquedaString) == true) {
                        encontrado=true;
                        lista.get(i).verPeliculas();
                    }
                }
                break;
            case 4:
                System.out.println("Introduce el año de la pelicula");
                busquedaString = lector.nextLine();
                for (i = 0; i <= lista.size() - 1; i++) {
                    if (lista.get(i).getAño().contains(busquedaString) == true) {
                        encontrado=true;
                        lista.get(i).verPeliculas();
                    }
                }
                break;
            case 5:
                System.out.println("Introduce la duración de la pelicula");
                busquedaString = lector.nextLine();
                for (i = 0; i <= lista.size() - 1; i++) {
                    if (lista.get(i).getDuracion().contains(busquedaString) == true) {
                        encontrado=true;
                        lista.get(i).verPeliculas();
                    }
                }
                break;
        }
        if (encontrado == false) {
            System.out.println("Lo sentimos no tenemos esta pelicula");
        }
    }
}
