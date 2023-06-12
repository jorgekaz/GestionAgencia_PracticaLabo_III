package org.examples.Models;
import java.io.Serializable;

public class Remis extends Vehiculo implements Serializable {
    private transient double tarifaCuadra;
    public Remis(String marca, String modelo, String tipoCombustible, String patente) {
        super(marca, modelo, tipoCombustible, patente);
        this.tarifaCuadra = 150;
    }
    public Remis() {
    }
    public double getTarifaCuadra() {
        return tarifaCuadra;
    }
    public void setTarifaCuadra(double tarifaPorCuadra) {
        this.tarifaCuadra = tarifaPorCuadra;
    }
    @Override
    public String toString() {
        return "REMIS: " + super.toString() + " " + "\n" +
                "TARIFA POR CUADRA: $" + tarifaCuadra + "\n";
    }

}