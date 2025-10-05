import Data.ProductoDao;
import Gui.MenuPrincipal;
import Model.Producto;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

import java.io.IOException;
import java.util.List;

import static javafx.application.Application.launch;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("src/Gui/MenuPrincipal.fxml"));
        primaryStage.setTitle("Menú Principal");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}