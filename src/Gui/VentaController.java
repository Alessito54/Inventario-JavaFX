package Gui;

import Logic.GestorInventario;
import Logic.GestorVentas;
import Model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class VentaController {

    // Tablas y columnas
    @FXML private TableView<Producto> tablaProductosDisponibles;
    @FXML private TableColumn<Producto, String> colIdDisp;
    @FXML private TableColumn<Producto, String> colNombreDisp;
    @FXML private TableColumn<Producto, Double> colPrecioDisp;
    @FXML private TableView<Producto> tablaCarrito;
    @FXML private TableColumn<Producto, String> colIdCarrito;
    @FXML private TableColumn<Producto, String> colNombreCarrito;
    @FXML private TableColumn<Producto, Double> colPrecioCarrito;

    // Botones y Labels
    @FXML private Label lblTotal;

    private GestorInventario gestorInventario;
    private GestorVentas gestorVentas;

    private ObservableList<Producto> carritoObservable;

    @FXML
    public void initialize() {
        try {
            gestorInventario = new GestorInventario();
            gestorVentas = new GestorVentas();
        } catch (IOException | ClassNotFoundException e) {
            mostrarAlerta("Error", "No se pudieron cargar los datos: " + e.getMessage());
            return;
        }

        carritoObservable = FXCollections.observableArrayList();


        colIdDisp.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
        colNombreDisp.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecioDisp.setCellValueFactory(new PropertyValueFactory<>("precio"));


        colIdCarrito.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
        colNombreCarrito.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecioCarrito.setCellValueFactory(new PropertyValueFactory<>("precio"));


        tablaProductosDisponibles.setItems(FXCollections.observableArrayList(gestorInventario.verInventario()));
        tablaCarrito.setItems(carritoObservable);
    }

    @FXML
    void handleAgregarAlCarrito(ActionEvent event) {
        Producto seleccionado = tablaProductosDisponibles.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            carritoObservable.add(seleccionado);
            gestorVentas.addProductoCarrito(seleccionado);
            actualizarTotal();
        }
    }

    @FXML
    void handleQuitarDelCarrito(ActionEvent event) {
        Producto seleccionado = tablaCarrito.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            carritoObservable.remove(seleccionado);

            actualizarTotal();
        }
    }

    @FXML
    void handleRegistrarVenta(ActionEvent event) {
        if (carritoObservable.isEmpty()) {
            mostrarAlerta("Carrito vacío", "Agrega al menos un producto para registrar la venta.");
            return;
        }

        gestorVentas.registrarVenta();

        mostrarAlerta("Éxito", "Venta registrada correctamente.");

        carritoObservable.clear();
        actualizarTotal();
    }

    private void actualizarTotal() {
        double total = 0.0;
        for (Producto p : carritoObservable) {
            total += p.getPrecio();
        }
        lblTotal.setText(String.format("Total: $%.2f", total));
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}