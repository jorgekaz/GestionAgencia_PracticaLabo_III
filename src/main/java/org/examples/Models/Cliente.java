package org.examples.Models;
import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private boolean enViaje;
    private Vehiculo vehiculo;

    public Cliente() {
    }
    public Cliente(String nombre, String apellido, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEnViaje() {
        return enViaje;
    }

    public void setEnViaje(boolean enViaje) {
        this.enViaje = enViaje;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(telefono, cliente.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefono);
    }

    @Override
    public String toString() {
        return "NOMBRE: " + nombre + "\n" +
                "APELLIDO: " + apellido + "\n" +
                "TELEFONO: " + telefono + "\n" +
                "DIRECCION: " + direccion + "\n";
    }
}