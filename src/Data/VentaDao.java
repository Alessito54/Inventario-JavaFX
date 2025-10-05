package Data;

import Model.Producto;
import Model.Venta;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDao implements DataAccessObject<Venta> {
    private String archivo = "resources/ventas.dat";

    // Guardar lista completa de ventas
    public void guardar(List<Venta> lista) {
        try {
            File file = new File(archivo);

            if (!file.exists()) {
                file.getParentFile().mkdirs(); // crear carpeta resources si no existe
                file.createNewFile();
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(lista);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Obtener todas las ventas del archivo
    public List<Venta> obtenerTodos() {
        File file = new File(archivo);

        // Si el archivo no existe o está vacío, devolvemos lista vacía
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Venta>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    public void borrar() {
        try (PrintWriter writer = new PrintWriter(new File(archivo))) {
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
