package Teatro_projeto_teatro_parte1.Controller.Botoes;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BotoesPainel {

    public static void setupButtons(Stage stage, ImageView btnFechar, ImageView btnMinimizar) {
        btnFechar.setOnMouseClicked(mouseEvent -> stage.close());
        btnMinimizar.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
    }
}
