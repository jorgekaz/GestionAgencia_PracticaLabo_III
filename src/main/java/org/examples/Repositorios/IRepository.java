package org.examples.Repositorios;
import java.util.List;

public interface IRepository <T>{
    void cargar();
    void guardar();
    void agregar(T... elemento);
    void eliminar(T elemento);
    void modificar(T elemento);
    List<T> listar();
}
