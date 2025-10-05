package Gui;

import Logic.GestorInventario;
import Model.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProductoFormController {

    @FXML private Label lblTitulo;
    @FXML private TextField txtId, txtNombre, txtStock, txtPrecio, txtArea, txtDescripcion;

    private GestorInventario gestorInventario;
    private Producto productoEditable;
    private boolean modoEditar = false;
    private InventarioController inventarioController;
    public void initData(Producto producto, GestorInventario gestor, InventarioController invController) {
        this.gestorInventario = gestor;
        this.inventarioController = invController;

        if (producto != null) {
            this.productoEditable = producto;
            this.modoEditar = true;
            lblTitulo.setText("Editar Producto");

            txtId.setText(producto.getId_producto());
            txtId.setEditable(false);
            txtNombre.setText(producto.getNombre());
            txtStock.setText(String.valueOf(producto.getStock()));
            txtPrecio.setText(String.valueOf(producto.getPrecio()));
            txtArea.setText(producto.getArea());
            txtDescripcion.setText(producto.getDescripcion_producto());
        }
    }

    @FXML
    void handleGuardar(ActionEvent event) {

        String id = txtId.getText();
        String nombre = txtNombre.getText();
        int stock = Integer.parseInt(txtStock.getText());
        double precio = Double.parseDouble(txtPrecio.getText());
        String area = txtArea.getText();
        String desc = txtDescripcion.getText();

        if (modoEditar) {

            productoEditable.setNombre(nombre);
            productoEditable.setStock(stock);
            productoEditable.setPrecio(precio);
            productoEditable.setArea(area);
            productoEditable.setDescripcion_producto(desc);
        } else {

            gestorInventario.agregarProducto(nombre, stock, desc, area, precio, id);
        }

        gestorInventario.guardar();
        inventarioController.cargarDatosTabla();
        cerrarVentana();
    }

    @FXML
    void handleCancelar(ActionEvent event) {
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) lblTitulo.getScene().getWindow();
        stage.close();
    }
}