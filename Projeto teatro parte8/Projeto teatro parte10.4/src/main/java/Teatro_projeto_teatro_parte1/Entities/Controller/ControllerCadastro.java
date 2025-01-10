package Teatro_projeto_teatro_parte1.Entities.Controller;

import Teatro_projeto_teatro_parte1.Entities.Exceptions.ErroDeValidacao;
import Teatro_projeto_teatro_parte1.Entities.Interface.Interface;
import Teatro_projeto_teatro_parte1.Entities.Model.DAO.ModelUsuario;
import Teatro_projeto_teatro_parte1.Entities.Model.BO.SalvarDados;
import Teatro_projeto_teatro_parte1.Entities.Model.MO.UsuarioSessao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<ModelUsuario> listaUsuarios = new ArrayList<ModelUsuario>();


    private void validarCampo() throws Exception {
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
        try {
            this.btnCadastroBase(mouseEvent);
        } catch (ErroDeValidacao e) {
            mostrarAlerta("Erro", e.getMessage());
        } catch (Exception e) {
            mostrarAlerta("Erro Fatal", e.getMessage());
        }
    }

    public void btnCadastroBase(MouseEvent mouseEvent) throws Exception {
        validarCampo();

        ModelUsuario usuario = new ModelUsuario(
                tfNome.getText(),
                tfCPF.getText().trim(),
                tfDDD.getText(),
                tfEndereco.getText(),
                tfEndereco1.getText(),
                tfNumero.getText(),
                tfSenha.getText(),
                dtDatadenascimento.getValue().toString()
        );

        listaUsuarios.add(usuario);

        UsuarioSessao.setUsuario(usuario);

        SalvarDados.salvarDadosUsuarios(listaUsuarios);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignLogin1.fxml"));
        root = loader.load();
        ControllerLogin1 controllerLogin1 = loader.getController();
        stage = (Stage) btnCadastro.getScene().getWindow();
        controllerLogin1.setStage(stage);
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignCadastrar.css").toExternalForm());
        stage.setScene(scene);
        controllerLogin1.setupButtons();
        stage.show();
    }
    public void btnVoltar(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignLogin.fxml"));
        root = loader.load();
        Controller controllerLogin = loader.getController();
        stage = (Stage) btnVoltar.getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignLogin.css").toExternalForm()); // Certifique-se de usar o estilo correto
        stage.setScene(scene);
        controllerLogin.setStage(stage);
        controllerLogin.setupButtons();
        stage.show();
    }

    public void setupButtons() {
        Interface.setupButtons(stage, btnFechar, btnMinimizar);
    }
}
