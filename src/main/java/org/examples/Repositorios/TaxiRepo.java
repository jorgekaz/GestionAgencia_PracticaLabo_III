package org.examples.Repositorios;
import org.examples.Models.Taxi;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaxiRepo implements IRepository<Taxi> {
    public static final File archivoTaxis = new File("src/main/java/org/examples/archivos/taxis.json");
    protected List<Taxi> listaTaxis;
    protected ObjectMapper mapper = new ObjectMapper();
    public TaxiRepo() {
        cargar();
    }
    @Override
    public void cargar() {
        try {
            CollectionType listaTaxi = mapper.getTypeFactory().constructCollectionType(List.class, Taxi.class);
            this.listaTaxis = mapper.readValue(archivoTaxis, listaTaxi);
        } catch (IOException e) {
            System.out.println("Error al cargar los elementos: " + e.getMessage());
            this.listaTaxis = new ArrayList<>();
        }
    }
    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(archivoTaxis), this.listaTaxis);
        } catch (IOException e) {
            System.out.println("Error al guardar los elementos: " + e.getMessage());
        }
    }
    @Override
    public void agregar(Taxi... elemento) {
        this.listaTaxis.addAll(List.of(elemento));
        guardar();
    }
    @Override
    public void eliminar(Taxi elemento) {
        Taxi taxiEliminar = null;
        for (Taxi taxi : listaTaxis) {
            if (taxi.getPatente().equals(elemento.getPatente())) {
                taxiEliminar = taxi;
                break;
            }
        }
        if(taxiEliminar != null) {
            this.listaTaxis.remove(taxiEliminar);
        }else{
            System.out.println("El taxi no existe");
        }
        guardar();
    }
    @Override
    public void modificar(Taxi elemento) {
        for (Taxi taxi : this.listaTaxis) {
            if (taxi.getPatente().equals(elemento.getPatente())) {
                taxi.setTipoCombustible(elemento.getTipoCombustible());
                taxi.setBajadaBandera(elemento.getBajadaBandera());
                taxi.setPrecioKilometro(elemento.getPrecioKilometro());
                break;
            }
        }
        guardar();
    }
    @Override
    public List<Taxi> listar() {
        return this.listaTaxis;
    }
    public boolean existePatente(String patente) {
        for (Taxi taxi : this.listaTaxis) {
            if (taxi.getPatente().equals(patente)) {
                return true; // La patente ya existe
            }
        }
        return false; // La patente no existe
    }
}
