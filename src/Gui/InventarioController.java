package Gui;

import Logic.GestorInventario;
import Model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class InventarioController {

    @FXML private TableView<Producto> tablaProductos;
    @FXML private TableColumn<Producto, String> colId;
    @FXML private TableColumn<Producto, String> colNombre;
    @FXML private TableColumn<Producto, Integer> colStock;
    @FXML private TableColumn<Producto, Double> colPrecio;
    @FXML private TableColumn<Producto, String> colArea;
    @FXML private TableColumn<Producto, String> colDescripcion;

    private GestorInventario gestorInventario;

    @FXML
    public void initialize() {
        try {
            gestorInventario = new GestorInventario();
        } catch (IOException | ClassNotFoundException e) {
            mostrarAlertaError("Error de Carga", "No se pudo cargar el inventario: " + e.getMessage());
            return;
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colArea.setCellValueFactory(new PropertyValueFactory<>("area"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion_producto"));

        cargarDatosTabla();
    }

    public void cargarDatosTabla() {
        ObservableList<Producto> productos = FXCollections.observableArrayList(gestorInventario.verInventario());
        tablaProductos.setItems(productos);
    }

    @FXML
    void handleAgregar(ActionEvent event) {
        abrirFormularioProducto(null);
    }

    @FXML
    void handleEditar(ActionEvent event) {
        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlertaInfo("Sin selección", "Por favor, selecciona un producto para editar.");
            return;
        }
        abrirFormularioProducto(seleccionado);
    }

    private void abrirFormularioProducto(Producto producto) {
        try {
            // Reemplaza la línea que tienes por esta
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/ProductoForm.fxml"));
            Parent root = loader.load();

            ProductoFormController controller = loader.getController();
            controller.initData(producto, gestorInventario, this);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle(producto == null ? "Agregar Producto" : "Editar Producto");
            stage.setScene(new Scene(root));
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlertaError("Error", "No se pudo abrir el formulario.");
        }
    }

    @FXML
    void handleEliminar(ActionEvent event) {
        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlertaInfo("Sin selección", "Por favor, selecciona un producto para eliminar.");
            return;
        }

        Alert alertaConfirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        alertaConfirmacion.setTitle("Confirmar Eliminación");
        alertaConfirmacion.setHeaderText("¿Estás seguro?");
        alertaConfirmacion.setContentText(seleccionado.getNombre());
        Optional<ButtonType> resultado = alertaConfirmacion.showAndWait();

        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            gestorInventario.eliminarProducto(seleccionado.getId_producto());
            gestorInventario.guardar();
            cargarDatosTabla();
        }
    }

    private void mostrarAlertaError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarAlertaInfo(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}