package org.examples.Models;
import java.io.Serializable;


public class Taxi extends Vehiculo implements Serializable {
    private transient double contadorKilometros;
    private transient double bajadaBandera;
    private transient double precioKilometro;

    public Taxi(String marca, String modelo, String tipoCombustible, String patente) {
        super(marca, modelo, tipoCombustible, patente);
        this.contadorKilometros = 0.0;
        this.bajadaBandera = 50;
        this.precioKilometro = 10;
    }

    public Taxi() {
    }

    public double getContadorKilometros() {
        return contadorKilometros;
    }

    public void setContadorKilometros(double contadorKilometros) {
        this.contadorKilometros = contadorKilometros;
    }

    public double getBajadaBandera() {
        return bajadaBandera;
    }

    public void setBajadaBandera(double bajadaBandera) {
        this.bajadaBandera = bajadaBandera;
    }

    public double getPrecioKilometro() {
        return precioKilometro;
    }

    public void setPrecioKilometro(double precioKilometro) {
        this.precioKilometro = precioKilometro;
    }


    @Override
    public String toString() {
        return "TAXI: " + super.toString() + " " + "\n" +
                "CONTADOR KILOMETROS: " + contadorKilometros + "\n" +
                "BAJADA BANDERA: " + bajadaBandera + "\n" +
                "PRECIO POR KILOMETRO: " + precioKilometro + "\n";
    }

    public double precioKilometro() {
        return this.precioKilometro;
    }
}