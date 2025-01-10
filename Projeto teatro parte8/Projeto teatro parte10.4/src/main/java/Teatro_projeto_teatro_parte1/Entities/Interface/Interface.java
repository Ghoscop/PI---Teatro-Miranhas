package Teatro_projeto_teatro_parte1.Entities.Interface;

import Teatro_projeto_teatro_parte1.Entities.Controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Interface extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Carregando o arquivo FXML
        FXMLLoader fxmlLoader = new FXMLLoader(Interface.class.getResource("/Teatro_projeto_teatro_parte1/DesignLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Configurações da janela
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setTitle("Teatro Miranhas");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/Imagens/IconImage.png")));

        // Obtendo o controlador e passando a Stage
        Controller controller = fxmlLoader.getController();
        controller.setStage(stage);

        stage.show();
    }

    public void start(Stage stage, MediaPlayer mediaPlayer) throws IOException {
        // Carregar a cena de login e passar o mediaPlayer
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

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

    // Método para configuração dos botões
    public static void setupButtons(Stage stage, ImageView btnFechar, ImageView btnMinimizar) {
        btnFechar.setOnMouseClicked(mouseEvent -> stage.close());
        btnMinimizar.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
    }

    public static void main(String... args) {
        launch(args);
    }
}
