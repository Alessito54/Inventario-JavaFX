package Model;

import java.io.Serializable;

public class Producto implements Serializable {
    private String nombre;
    private int stock;
    private String descripcion_producto;
    private String area;
    private String id_producto;
    private Double precio;

    public Producto(String nombre, int stock, String descripcion_producto, String area, String id_producto,Double precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.descripcion_producto = descripcion_producto;
        this.area = area;
        this.id_producto = id_producto;
        this.precio = precio;
    }

    public void aumentarStock(int stock) {
        this.stock += stock;
    }
    public  void diminuirStock(int stock) {
        this.stock -= stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", descripcion_producto='" + descripcion_producto + '\'' +
                ", area='" + area + '\'' +
                ", id_producto='" + id_producto + '\'' +
                ", precio=" + precio +
                '}';
    }
}
