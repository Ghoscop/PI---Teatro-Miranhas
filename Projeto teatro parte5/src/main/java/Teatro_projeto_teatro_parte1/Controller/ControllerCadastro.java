package Teatro_projeto_teatro_parte1.Controller;

import Teatro_projeto_teatro_parte1.Controller.Botoes.BotoesPainel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private Button btnVoltar;
    @FXML
    private ImageView btnFechar, btnMinimizar;
    @FXML
    private DatePicker dtDatadenascimento;

    @FXML
    private TextField tfCPF;

    @FXML
    private TextField tfDDD;

    @FXML
    private TextField tfEndereco;

    @FXML
    private TextField tfEndereco1;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfNumero;

    @FXML
    private PasswordField tfSenha;

    private void validarCampo() throws Exception{
        if (tfNome.getText().isEmpty() ||
                tfCPF.getText().isEmpty() ||
                tfDDD.getText().isEmpty() ||
                tfEndereco.getText().isEmpty() ||
                tfEndereco1.getText().isEmpty() ||
                tfNumero.getText().isEmpty() ||
                tfSenha.getText().isEmpty() ||
                dtDatadenascimento.getValue() == null) {
            throw new Exception("Todos os campos devem ser preenchidos!");
        }
    }

    private void mostrarAlerta(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    public void setStage(Stage stage) {
        this.stage = stage;
        setupButtons();
    }

    public void btnCadastro(MouseEvent mouseEvent) throws IOException {
        try{
            validarCampo();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignLogin.fxml"));
        root = loader.load();
        Controller controller = loader.getController();
        stage = (Stage) btnCadastro.getScene().getWindow();
        controller.setStage(stage);
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignCadastrar.css").toExternalForm());
        stage.setScene(scene);
        controller.setupButtons();

            stage.show();
        } catch (Exception e) {

            mostrarAlerta("Erro", e.getMessage());
        }
    }

    public void btnVoltar(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignLogin.fxml"));
        root = loader.load();  // Carregar o conteúdo da tela de login
        Controller controller = loader.getController();
        stage = (Stage) btnVoltar.getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignLogin.css").toExternalForm());
        stage.setScene(scene);
        controller.setStage(stage);
        controller.setupButtons();
        stage.show();
    }



    public void setupButtons() {
        BotoesPainel.setupButtons(stage, btnFechar, btnMinimizar);
    }
}
