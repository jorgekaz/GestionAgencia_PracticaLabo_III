//IMPORTAR
package org.examples.Repositorios;
import org.examples.Models.Remis;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class RemisRepo implements IRepository<Remis> {
    public static final File archivoRemises = new File("src/main/java/org/examples/archivos/remises.json");
    protected List<Remis> listaRemises;
    protected ObjectMapper mapper = new ObjectMapper();

    public RemisRepo() {
        cargar();
    }
    @Override
    public void cargar() {
        try {
            CollectionType listaRemis = mapper.getTypeFactory().constructCollectionType(List.class, Remis.class);
            this.listaRemises = mapper.readValue(archivoRemises, listaRemis);

        } catch (IOException e) {
            System.out.println("Error al cargar los elementos: " + e.getMessage());
            this.listaRemises = new ArrayList<>();
        }
    }
    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(archivoRemises), this.listaRemises);
        } catch (IOException e) {
            System.out.println("Error al guardar los elementos: " + e.getMessage());
        }
    }
    @Override
    public void agregar(Remis... elemento) {
        this.listaRemises.addAll(List.of(elemento));
        guardar();
    }
    @Override
    public void eliminar(Remis patente) {
        Remis remisEliminar = null;
        for (Remis remis : this.listaRemises) {
            if (remis.getPatente().equals(patente.getPatente())) {
                remisEliminar = remis;
                break;
            }
        }
        if(remisEliminar != null) {
            this.listaRemises.remove(remisEliminar);
        }else{
            System.out.println("El remis no existe");
        }
        guardar();
    }
    @Override
    public void modificar(Remis elemento) {
        for (Remis remis : this.listaRemises) {
            if (remis.getPatente().equals(elemento.getPatente())) {
                remis.setTipoCombustible(elemento.getTipoCombustible());
                remis.setTarifaCuadra(elemento.getTarifaCuadra());
                break;
            }
        }
        guardar();
    }
    @Override
    public List<Remis> listar () {
        return this.listaRemises;
    }

    public boolean existePatente (String patente) {
        for (Remis remis :  this.listaRemises) {
            if (remis.getPatente().equals(patente)) {
                return true; // La patente ya existe
            }
        }
        return false;
    }
}