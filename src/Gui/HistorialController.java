package Gui;

import Logic.GestorVentas;
import Model.Producto;
import Model.Venta;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;

public class HistorialController {

    @FXML private TableView<Venta> tablaVentas;
    @FXML private TableColumn<Venta, String> colIdVenta;
    @FXML private TableColumn<Venta, LocalDate> colFecha;
    @FXML private TableColumn<Venta, Double> colTotal;
    @FXML private TextArea txtDetallesVenta;

    private GestorVentas gestorVentas;

    @FXML
    public void initialize() {
        gestorVentas = new GestorVentas();


        colIdVenta.setCellValueFactory(new PropertyValueFactory<>("idVenta"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaVenta"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));


        tablaVentas.getItems().setAll(gestorVentas.visualizarHistorial());


        tablaVentas.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostrarDetalles(newValue)
        );
    }

    private void mostrarDetalles(Venta venta) {
        if (venta == null) {
            txtDetallesVenta.clear();
            return;
        }


        StringBuilder detalles = new StringBuilder();
        detalles.append(String.format("ID: %s\n", venta.getIdVenta()));
        detalles.append(String.format("Fecha: %s\n", venta.getFechaVenta()));
        detalles.append(String.format("Total: $%.2f\n", venta.getTotal()));
        detalles.append("----------------------------------\n");



        txtDetallesVenta.setText(detalles.toString());
    }
}