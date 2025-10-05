package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Venta implements Serializable {
    private String idVenta;
    private LocalDate fechaVenta;
    private Double total;
    private List<Producto> productos;

    public Venta(String idVenta, List<Producto> productosDelCarrito) {
        this.idVenta = idVenta;
        this.productos = productosDelCarrito;
        this.fechaVenta = LocalDate.now();
        this.total = generarTotal();
    }

    private Double generarTotal() {
        Double acum = 0.0;
        for (Producto producto : this.productos) {
            acum += producto.getPrecio();
        }
        return acum;
    }

    public String getIdVenta() {
        return idVenta;
    }



    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public Double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta='" + idVenta + '\'' +
                ", fechaVenta=" + fechaVenta +
                ", total=" + total +
                ", productos=" + productos +
                '}';
    }
}
