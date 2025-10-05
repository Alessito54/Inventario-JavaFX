package Gui;
import Logic.GestorInventario;
import Logic.GestorVentas;
import Model.Producto;

import java.io.IOException;
import java.util.List;

public class MenuPrincipal {
    private GestorInventario gestorInventario;
    private GestorVentas gestorVentas;
    public MenuPrincipal() throws IOException, ClassNotFoundException {
        gestorInventario = new GestorInventario();
        gestorVentas = new GestorVentas();
    }
    
}
