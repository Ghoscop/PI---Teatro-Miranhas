package Teatro_projeto_teatro_parte1.Controller;

import Teatro_projeto_teatro_parte1.Controller.Botoes.BotoesPainel;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControllerCompra {
    private Scene scene;
    private Parent root;
    private Stage stage;
    @FXML
    private ChoiceBox cbHorario;
    @FXML
    private Button btnProsseguir, btnVoltar;
    @FXML
    private ImageView btnFechar, btnMinimizar;

    public void setStage(Stage stage) {
        this.stage = stage;
        setupButtons();
    }

    public void setupButtons() {
        BotoesPainel.setupButtons(stage, btnFechar, btnMinimizar);
    }
}

