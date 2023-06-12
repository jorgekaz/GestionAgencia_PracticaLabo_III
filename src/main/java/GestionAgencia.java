import org.examples.Models.*;
import org.examples.Repositorios.*;
import java.util.ArrayList;
import java.util.List;

public class GestionAgencia<T> {
    private RemisRepo remisRepo = new RemisRepo();
    private TaxiRepo taxiRepo  = new TaxiRepo();
    private ClienteRepo clienteRepo = new ClienteRepo();
    private TicketRepo ticketRepo = new TicketRepo();

    // CONSTRUCTOR
    public GestionAgencia() {
    }

    // GETTERS AND SETTERS
    public RemisRepo getRemisRepo() {
        return remisRepo;
    }

    public void setRemisRepo(RemisRepo remisRepo) {
        this.remisRepo = remisRepo;
    }

    public TaxiRepo getTaxiRepo() {
        return taxiRepo;
    }

    public void setTaxiRepo(TaxiRepo taxiRepo) {
        this.taxiRepo = taxiRepo;
    }

    public ClienteRepo getClienteRepo() {
        return clienteRepo;
    }

    public void setClienteRepo(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    public TicketRepo getTicketRepo() {
        return ticketRepo;
    }

    public void setTicketRepo(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    // METODOS

    // AGREGA ELEMENTOS A LA LISTA
    public void agregar(T... elementos) {
        agregarElemento(elementos);
    }

    // VERIFICA QUE ELEMENTO QUIERE AGREGAR Y LO AGREGA
    private void agregarElemento(T[] elementos) {
        try {
            for (T elemento : elementos) {
                if (elemento instanceof Remis) {
                    agregarRemis((Remis) elemento);
                } else if (elemento instanceof Taxi) {
                    agregarTaxi((Taxi) elemento);
                } else if (elemento instanceof Cliente) {
                    agregarCliente((Cliente) elemento);
                }
            }
        }catch (ExcepcionesAgencia.ClienteYaExiste | ExcepcionesAgencia.TaxiYaExiste | ExcepcionesAgencia.RemisYaExiste e) {
            System.out.println(e.getMessage());
        }
    }

    // AGREGA UN REMIS A LA LISTA
    private void agregarRemis(Remis elemento) throws ExcepcionesAgencia.RemisYaExiste {
        Remis remis = elemento;
        remis.setEstado(Estado.DISPONIBLE);
        if (!remisRepo.existePatente(remis.getPatente())) {
            remisRepo.agregar(remis);
            System.out.println("REMIS " + remis.getMarca() + " " + remis.getModelo() + " " + remis.getPatente() + " AGREGADO CORRECTAMENTE");
        } else if (remisRepo.existePatente(remis.getPatente())) {
            throw new ExcepcionesAgencia.RemisYaExiste("LA PATENTE DEL REMIS " + remis.getPatente() + " YA EXISTE");
        }
    }

    // AGREGA UN TAXI A LA LISTA
    private void agregarTaxi(Taxi elemento) throws ExcepcionesAgencia.TaxiYaExiste {
        Taxi taxi = elemento;
        taxi.setEstado(Estado.DISPONIBLE);
        if (!taxiRepo.existePatente(taxi.getPatente())) {
            taxiRepo.agregar(taxi);
            System.out.println("TAXI " + taxi.getMarca() + " " + taxi.getModelo() + " " + taxi.getPatente() + " AGREGADO CORRECTAMENTE");
        }else if (taxiRepo.existePatente(taxi.getPatente())) {
            throw new ExcepcionesAgencia.TaxiYaExiste("LA PATENTE DEL TAXI " + taxi.getPatente() + " YA EXISTE");
        }
    }

    // AGREGA UN CLIENTE A LA LISTA
    private void agregarCliente(Cliente elemento) throws ExcepcionesAgencia.ClienteYaExiste {
        Cliente cliente = elemento;
        cliente.setEnViaje(false);
        if (!clienteRepo.existeTelefono(cliente.getTelefono())) {
            clienteRepo.agregar(cliente);
            System.out.println("CLIENTE " + cliente.getNombre() + " " + cliente.getApellido() + " AGREGADO CORRECTAMENTE");
        } else if (clienteRepo.existeTelefono(cliente.getTelefono())) {
            throw new ExcepcionesAgencia.ClienteYaExiste("EL TELEFONO DEL CLIENTE " + cliente.getTelefono() + " YA EXISTE");
        }
    }

    // ELIMINA ELEMENTOS DE LA LISTA
    public void eliminar(T elemento){
        eliminarElemento(elemento);
    }

    // VERIFICA QUE ELEMENTO QUIERE ELIMINAR Y LO ELIMINA
    private void eliminarElemento(T elemento) {
        try {
            if (elemento instanceof Remis) {
                eliminarRemis((Remis) elemento);

            } else if (elemento instanceof Taxi) {
                eliminarTaxi((Taxi) elemento);

            } else if (elemento instanceof Cliente) {
                eliminarCliente((Cliente) elemento);
            }
        }catch (ExcepcionesAgencia.RemisNoExiste | ExcepcionesAgencia.TaxiNoExiste | ExcepcionesAgencia.ClienteNoExiste e){
            System.out.println(e.getMessage());
        }
    }

    // ELIMINA UN REMIS DE LA LISTA
    private void eliminarCliente(Cliente elemento) throws ExcepcionesAgencia.ClienteNoExiste {
        if (!clienteRepo.existeTelefono(elemento.getTelefono())) {
            throw new ExcepcionesAgencia.ClienteNoExiste("EL TELEFONO DEL CLIENTE " + elemento.getTelefono() + " NO EXISTE");
        } else if (clienteRepo.existeTelefono(elemento.getTelefono())) {
            clienteRepo.eliminar(elemento);
            System.out.println("CLIENTE " + elemento.getNombre() + " " + elemento.getApellido() + " ELIMINADO CORRECTAMENTE");
            elemento.setEnViaje(false);
        }
    }

    // ELIMINA UN TAXI DE LA LISTA
    private void eliminarTaxi(Taxi elemento) throws ExcepcionesAgencia.TaxiNoExiste {
        if (!taxiRepo.existePatente(elemento.getPatente())) {
            throw new ExcepcionesAgencia.TaxiNoExiste("LA PATENTE DEL TAXI " + elemento.getPatente() + " NO EXISTE");
        } else if (taxiRepo.existePatente(elemento.getPatente())) {
            taxiRepo.eliminar(elemento);
            System.out.println("TAXI " + elemento.getMarca() + " " + elemento.getModelo() + " " + elemento.getPatente() + " ELIMINADO CORRECTAMENTE");
            elemento.setEstado(Estado.DISPONIBLE);
        }
    }

    // ELIMINA UN REMIS DE LA LISTA
    private void eliminarRemis(Remis elemento) throws ExcepcionesAgencia.RemisNoExiste {
        if (!remisRepo.existePatente(elemento.getPatente())) {
            throw new ExcepcionesAgencia.RemisNoExiste("LA PATENTE DEL REMIS " + elemento.getPatente() + " NO EXISTE");
        } else if (remisRepo.existePatente(elemento.getPatente())) {
            remisRepo.eliminar(elemento);
            System.out.println("REMIS " + elemento.getMarca() + " " + elemento.getModelo() + " " + elemento.getPatente() + " ELIMINADO CORRECTAMENTE");
            elemento.setEstado(Estado.DISPONIBLE);
        }
    }

    // MODIFICA ELEMENTOS DE LA LISTA
    public void modificar (T elemento) {
        modificarElementos(elemento);
    }

    // VERIFICA QUE ELEMENTO QUIERE MODIFICAR Y LO MODIFICA
    private void modificarElementos(T elemento){
        try {
            if (elemento instanceof Remis) {
                modificarRemis((Remis) elemento);

            } else if (elemento instanceof Taxi) {
                modificarTaxi((Taxi) elemento);

            } else if (elemento instanceof Cliente) {
                modificarCliente((Cliente) elemento);
            }
        }catch (ExcepcionesAgencia.RemisNoExiste | ExcepcionesAgencia.TaxiNoExiste | ExcepcionesAgencia.ClienteNoExiste e){
            System.out.println(e.getMessage());
        }
    }

    // MODIFICA UN CLIENTE DE LA LISTA
    private void modificarCliente(Cliente elemento) throws ExcepcionesAgencia.ClienteNoExiste {
        if (!clienteRepo.existeTelefono(elemento.getTelefono())) {
            throw new ExcepcionesAgencia.ClienteNoExiste("EL TELEFONO DEL CLIENTE " + elemento.getTelefono() + " NO EXISTE");
        } else {
            clienteRepo.modificar(elemento);
            System.out.println("DATOS DEL CLIENTE " + elemento.getNombre() + " " + elemento.getApellido() + " MODIFICADO CORRECTAMENTE");
        }
    }

    // MODIFICA UN TAXI DE LA LISTA
    private void modificarTaxi(Taxi elemento) throws ExcepcionesAgencia.TaxiNoExiste {
        if(!taxiRepo.existePatente(elemento.getPatente())) {
            throw new ExcepcionesAgencia.TaxiNoExiste("LA PATENTE DEL TAXI " + elemento.getPatente() + " NO EXISTE");
        }else{
            taxiRepo.modificar(elemento);
            System.out.println("TIPO DE COMBUSTIBLE DE " + elemento.getMarca() + " " + elemento.getModelo() + " " + elemento.getPatente() + " MODIFICADO CORRECTAMENTE");
        }
    }

    // MODIFICA UN REMIS DE LA LISTA
    private void modificarRemis(Remis elemento) throws ExcepcionesAgencia.RemisNoExiste {
        if(!remisRepo.existePatente(elemento.getPatente())) {
            throw new ExcepcionesAgencia.RemisNoExiste("LA PATENTE DEL REMIS " + elemento.getPatente() + " NO EXISTE");
        }else{
            remisRepo.modificar(elemento);
            System.out.println("TIPO DE COMBUSTIBLE DE " + elemento.getMarca() + " " + elemento.getModelo() + " " + elemento.getPatente() + " MODIFICADO CORRECTAMENTE");
        }
    }

    // MUESTRA LOS REMISES
    public void mostrarRemises() {
        for (Remis remis : remisRepo.listar()) {
            System.out.println(remis);
        }
    }

    // MUESTRA LOS TAXIS
    public void mostrarTaxis(){
        for (Taxi taxi : taxiRepo.listar()) {
            System.out.println(taxi);
        }
    }

    // MUESTRA LOS CLIENTES
    public void mostrarClientes(){
        for (Cliente cliente : clienteRepo.listar()) {
            System.out.println(cliente);
        }
    }

    // MUESTRA TODOS LOS ELEMENTOS (BASE DE DATOS)
    public void mostrarTodo(){
        System.out.println("==== REMISES =====");
        mostrarRemises();
        System.out.println("==== TAXIS =====");
        mostrarTaxis();
        System.out.println("==== CLIENTES =====");
        mostrarClientes();
    }

    // OBTIENE UN VEHICULO POR PATENTE
    public void pedirViaje(String telefono, double kilometros) throws ExcepcionesAgencia.ClienteNoExiste {
        try {
            Cliente cliente = obtenerCliente(telefono);
            if (cliente == null) {
                throw new ExcepcionesAgencia.ClienteNoExiste("EL TELEFONO " + telefono + " NO EXISTE");
            }else if (cliente.isEnViaje()) {
                throw new ExcepcionesAgencia.ClienteEnViaje("EL CLIENTE " + cliente.getNombre() + " " + cliente.getApellido() + " YA SE ENCUENTRA EN VIAJE");
            }
            List<Taxi> taxiDisponibles = obtenerTaxisDisponibles();
            List<Remis> remisDisponibles = obtenerRemisesDisponibles();
            if (taxiDisponibles.isEmpty() && remisDisponibles.isEmpty()) {
                throw new ExcepcionesAgencia.VehiculosNoDisponibles("NO HAY VEHICULOS DISPONIBLES");
            }
            vehiculosDisponibles(cliente, taxiDisponibles, remisDisponibles);
            System.out.println("---------------------------------------------");
        } catch (ExcepcionesAgencia.ClienteNoExiste | ExcepcionesAgencia.ClienteEnViaje | ExcepcionesAgencia.VehiculosNoDisponibles e){
            System.out.println(e.getMessage());
        }
    }

    // VER VEHICULOS DISPONIBLES
    private void vehiculosDisponibles(Cliente cliente, List<Taxi> taxiDisponibles, List<Remis> remisDisponibles) {
        if (!taxiDisponibles.isEmpty()) taxiDisponible(cliente, taxiDisponibles);
        else remisDisponible(cliente, remisDisponibles);
    }

    // TAXIS DISPONIBLES
    private void taxiDisponible(Cliente cliente, List<Taxi> taxiDisponibles) {
        Taxi taxiDisponible = taxiDisponibles.get(0);
        cliente.setVehiculo(taxiDisponible);
        cliente.setEnViaje(true);
        taxiDisponible.setEstado(Estado.OCUPADO);
        taxiRepo.guardar();
        clienteRepo.guardar();
        taxiAsignado(cliente, taxiDisponible);
    }

    // ASIGNACION DE TAXIS
    private static void taxiAsignado(Cliente cliente, Taxi taxiDisponible) {
        System.out.println("---------------------------------------------");
        System.out.println("========= TAXI ASIGNADO =========");
        System.out.println("---------------------------------------------");
        System.out.println("EL CLIENTE " + cliente.getNombre() + " " + cliente.getApellido() + " HA PEDIDO UN TAXI");
        System.out.println("EL TAXI " + taxiDisponible.getPatente() + " HA SIDO ASIGNADO A " + cliente.getNombre());
    }

    // REMISES DISPONIBLES
    private void remisDisponible(Cliente cliente, List<Remis> remisDisponibles) {
        Remis remisDisponible = remisDisponibles.get(0);
        cliente.setVehiculo(remisDisponible);
        cliente.setEnViaje(true);
        remisDisponible.setEstado(Estado.OCUPADO);
        clienteRepo.guardar();
        remisRepo.guardar();
        remisAsignado(cliente, remisDisponible);
    }

    // ASIGNACION DE REMISES
    private static void remisAsignado(Cliente cliente, Remis remisDisponible) {
        System.out.println("---------------------------------------------");
        System.out.println("========= REMIS ASIGNADO =========");
        System.out.println("---------------------------------------------");
        System.out.println("EL CLIENTE " + cliente.getNombre() + " " + cliente.getApellido() + " HA PEDIDO UN REMIS");
        System.out.println("EL REMIS " + remisDisponible.getPatente() + " HA SIDO ASIGNADO A " + cliente.getNombre());
    }

    // OBTIENE UN CLIENTE POR TELEFONO
    private Cliente obtenerCliente(String telefono){
        for (Cliente cliente : clienteRepo.listar()) {
            if(cliente.getTelefono().equals(telefono)){
                return cliente;
            }
        }
        return null;
    }

    // OBTIENE LOS TAXIS DISPONIBLES
    public List<Taxi> obtenerTaxisDisponibles() {
        List<Taxi> taxisDisponibles = new ArrayList<>();

        for (Taxi taxi : taxiRepo.listar()) {
            if (taxi.getEstado() == Estado.DISPONIBLE) {
                taxisDisponibles.add(taxi);
            }
        }
        return taxisDisponibles;
    }

    // OBTIENE LOS REMISES DISPONIBLES
    public List<Remis> obtenerRemisesDisponibles() {
        List<Remis> remisesDisponibles = new ArrayList<>();
        for (Remis remis : remisRepo.listar()) {
            if (remis.getEstado() == Estado.DISPONIBLE) {
                remisesDisponibles.add(remis);
            }
        }
        return remisesDisponibles;
    }

    // MUESTRA LOS VEHICULOS DISPONIBLES
    public void mostrarVehiculosDisponibles() {
        List<Taxi> taxisDisponibles = obtenerTaxisDisponibles();
        List<Remis> remisesDisponibles = obtenerRemisesDisponibles();
        // IMPRIME LOS VEHICULOS DISPONIBLES
        mostrarDisponibles(taxisDisponibles, remisesDisponibles);
    }

    // IMPRIME LOS VEHICULOS DISPONIBLES
    private static void mostrarDisponibles(List<Taxi> taxisDisponibles, List<Remis> remisesDisponibles) {
        System.out.println("---------------------------------------------");
        System.out.println("========= TAXIS DISPONIBLES =========");
        System.out.println("---------------------------------------------");
        for (Taxi taxi : taxisDisponibles) {
            System.out.println(taxi);
        }
        System.out.println("---------------------------------------------");
        System.out.println("========= REMISES DISPONIBLES =========");
        System.out.println("---------------------------------------------");
        for (Remis remis : remisesDisponibles) {
            System.out.println(remis);
        }
    }

    // MUESTRA LOS VIAJES EN CURSO
    public void viajeEnCurso(){
        for (Cliente cliente : clienteRepo.listar()) {
            if(cliente.isEnViaje()){
                // IMPRIME LOS VIAJES EN CURSO
                mostrarEnCurso(cliente);
            }
        }
    }

    // IMPRIME LOS VIAJES EN CURSO
    private static void mostrarEnCurso(Cliente cliente) {
        System.out.println("---------------------------------------------");
        System.out.println("========= VIAJE EN CURSO =========");
        System.out.println("---------------------------------------------");
        System.out.println("El cliente " + cliente.getNombre() + " se encuentra en viaje");
        System.out.println("El vehiculo asignado es " + cliente.getVehiculo().getPatente());
        System.out.println("---------------------------------------------");
    }

    // FINALIZA UN VIAJE
    public void finalizarViaje(String telefono){
        try{
            Cliente cliente = obtenerCliente(telefono);
            if(cliente == null){
                throw new ExcepcionesAgencia("EL CLIENTE " + cliente.getTelefono() + " NO EXISTE");
            }
            if(!cliente.isEnViaje()){
                throw new ExcepcionesAgencia("EL CLIENTE " + cliente.getNombre() + " NO SE ENCUENTRA EN VIAJE");
            }
            Vehiculo vehiculo = cliente.getVehiculo();
            vehiculo.setEstado(Estado.DISPONIBLE);
            cliente.setVehiculo(null);
            cliente.setEnViaje(false);
            clienteRepo.guardar();
            System.out.println("---------------------------------------------");
            System.out.println("========= FINALIZANDO VIAJE =========");
            System.out.println("---------------------------------------------");
            finalizandoViaje(cliente, vehiculo);
            System.out.println("---------------------------------------------");
        }catch (ExcepcionesAgencia e) {
            System.out.println(e.getMessage());
        }
    }

    // IMPRIME EL FINAL DE UN VIAJE
    private void finalizandoViaje(Cliente cliente, Vehiculo vehiculo) {
        if(vehiculo instanceof Taxi){
            taxiRepo.guardar();
            System.out.println("EL CLIENTE " + cliente.getNombre() + " HA FINALIZADO SU VIAJE");
            System.out.println("EL TAXI" + vehiculo.getPatente() + " HA SIDO LIBERADO");
        }else{
            remisRepo.guardar();
            System.out.println("EL CLIENTE " + cliente.getNombre() + " HA FINALIZADO SU VIAJE");
            System.out.println("EL REMIS" + vehiculo.getPatente() + " HA SIDO LIBERADO");
        }
    }

    // IMPRIME EL TICKETS
    public void imprimirTicket (String telefono, double kilometros){
        try{
            Vehiculo vehiculo = obtenerCliente(telefono).getVehiculo();
            double costoTotal;
            if(vehiculo instanceof Taxi){
                costoTotal = ((Taxi) vehiculo).getBajadaBandera()+((Taxi) vehiculo).getPrecioKilometro() * kilometros;
            }else{
                costoTotal = ((Remis) vehiculo).getTarifaCuadra() * kilometros;
            }
            Ticket ticket = new Ticket(vehiculo.getPatente(), costoTotal);
            int ultimoID = intObtenerUltimoId();
            ticket.setId(ultimoID);
            mostrarTicket(telefono, vehiculo, costoTotal, ticket);
            ticketRepo.agregar(ticket);
            ticketRepo.guardar();

        }catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    // OBTIENE EL ULTIMO ID DE LOS TICKETS
    public int intObtenerUltimoId() {
        List<Ticket> tickets = ticketRepo.listar();
        if(tickets.isEmpty()) {
            return 0;
        }else{
            int ultimoID = 0;
            for (Ticket ticket : tickets) {
                if (ticket.getId() > ultimoID) {
                    ultimoID = ticket.getId();
                }
            }
            return ultimoID+1;
        }
    }

    // MUESTRA EL TICKET
    private void mostrarTicket(String telefono, Vehiculo vehiculo, double costoTotal, Ticket ticket) {
        System.out.println("---------------------------------------------");
        System.out.println("========= TICKET =========");
        System.out.println("---------------------------------------------");
        System.out.println("ID: " + ticket.getId());
        System.out.println("CLIENTE: " + obtenerCliente(telefono).getNombre());
        System.out.println("VEHICULO: " + vehiculo.getPatente());
        System.out.println("COSTO VIAJE: " + costoTotal);
        System.out.println("---------------------------------------------");
    }

    // CALCULAR RECAUDADO
    public double calcularRecaudado(){
        double recaudado = 0;
        for (Ticket ticket : ticketRepo.listar()) {
            recaudado += ticket.getPrecio();
        }
        return recaudado;
    }

    // MOSTRAR RECAUDADO
    public void mostrarRecaudado(){
        System.out.println("---------------------------------------------");
        System.out.println("========= RECAUDADO =========");
        System.out.println("---------------------------------------------");
        System.out.println("EL TOTAL RECAUDADO ES: " + calcularRecaudado());
        System.out.println("---------------------------------------------");
    }
}

