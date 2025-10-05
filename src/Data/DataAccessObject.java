package Data;

import Model.Producto;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface DataAccessObject<T> {


    void guardar(List<T> lista) throws IOException;


    List<T> obtenerTodos() throws IOException, ClassNotFoundException;


}
