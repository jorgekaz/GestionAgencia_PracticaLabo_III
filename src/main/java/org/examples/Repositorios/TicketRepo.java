package org.examples.Repositorios;
import org.examples.Models.Ticket;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketRepo implements IRepository<Ticket>{
    private static final File archivoTicket = new File("src/main/java/org/examples/archivos/tickets.json");
    protected List<Ticket> listaTickets;
    protected ObjectMapper mapper = new ObjectMapper();

    public TicketRepo() {
        cargar();
    }

    @Override
    public void cargar() {
        try {
            CollectionType listaTicket = mapper.getTypeFactory().constructCollectionType(List.class, Ticket.class);
            this.listaTickets = mapper.readValue(archivoTicket, listaTicket);
        } catch (IOException e) {
            System.out.println("Error al cargar los elementos: " + e.getMessage());
            this.listaTickets = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(archivoTicket), this.listaTickets);
        } catch (IOException e) {
            System.out.println("Error al guardar los elementos: " + e.getMessage());
        }
    }

    @Override
    public void agregar(Ticket... elemento) {
        this.listaTickets.addAll(List.of(elemento));
        guardar();
    }

    @Override
    public void eliminar(Ticket elemento) {
        Ticket ticketEliminar = null;
        for (Ticket ticket : listaTickets) {
            if (ticket.getId() == elemento.getId()) {
                ticketEliminar = ticket;
                break;
            }
        }
        if(ticketEliminar != null) {
            this.listaTickets.remove(ticketEliminar.getId());
            System.out.println("El ticket " + ticketEliminar.getId() + " se ha eliminado correctamente");
        }else{
            System.out.println("El ticket no existe");
        }
        guardar();
    }
    @Override
    public void modificar(Ticket elemento) {
    }
    @Override
    public List<Ticket> listar() {
        return this.listaTickets;
    }

}
