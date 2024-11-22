package Teatro_projeto_teatro_parte1.Controller;

import Teatro_projeto_teatro_parte1.Controller.Botoes.BotoesPainel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.zip.InflaterOutputStream;


public class ControllerMenuInicial {
    private Scene scene;
    private Parent root;
    private Stage stage;
    @FXML
    private ImageView btnPecaA, btnPecaB, btnPecaC, btnFechar, btnMinimizar;

    @FXML
    private Button btnA;
    @FXML
    private Button btnVoltar;

    public void setStage(Stage stage) {
        this.stage = stage;
        setupButtons();
    }

    public void btnVoltar(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignLogin.fxml"));
        root = loader.load();
        Controller controller = loader.getController();
        stage = (Stage) btnVoltar.getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignLogin.css").toExternalForm());
        stage.setScene(scene);
        controller.setStage(stage);
        controller.setupButtons();
        stage.show();
    }

    public void btnA() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignCompra.fxml"));
        root = loader.load();
        Controller controller = loader.getController();
        stage = (Stage) btnVoltar.getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignCompra.css").toExternalForm());
        stage.setScene(scene);
        controller.setStage(stage);
        controller.setupButtons();
        stage.show();
    }


    public void setupButtons() {
        BotoesPainel.setupButtons(stage, btnFechar, btnMinimizar);
    }
}

