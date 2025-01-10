package Teatro_projeto_teatro_parte1.Entities.Controller;

import Teatro_projeto_teatro_parte1.Entities.Interface.Interface;
import Teatro_projeto_teatro_parte1.Entities.Model.DAO.ModelUsuario2;
import Teatro_projeto_teatro_parte1.Entities.Exceptions.ErroDeValidacao;
import Teatro_projeto_teatro_parte1.Entities.Model.BO.SalvarDados2;
import Teatro_projeto_teatro_parte1.Entities.Model.MO.UsuarioSessao;
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
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Scene scene;
    private Parent root;
    private Stage stage;

    private List<String> listaDeCpfsValidos = new ArrayList<>();
    public static List<ModelUsuario2> listaUsuarios = new ArrayList<>();

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

    private void validarCampo() throws Exception {
        String cpf = tfEmail.getText();

        if (cpf.isEmpty()) {
            throw new Exception("CPF deve ser preenchido!");
        }

        try {
            ModelUsuario2 usuario2 = new ModelUsuario2("Nome", cpf, "ddd", "endereco", "complemento", "numero", "senha", "dataDeNascimento");
            listaDeCpfsValidos.add(cpf);
            listaUsuarios.add(usuario2);

            UsuarioSessao.setUsuario2(usuario2);

            SalvarDados2.salvarDadosUsuarios(listaUsuarios);

        } catch (ErroDeValidacao e) {
            throw new Exception("CPF inválido! " + e.getMessage());
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
        try {
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
        Interface.setupButtons(stage, btnFechar, btnMinimizar);
    }
}
