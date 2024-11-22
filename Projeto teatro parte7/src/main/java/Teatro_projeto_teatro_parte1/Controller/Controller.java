package Teatro_projeto_teatro_parte1.Controller;

import Teatro_projeto_teatro_parte1.Controller.Botoes.BotoesPainel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField tfEmail;

    public void setStage(Stage stage) {
        this.stage = stage;
        setupButtons();
    }

    private void validarCampo() throws Exception{
        if (tfEmail.getText().isEmpty()) {
            throw new Exception("CPF deve ser preenchido!");
        }
    }

    private void mostrarAlerta(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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

    public void btnEntrar() throws IOException {
        try{
            validarCampo();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignMenuInicial.fxml"));
        root = loader.load();
        ControllerMenuInicial controllerMenuInicial = loader.getController();
        stage = (Stage) btnEntrar.getScene().getWindow();
        controllerMenuInicial.setStage(stage);
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignLogin.css").toExternalForm());
        stage.setScene(scene);
        controllerMenuInicial.setupButtons();
        stage.show();
        } catch (Exception e) {

            mostrarAlerta("Erro", e.getMessage());
        }
    }

    public void setupButtons() {
        BotoesPainel.setupButtons(stage, btnFechar, btnMinimizar);
    }
}
