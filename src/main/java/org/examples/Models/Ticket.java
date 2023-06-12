package org.examples.Models;
import java.io.Serializable;

public class Ticket implements Serializable {
    private static int contadorID = 0;
    private int id;
    private String patente;
    private double precio;

    public Ticket(String patente, double precio) {
        this.id = contadorID;
        this.patente = patente;
        this.precio = precio;
    }

    public Ticket() {

    }

    public static int getContador() {
        return contadorID;
    }

    public static void setContador(int contador) {
        Ticket.contadorID = contador;
    }

    public int getId() {
        return id;
    }

    public String getPatente() {
        return patente;
    }

    public double getPrecio() {
        return precio;
    }

    public static int getContadorID() {
        return contadorID;
    }

    public static void setContadorID(int contadorID) {
        Ticket.contadorID = contadorID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
