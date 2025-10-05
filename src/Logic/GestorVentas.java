package Logic;

import Data.VentaDao;
import Model.Producto;
import Model.Venta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class GestorVentas {
    private VentaDao ventaDao;
    private List<Venta> ventas;
    private List<Producto> productos = new ArrayList<>();
    public GestorVentas(){
        ventaDao = new VentaDao();
        ventas = ventaDao.obtenerTodos();
    }



    public void registrarVenta() {
        System.out.println(productos);
        if (productos.isEmpty()) {
            return;
        }
        Venta venta = new Venta(generarId(), new ArrayList<>(productos));
        ventas.add(venta);
        ventaDao.guardar(ventas);

        productos.clear();
    }
    public void borrar(){
        ventaDao.borrar();
    }
    public void addProductoCarrito(Producto producto){
        productos.add(producto);
    }
    private String generarId() {
        return UUID.randomUUID().toString();
    }
    public List<Venta> visualizarHistorial(){
        return Collections.unmodifiableList(ventas);
    }

}
