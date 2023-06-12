package org.examples.Models;
import java.io.Serializable;
import java.util.Objects;

public class Vehiculo implements Serializable {
    private String marca;
    private String modelo;
    private String tipoCombustible;
    private String patente;
    private Estado estado;

    public Vehiculo(String marca, String modelo, String tipoCombustible, String patente) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoCombustible = tipoCombustible;
        this.patente = patente;
        this.estado = Estado.DISPONIBLE;
    }
    public Vehiculo() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String combustible) {
        this.tipoCombustible = combustible;
    }
    public String getPatente() {
        return patente;
    }
    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(patente, vehiculo.patente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patente);
    }

    @Override
    public String toString() {
        return  marca + " " +
                modelo + " " +
                tipoCombustible + " " +
                patente;
    }
}
