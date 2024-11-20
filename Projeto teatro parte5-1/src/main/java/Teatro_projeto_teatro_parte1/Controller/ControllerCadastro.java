package Teatro_projeto_teatro_parte1.Controller;

import Teatro_projeto_teatro_parte1.Controller.Botoes.BotoesPainel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerCadastro {

    private Scene scene;
    private Parent root;
    private Stage stage;

    @FXML
    private Button btnCadastro;
    @FXML
    private ImageView btnFechar, btnMinimizar;

    public void btnCadastro(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignLogin.fxml"));
        stage = (Stage) btnCadastro.getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignCadastrar.css").toExternalForm());
        stage.setScene(scene);
        setupButtons();
        stage.show();
    }

    public void setupButtons() {
        BotoesPainel.setupButtons(stage, btnFechar, btnMinimizar);
    }
}
