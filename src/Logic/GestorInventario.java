package Logic;

import Data.ProductoDao;
import Model.Producto;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class GestorInventario {

    private ProductoDao productoDao;
    private List<Producto> inventarioEnMemoria;

    public GestorInventario() throws IOException, ClassNotFoundException {
        this.productoDao = new ProductoDao();
        this.inventarioEnMemoria = this.productoDao.obtenerTodos();
    }

    public List pruebaVentas(){
        return inventarioEnMemoria;
    }

    public void guardar(){
        productoDao.guardar(inventarioEnMemoria);
    }

    public Producto obtenerPorId(String id) {
        for (Producto producto : inventarioEnMemoria) {
            if (producto.getId_producto().equals(String.valueOf(id))) {
                return producto;
            }
        }
        return null;
    }

    public void agregarProducto(String nombre, int stock, String descripcion_producto, String area,Double precio, String id_producto) {
        Producto producto = new Producto(nombre, stock, descripcion_producto, area, id_producto,precio);
        inventarioEnMemoria.add(producto);
    }

    public void eliminarProducto(String id) {
        Producto producto = obtenerPorId(id);
        if(productoExistente(id)){
            inventarioEnMemoria.remove(producto);
        }

    }


    public List<Producto> verInventario() {
        return Collections.unmodifiableList(inventarioEnMemoria);
    }

    public void actualizarProducto(String id,int opcion,String dato) {
        Producto producto = obtenerPorId(id);
        if(producto  != null){
            switch (opcion) {
                case 1:
                        producto.setNombre(dato);
                    break;

                case 2:
                        producto.setDescripcion_producto(dato);
                    break;

                case 3:
                        producto.setArea(dato);
                    break;

                case 4:
                        producto.setStock(Integer.parseInt(dato));
                    break;
                case 5:
                        producto.setPrecio(Double.parseDouble(dato));
                    break;
            }
        }

    }

    public boolean productoExistente(String id){
        return obtenerPorId(id) != null;
    }

    public List<Producto> filtrarProductos() {
        return null;
    }
}
