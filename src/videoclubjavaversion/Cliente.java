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
public class Cliente {

    private static int contadorId;
    private int idCliente;
    private String nombre;
    private String apellido;
    private ArrayList<Pelicula> peliculas;

    //Constructor vacio
    public Cliente() {
    }
    //Constructor completo

    public Cliente(int idCliente, String nombre, String apellido, ArrayList<Pelicula> peliculas) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.peliculas = peliculas;
    }

    //constructor copia
    public Cliente(Cliente c1) {
        this.idCliente = c1.idCliente;
        this.nombre = c1.nombre;
        this.apellido = c1.apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Cliente.contadorId = contadorId;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void solicitarDatos() {
        this.idCliente = contadorId;
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el nombre del cliente");
        this.setNombre(lector.nextLine());
        System.out.println("Introduce el apellido del cliente");
        this.setApellido(lector.next());
        contadorId++;
        this.peliculas = new ArrayList<Pelicula>();
    }

    public static void añadirCliente(ArrayList<Cliente> lista) {
        Cliente aux = new Cliente();
        aux.solicitarDatos();
        lista.add(aux);
    }

    public void verDatosCliente() {
        System.out.println("id: " + this.getIdCliente() + " nombre: " + this.getNombre()
                + " apellido: " + this.getApellido());
    }

    public static void listarClientes(ArrayList<Cliente> lista) {
        int i;
        if (lista.size() > 0) {
            for (i = 0; i <= lista.size() - 1; i++) {
                lista.get(i).verDatosCliente();
            }
        } else {
            System.out.println("Lo sentimos aun no hay clientes");
        }
    }

    public static Cliente seleccionarCliente(ArrayList<Cliente> lista) {
        Scanner lector = new Scanner(System.in);
        int i;
        int eleccion;
        for (i = 0; i <= lista.size() - 1; i++) {
            lista.get(i).verDatosCliente();
        }
        System.out.println("selecciona un cliente");
        eleccion = lector.nextInt();
        return lista.get(eleccion);
    }
    
    public void añadirPelicula(Pelicula pelicula){
        this.peliculas.add(pelicula);
    }
    public void VerPeliculasReservadas() {
        int i;
        if (this.peliculas.size() > 0) {
            for (i = 0; i <= this.peliculas.size() - 1; i++) {
                this.peliculas.get(i).verPeliculas();
            }
        }
    }
}
