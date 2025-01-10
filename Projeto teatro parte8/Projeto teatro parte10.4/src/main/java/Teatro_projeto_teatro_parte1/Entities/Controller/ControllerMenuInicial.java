package Teatro_projeto_teatro_parte1.Entities.Controller;

import Teatro_projeto_teatro_parte1.Entities.Interface.Interface;
import Teatro_projeto_teatro_parte1.Entities.Model.BO.SalvarPeca;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMenuInicial {

    private Scene scene;
    private Parent root;
    private Stage stage;

    @FXML
    private ImageView btnFechar, btnMinimizar;
    @FXML
    private Button btnA, btnB, btnC;
    @FXML
    private Button btnVoltar;
    @FXML
    private ChoiceBox<String> cbHorario;

    public void setStage(Stage stage) {
        this.stage = stage;
        escolherPeca();
        setupButtons();
    }

    public void escolherPeca(){
        cbHorario.getItems().add("Manha");
        cbHorario.getItems().add("Tarde");
        cbHorario.getItems().add("Noite");
    }

    // Método para voltar ao login
    public void btnVoltar(MouseEvent mouseEvent) throws IOException {
        try {
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
        } catch (IOException e) {
            exibirErro("Erro ao carregar a tela de login.", e);
        }
    }

    public void btnA() throws IOException {
        try {
            if (cbHorario.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, escolha um horário.");
                alert.showAndWait();
                return;
            }

            String horarioEscolhido = cbHorario.getValue();
            SalvarPeca salvarPeca = new SalvarPeca("Peça A", horarioEscolhido);
            redirecionarCompraA(salvarPeca);

        } catch (Exception e) {
            exibirErro(e.getMessage(), e);
        }
    }

    public void btnB() throws IOException {
        try {
            if (cbHorario.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, escolha um horário.");
                alert.showAndWait();
                return;
            }

            String horarioEscolhido = cbHorario.getValue();
            SalvarPeca salvarPeca = new SalvarPeca("Peça B", horarioEscolhido);
            redirecionarCompraB(salvarPeca);

        } catch (Exception e) {
            exibirErro(e.getMessage(), e);
        }
    }


    public void btnC() throws IOException {
        try {
            if (cbHorario.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, escolha um horário.");
                alert.showAndWait();
                return;
            }

            String horarioEscolhido = cbHorario.getValue();
            SalvarPeca salvarPeca = new SalvarPeca("Peça C", horarioEscolhido);
            redirecionarCompraC(salvarPeca);

        } catch (Exception e) {
            exibirErro(e.getMessage(), e);
        }
    }


    private void pecaEscolhida(SalvarPeca salvarPeca) {
        ControllerIngresso controllerIngresso = new ControllerIngresso();
        controllerIngresso.receberPeca(salvarPeca);
    }



    private void redirecionarCompraA(SalvarPeca salvarPeca) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignCompra.fxml"));
        Parent root = loader.load();
        ControllerCompra controllerCompra = loader.getController();
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignCompra.css").toExternalForm());
        stage.setScene(scene);
        controllerCompra.setStage(stage);
        controllerCompra.setupButtons();
        stage.show();
    }
    private void redirecionarCompraB(SalvarPeca salvarPeca) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignCompraB.fxml"));
        Parent root = loader.load();
        ControllerCompra controllerCompra = loader.getController();
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignCompra.css").toExternalForm());
        stage.setScene(scene);
        controllerCompra.setStage(stage);
        controllerCompra.setupButtons();
        stage.show();
    }
    private void redirecionarCompraC(SalvarPeca salvarPeca) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignCompraC.fxml"));
        Parent root = loader.load();
        ControllerCompra controllerCompra = loader.getController();
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignCompra.css").toExternalForm());
        stage.setScene(scene);
        controllerCompra.setStage(stage);
        controllerCompra.setupButtons();
        stage.show();
    }

    private void exibirErro(String mensagem, Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
        e.printStackTrace();
    }

    public void setupButtons() {
        Interface.setupButtons(stage, btnFechar, btnMinimizar);
    }
}
