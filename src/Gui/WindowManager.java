package Gui;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class WindowManager {


    public static void openWindow(String fxmlFile, String title) {
        try {

            URL fxmlUrl = WindowManager.class.getResource("/" + fxmlFile);
            if (fxmlUrl == null) {
                System.err.println("No se pudo encontrar el archivo " + fxmlFile);
                return;
            }

            Parent root = FXMLLoader.load(fxmlUrl);


            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));



            stage.show();

        } catch (IOException e) {
            System.err.println("Error al abrir la ventana: " + fxmlFile);
            e.printStackTrace();
        }
    }
}
