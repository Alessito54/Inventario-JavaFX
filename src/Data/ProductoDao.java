package Data;

import Model.Producto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao implements DataAccessObject<Producto> {
    private String archivo = "resources/productos.dat";

    // Guardar lista completa de productos
    public void guardar(List<Producto> lista) {
        try {
            File file = new File(archivo);
            // Crear la carpeta y el archivo si no existen
            if (!file.exists()) {
                file.getParentFile().mkdirs(); // crear carpeta resources si no existe
                file.createNewFile();
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(lista);
                System.out.println("Productos guardados correctamente.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Obtener todos los productos del archivo
    public List<Producto> obtenerTodos() {
        File file = new File(archivo);

        // Si el archivo no existe o está vacío, devolvemos lista vacía
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Producto>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

