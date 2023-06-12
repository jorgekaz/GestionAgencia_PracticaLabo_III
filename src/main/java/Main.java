import org.examples.Models.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ExcepcionesAgencia.ClienteNoExiste {
        GestionAgencia gestionAgencia = new GestionAgencia();
        Scanner scanner = new Scanner(System.in);
        gestionAgenciaMenu(gestionAgencia, scanner);
    }
    private static void gestionAgenciaMenu(GestionAgencia gestionAgencia, Scanner scanner) throws ExcepcionesAgencia.ClienteNoExiste {
        int opcion;
        do{
            System.out.println("-----------------------------------");
            System.out.println(" BIENVENIDO A LA GESTION DE AGENCIA ");
            System.out.println("-----------------------------------");
            System.out.println(" 1. GESTIONAR REMISES ");
            System.out.println(" 2. GESTIONAR TAXIS ");
            System.out.println(" 3. GESTIONAR CLIENTES ");
            System.out.println(" 4. GESTIONAR VIAJE ");
            System.out.println(" 5. MOSTRAR BASE DE DATOS");
            System.out.println(" 6. SALIR ");
            System.out.println("-----------------------------------");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    gestionRemise(gestionAgencia, scanner);
                    break;
                case 2:
                    gestionTaxi(gestionAgencia, scanner);
                    break;
                case 3:
                    gestionClientes(gestionAgencia, scanner);
                    break;
                case 4:
                    gestionViajes(gestionAgencia, scanner);
                    break;
                case 5:
                    gestionAgencia.mostrarTodo();
                    break;
                case 6:
                    System.out.println("-----------------------------------");
                    System.out.println(" GRACIAS POR UTILIZAR NUESTRO SISTEMA ");
                    System.out.println("-----------------------------------");
                    break;
                default:
                    System.out.println("-----------------------------------");
                    System.out.println(" OPCION INCORRECTA ");
                    System.out.println("-----------------------------------");
                    break;
            }
        }while (opcion != 6);
    }
    private static void gestionRemise(GestionAgencia gestionAgencia, Scanner scanner) {
        int opcionRemis;
        do{
            System.out.println("-----------------------------------");
            System.out.println(" GESTION DE REMISES ");
            System.out.println("-----------------------------------");
            System.out.println(" 1. LISTAR REMISES ");
            System.out.println(" 2. AGREGAR REMIS ");
            System.out.println(" 3. ELIMINAR REMIS ");
            System.out.println(" 4. MODIFICAR REMIS ");
            System.out.println(" 5. SALIR ");
            System.out.println("-----------------------------------");
            opcionRemis = scanner.nextInt();
            switch (opcionRemis){
                case 1:
                    gestionAgencia.mostrarRemises();
                    break;
                case 2:
                    gestionAgencia.agregar(new Remis("Volkswagen", "Polo", "Nafta" ,"SEF672"));
                    break;
                case 3:
                    gestionAgencia.eliminar(new Remis("Volkswagen", "Polo", "Nafta" ,"SEF672"));
                    break;
                case 4:
                    gestionAgencia.modificar(new Remis("Volkswagen", "Polo", "Gas" ,"SEF672"));
                    break;
                case 5:
                    System.out.println("-----------------------------------");
                    System.out.println(" VOLVIENDO AL MENU PRINCIPAL ");
                    System.out.println("-----------------------------------");
                    break;
                default:
                    System.out.println("-----------------------------------");
                    System.out.println(" OPCION INCORRECTA ");
                    System.out.println("-----------------------------------");
                    break;
            }
        }while (opcionRemis != 5);
    }
    private static void gestionTaxi(GestionAgencia gestionAgencia, Scanner scanner) {
        int opcionTaxi;
        do{
            System.out.println("-----------------------------------");
            System.out.println(" GESTION DE TAXIS ");
            System.out.println("-----------------------------------");
            System.out.println(" 1. LISTAR TAXIS ");
            System.out.println(" 2. AGREGAR TAXI ");
            System.out.println(" 3. ELIMINAR TAXI ");
            System.out.println(" 4. MODIFICAR TAXI ");
            System.out.println(" 5. SALIR ");
            System.out.println("-----------------------------------");
            opcionTaxi = scanner.nextInt();
            switch (opcionTaxi){
                case 1:
                    gestionAgencia.mostrarTaxis();
                    break;
                case 2:
                    gestionAgencia.agregar(new Taxi("Volkswagen", "Polo", "Nafta" ,"SEF672"));
                    break;
                case 3:
                    gestionAgencia.eliminar(new Taxi("Volkswagen", "Polo", "Nafta" ,"SEF672"));
                    break;
                case 4:
                    gestionAgencia.modificar(new Taxi("Volkswagen", "Polo", "Gas" ,"SEF672"));
                    break;
                case 5:
                    System.out.println("-----------------------------------");
                    System.out.println(" VOLVIENDO AL MENU PRINCIPAL ");
                    System.out.println("-----------------------------------");
                    break;
                default:
                    System.out.println("-----------------------------------");
                    System.out.println(" OPCION INCORRECTA ");
                    System.out.println("-----------------------------------");
                    break;
            }
        }while (opcionTaxi != 5);
    }
    private static void gestionClientes(GestionAgencia gestionAgencia, Scanner scanner) {
        int opcionCliente;
        do{
            System.out.println("-----------------------------------");
            System.out.println(" GESTION DE CLIENTES ");
            System.out.println("-----------------------------------");
            System.out.println(" 1. LISTAR CLIENTES ");
            System.out.println(" 2. AGREGAR CLIENTE ");
            System.out.println(" 3. ELIMINAR CLIENTE ");
            System.out.println(" 4. MODIFICAR CLIENTE ");
            System.out.println(" 5. SALIR ");
            System.out.println("-----------------------------------");
            opcionCliente = scanner.nextInt();
            switch (opcionCliente){
                case 1:
                    gestionAgencia.mostrarClientes();
                    break;
                case 2:
                    gestionAgencia.agregar(new Cliente("Jorge", "Karp", "2262618431" ,"612078"));
                    break;
                case 3:
                    gestionAgencia.eliminar(new Cliente("Jorge", "Karp", "2262618431" ,"612078"));
                    break;
                case 4:
                    gestionAgencia.modificar(new Cliente("Jorge", "Karp", "2262618431" ,"572129"));
                    break;
                case 5:
                    System.out.println("-----------------------------------");
                    System.out.println(" VOLVIENDO AL MENU PRINCIPAL ");
                    System.out.println("-----------------------------------");
                    break;
                default:
                    System.out.println("-----------------------------------");
                    System.out.println(" OPCION INCORRECTA ");
                    System.out.println("-----------------------------------");
                    break;
            }
        }while (opcionCliente != 5);
    }
    private static void gestionViajes(GestionAgencia gestionAgencia, Scanner scanner) throws ExcepcionesAgencia.ClienteNoExiste {
        int opcionViaje;
        do {
            System.out.println("-----------------------------------");
            System.out.println(" GESTION DE VIAJES ");
            System.out.println("-----------------------------------");
            System.out.println(" 1. VEHICULOS DISPONIBLES ");
            System.out.println(" 2. PEDIR VIAJE ");
            System.out.println(" 3. VIAJES EN PROGRESO ");
            System.out.println(" 4. IMPRIMIR TICKET ");
            System.out.println(" 5. FINALIZAR VIAJE ");
            System.out.println(" 6. VER RECAUDADO ");
            System.out.println(" 7. SALIR ");
            System.out.println("-----------------------------------");
            opcionViaje = scanner.nextInt();
            switch (opcionViaje){
                case 1:
                    gestionAgencia.mostrarVehiculosDisponibles();
                    break;
                case 2:
                    gestionAgencia.pedirViaje("2235685241", 3);
                    break;
                case 3:
                    gestionAgencia.viajeEnCurso();
                    break;
                case 4:
                    gestionAgencia.imprimirTicket("2235685241",3);
                    break;
                case 5:
                    gestionAgencia.finalizarViaje("2235685241");
                    break;
                case 6:
                    gestionAgencia.mostrarRecaudado();
                    break;
                case 7:
                    System.out.println("-----------------------------------");
                    System.out.println(" VOLVIENDO AL MENU PRINCIPAL ");
                    System.out.println("-----------------------------------");
                    break;
                default:
                    System.out.println("-----------------------------------");
                    System.out.println(" OPCION INCORRECTA ");
                    System.out.println("-----------------------------------");
                    break;
            }
        }while (opcionViaje != 7);
    }
}
