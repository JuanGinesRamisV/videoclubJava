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
        ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
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
            System.out.println("4)Añadir cliente");
            System.out.println("5)Ver clientes que han reservado una pelicula");
            System.out.println("6)Ver peliculas que ha reservado un cliente");
            System.out.println("7)salir");
            System.out.println("=====================");

            opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    int peliculasAñadir;
                    System.out.println("Introduce el numero de peliculas");
                    peliculasAñadir = lector.nextInt();
                    if (peliculasAñadidas + peliculasAñadir <= maxPeliculas) {
                        Pelicula.añadirPelicula(peliculas, peliculasAñadir);
                    } else {
                        System.out.println("No se pueden añadir estas peliculas"
                                + "por falta de espacio");
                    }
                    break;
                case 2:
                    int aux;
                    Pelicula.listarPeliculas(peliculas);
                    System.out.println("Introduce la pelicula reservar");
                    aux = lector.nextInt();
                    if (clientes.size() > 0) {
                        if (aux <= peliculas.size() - 1) {
                            peliculas.get(aux).reservarPelicula(Cliente.seleccionarCliente(clientes));
                            System.out.println("Gracias por reservar la pelicula");
                        } else {
                            System.out.println("La pelicula no existe");
                        }
                    }else{
                        System.out.println("para reservar peliculas necesitas "
                                + "tener clientes en el sistema");
                    }
                    break;
                case 3:
                    Pelicula.buscarPeliculas(peliculas);
                    break;
                case 4:
                    Cliente.añadirCliente(clientes);
                    break;
                case 5:
                    Pelicula.listarPeliculas(peliculas);
                    System.out.println("Introduce la pelicula ");
                    aux = lector.nextInt();
                    System.out.println("");
                    System.out.println("============");
                    if (aux <= peliculas.size() - 1) {
                        peliculas.get(aux).listarClientes();
                    } else {
                        System.out.println("La pelicula no existe");
                    }
                    break;
                case 6:
                    Cliente.listarClientes(clientes);
                    System.out.println("Introduce el id del cliente ");
                    aux = lector.nextInt();
                    System.out.println("");
                    System.out.println("========");
                    if (aux <= clientes.size() - 1) {
                        clientes.get(aux).VerPeliculasReservadas();
                    } else {
                        System.out.println("El cliente no existe");
                    }
                    break;
                case 7:
                    salir=true;

            }

        }
    }

}
