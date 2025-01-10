package Teatro_projeto_teatro_parte1.Entities.Controller;

import Teatro_projeto_teatro_parte1.Entities.Interface.Interface;
import Teatro_projeto_teatro_parte1.Entities.Model.DAO.ModelUsuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerLogin1 {

    private Scene scene;
    private Parent root;
    private Stage stage;

    // Botões
    @FXML
    private Button btnEntrar;
    @FXML
    private ImageView btnFechar, btnMinimizar;
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField tfSenha;

    public void setStage(Stage stage) {
        this.stage = stage;
        setupButtons();
    }

    private void validarCampo() throws Exception {
        if (tfEmail.getText().isEmpty() || tfSenha.getText().isEmpty()) {
            throw new Exception("CPF e senha devem ser preenchidos!");
        }
    }

    private void mostrarAlerta(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void btnEntrar() throws IOException {
        try {
            validarCampo();
            String cpf = tfEmail.getText();
            String senha = tfSenha.getText();
            boolean loginValido = false;
            for (ModelUsuario usuario : ControllerCadastro.listaUsuarios) {
                if (usuario.getCpf().equals(cpf) && usuario.verificarSenha(senha)) {
                    loginValido = true;
                    break;
                }
            }

            if (loginValido) {
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
            } else {
                mostrarAlerta("Erro", "CPF ou senha incorretos!");
            }
        } catch (Exception e) {
            mostrarAlerta("Erro", e.getMessage());
        }
    }

    public void setupButtons() {
        Interface.setupButtons(stage, btnFechar, btnMinimizar);
    }
}
