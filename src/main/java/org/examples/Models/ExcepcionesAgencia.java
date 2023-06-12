package org.examples.Models;
public class ExcepcionesAgencia extends Exception {
    public ExcepcionesAgencia(String mensaje) {
        super(mensaje);
    }
    // REMIS YA EXISTE
    public static class RemisYaExiste extends ExcepcionesAgencia{
        public RemisYaExiste(String mensaje){
            super("\u001B[31m" + mensaje +"\u001B[0m");
        }
    }
    // REMIS NO EXISTE
    public static class RemisNoExiste extends ExcepcionesAgencia{
        public RemisNoExiste(String mensaje){
            super("\u001B[31m" + mensaje +"\u001B[0m");
        }
    }
    // TAXI YA EXISTE
    public static class TaxiYaExiste extends ExcepcionesAgencia{
        public TaxiYaExiste(String mensaje){
            super("\u001B[31m" + mensaje +"\u001B[0m");
        }
    }
    // TAXI NO EXISTE
    public static class TaxiNoExiste extends ExcepcionesAgencia{
        public TaxiNoExiste(String mensaje){
            super("\u001B[31m" + mensaje +"\u001B[0m");
        }
    }
    // CLIENTE YA EXISTE
    public static class ClienteYaExiste extends ExcepcionesAgencia{

        public ClienteYaExiste(String mensaje){
            super("\u001B[31m" + mensaje +"\u001B[0m");
        }
    }
    // CLIENTE NO EXISTE
    public static class ClienteNoExiste extends ExcepcionesAgencia{
        public ClienteNoExiste(String mensaje){
            super("\u001B[31m" + mensaje +"\u001B[0m");
        }
    }

    //CLIENTE EN VIAJE
    public static class ClienteEnViaje extends ExcepcionesAgencia{
        public ClienteEnViaje(String mensaje){
            super("\u001B[31m" + mensaje +"\u001B[0m");
        }
    }

    //VEHICULOS NO DISPONIBLES
    public static class VehiculosNoDisponibles extends ExcepcionesAgencia{
        public VehiculosNoDisponibles(String mensaje){
            super("\u001B[31m" + mensaje +"\u001B[0m");
        }
    }
}
