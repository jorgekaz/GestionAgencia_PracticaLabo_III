package org.examples.Repositorios;
import org.examples.Models.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ClienteRepo implements IRepository<Cliente> {
    public static final File archivoClientes = new File("src/main/java/org/examples/archivos/clientes.json");
    protected List<Cliente> listaClientes;
    protected ObjectMapper mapper = new ObjectMapper();

    public ClienteRepo() {
        cargar();
    }
    @Override
    public void cargar() {
        try {
            CollectionType listaCliente = mapper.getTypeFactory().constructCollectionType(List.class, Cliente.class);
            this.listaClientes = mapper.readValue(archivoClientes, listaCliente);
        } catch (IOException e) {
            System.out.println("Error al cargar los elementos: " + e.getMessage());
            this.listaClientes = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(archivoClientes), this.listaClientes);
        } catch (IOException e) {
            System.out.println("Error al guardar los elementos: " + e.getMessage());
        }
    }
    @Override
    public void agregar(Cliente... elemento) {
        this.listaClientes.addAll(List.of(elemento));
        guardar();
    }
    @Override
    public void eliminar(Cliente elemento) {
        Cliente clienteEliminar = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getTelefono().equals(elemento.getTelefono())) {
                clienteEliminar = cliente;
                break;
            }
        }
        if(clienteEliminar != null) {
            this.listaClientes.remove(clienteEliminar);
        }else{
            System.out.println("El cliente no existe");
        }
        guardar();

    }
    @Override
    public void modificar(Cliente elemento) {
        for (Cliente cliente : this.listaClientes) {
            if (cliente.getTelefono().equals(elemento.getTelefono())) {
                cliente.setNombre(elemento.getNombre());
                cliente.setApellido(elemento.getApellido());
                cliente.setDireccion(elemento.getDireccion());
                break;
            }
        }
        guardar();
    }
    @Override
    public List<Cliente> listar() {

        return this.listaClientes;
    }
    public boolean existeTelefono(String telefono) {
        for (Cliente cliente : this.listaClientes) {
            if (cliente.getTelefono().equals(telefono)) {
                return true; // la dirección ya existen
            }
        }
        return false; // la dirección no existen
    }
}
