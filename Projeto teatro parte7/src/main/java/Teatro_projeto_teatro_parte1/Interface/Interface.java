package Teatro_projeto_teatro_parte1.Interface;

import Teatro_projeto_teatro_parte1.Controller.Controller;
import Teatro_projeto_teatro_parte1.Controller.ControllerCadastro;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class Interface extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Interface.class.getResource("/Teatro_projeto_teatro_parte1/DesignLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Configura a cena
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setTitle("Teatro Miranhas");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/Imagens/IconImage.png")));

        Controller controller = fxmlLoader.getController();

        controller.setStage(stage);

        stage.show();
    }

    public static void main(String... args) {
        launch(args);
    }
}
