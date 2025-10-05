module Sistema_de_Gestion_de_Inventario {
    // Necesitas los 3 para las clases básicas y FXML
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics; // <-- ¡Este es muy importante para Stage, Scene y Parent!

    // Abres tus paquetes para que JavaFX pueda acceder a ellos
    opens Gui to javafx.fxml;
    opens Model to javafx.base;
}