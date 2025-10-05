package Gui;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuPrincipalController {


    @FXML
    void handleGestionarInventario(ActionEvent event) {

        WindowManager.openWindow("src/Gui/InventarioView.fxml", "Gestionar Inventario");
    }


    @FXML
    void handleRealizarVenta(ActionEvent event) {


        WindowManager.openWindow("resources/VentaView.fxml", "Realizar Venta");
    }

    @FXML
    void handleVerHistorial(ActionEvent event) {
        WindowManager.openWindow("resources/HistorialView.fxml", "Historial de Ventas");
    }

    @FXML
    void handleSalir(ActionEvent event) {
        Platform.exit();
    }
}
