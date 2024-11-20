package Teatro_projeto_teatro_parte1.Controller;

import Teatro_projeto_teatro_parte1.Controller.Botoes.BotoesPainel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.io.IOException;


public class Controller {

    private Scene scene;
    private Parent root;
    private Stage stage;

    //Botões
    @FXML
    private Button btnCadastrar, btnEntrar;
    @FXML
    private ImageView btnFechar, btnMinimizar;

    public void setStage(Stage stage) {
        this.stage = stage;
        setupButtons();
    }

    public void btnCadastrar(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignCadastrar.fxml"));
        root = loader.load();

        ControllerCadastro controllerCadastro = loader.getController();


        stage = (Stage) btnCadastrar.getScene().getWindow();
        controllerCadastro.setStage(stage);

        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignLogin.css").toExternalForm());
        stage.setScene(scene);

        controllerCadastro.setupButtons();

        stage.show();
    }
    public void setupButtons() {
        BotoesPainel.setupButtons(stage, btnFechar, btnMinimizar);
    }
}
