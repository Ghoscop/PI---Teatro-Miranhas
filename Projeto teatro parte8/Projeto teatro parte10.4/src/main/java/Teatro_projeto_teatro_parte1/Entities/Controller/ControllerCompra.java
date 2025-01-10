package Teatro_projeto_teatro_parte1.Entities.Controller;

import Teatro_projeto_teatro_parte1.Entities.Interface.Interface;
import Teatro_projeto_teatro_parte1.Entities.Model.BO.SalvarDados;
import Teatro_projeto_teatro_parte1.Entities.Model.BO.SalvarPeca;
import Teatro_projeto_teatro_parte1.Entities.Model.DAO.ModelUsuario;
import Teatro_projeto_teatro_parte1.Entities.Model.DAO.ModelUsuario2;
import Teatro_projeto_teatro_parte1.Entities.Model.MO.GerenciadorAssentos;
import Teatro_projeto_teatro_parte1.Entities.Model.MO.UsuarioSessao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerCompra {

    private Scene scene;
    private Parent root;
    private Stage stage;

    private ModelUsuario usuario;

    @FXML
    private Button btnVoltar, btnProsseguir;

    @FXML
    private ImageView btnFechar, btnMinimizar;

    @FXML
    private RadioButton A1, A2, A3, A4, A5, A6, A7, A8, A9, A10,
            A11, A12, A13, A14, A15, A16, A17, A18, A19, A20,
            A21, A22, A23, A24, A25;

    @FXML
    private RadioButton B1, B2, B3, B4, B5, B6, B7, B8, B9, B10,
            B11, B12, B13, B14, B15, B16, B17, B18, B19, B20,
            B21, B22, B23, B24, B25, B26, B27, B28, B29, B30,
            B31, B32, B33, B34, B35, B36, B37, B38, B39, B40,
            B41, B42, B43, B44, B45, B46, B47, B48, B49, B50;

    @FXML
    private RadioButton F1, F2, F3, F4, F5, F6;

    @FXML
    private RadioButton C1, C2, C3, C4, C5;

    @FXML
    private RadioButton radio1, radio2, radio3, radio4, radio5, radio6, radio7, radio8, radio9, radio10,
            radio11, radio12, radio13, radio14, radio15, radio16, radio17, radio18, radio19, radio20,
            radio21, radio22, radio23, radio24, radio25, radio26, radio27, radio28, radio29, radio30,
            radio31, radio32, radio33, radio34, radio35, radio36, radio37, radio38, radio39, radio40,
            radio41, radio42, radio43, radio44, radio45, radio46, radio47, radio48, radio49, radio50,
            radio51, radio52, radio53, radio54, radio55, radio56, radio57, radio58, radio59, radio60,
            radio61, radio62, radio63, radio64, radio65, radio66, radio67, radio68, radio69, radio70,
            radio71, radio72, radio73, radio74, radio75, radio76, radio77, radio78, radio79, radio80,
            radio81, radio82, radio83, radio84, radio85, radio86, radio87, radio88, radio89, radio90,
            radio91, radio92, radio93, radio94, radio95, radio96, radio97, radio98, radio99, radio100;

    private List<RadioButton> plateiaA;
    private List<RadioButton> plateiaB;
    private List<RadioButton> frisa;
    private List<RadioButton> camarote;
    private List<RadioButton> balcaoNobre;
    private GerenciadorAssentos gerenciadorAssentos;

    @FXML
    public void initialize() {
        plateiaA = List.of(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10,
                A11, A12, A13, A14, A15, A16, A17, A18, A19, A20,
                A21, A22, A23, A24, A25);

        balcaoNobre = List.of(B1, B2, B3, B4, B5, B6, B7, B8, B9, B10,
                B11, B12, B13, B14, B15, B16, B17, B18, B19, B20,
                B21, B22, B23, B24, B25, B26, B27, B28, B29, B30,
                B31, B32, B33, B34, B35, B36, B37, B38, B39, B40,
                B41, B42, B43, B44, B45, B46, B47, B48, B49, B50);

        frisa = List.of(F1, F2, F3, F4, F5, F6);
        camarote = List.of(C1, C2, C3, C4, C5);

        plateiaB = List.of(radio1, radio2, radio3, radio4, radio5, radio6, radio7, radio8, radio9, radio10,
                radio11, radio12, radio13, radio14, radio15, radio16, radio17, radio18, radio19, radio20,
                radio21, radio22, radio23, radio24, radio25, radio26, radio27, radio28, radio29, radio30,
                radio31, radio32, radio33, radio34, radio35, radio36, radio37, radio38, radio39, radio40,
                radio41, radio42, radio43, radio44, radio45, radio46, radio47, radio48, radio49, radio50,
                radio51, radio52, radio53, radio54, radio55, radio56, radio57, radio58, radio59, radio60,
                radio61, radio62, radio63, radio64, radio65, radio66, radio67, radio68, radio69, radio70,
                radio71, radio72, radio73, radio74, radio75, radio76, radio77, radio78, radio79, radio80,
                radio81, radio82, radio83, radio84, radio85, radio86, radio87, radio88, radio89, radio90,
                radio91, radio92, radio93, radio94, radio95, radio96, radio97, radio98, radio99, radio100);

        gerenciadorAssentos = new GerenciadorAssentos(plateiaA, plateiaB, frisa, camarote, balcaoNobre);
        carregarAssentosSelecionados();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        setupButtons();
    }

    public void btnVoltar(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignMenuInicial.fxml"));
        root = loader.load();
        ControllerMenuInicial controllerMenuInicial = loader.getController();
        stage = (Stage) btnVoltar.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        controllerMenuInicial.setStage(stage);
        stage.show();
    }
    @FXML
    public void btnProsseguir() throws IOException {
        ModelUsuario usuario = UsuarioSessao.getUsuario();
        ModelUsuario2 usuario2 = UsuarioSessao.getUsuario2();

        List<RadioButton> selectedSeats = gerenciadorAssentos.obterAssentos().stream()
                .filter(RadioButton::isSelected)
                .collect(Collectors.toList());

        if (selectedSeats.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Aviso", "Por favor, selecione pelo menos um assento.");
            return;
        }

        ArrayList<String> seatId = new ArrayList<>();
        for (RadioButton seat : selectedSeats) {
            seatId.add(seat.getId());
        }

        String pecaEscolhida = SalvarPeca.getPecaEscolhida();
        switch (pecaEscolhida) {
            case "Peça A" -> SalvarDados.salvarAssentosA(seatId);
            case "Peça B" -> SalvarDados.salvarAssentosB(seatId);
            case "Peça C" -> SalvarDados.salvarAssentosC(seatId);
            default -> mostrarAlerta(Alert.AlertType.ERROR, "Erro", "Peça escolhida inválida.");
        }

        int totalPrice = gerenciadorAssentos.calcularPrecoTotal(selectedSeats);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignIngresso.fxml"));
        Parent root = loader.load();

        ControllerIngresso controllerIngresso = loader.getController();

        controllerIngresso.setUsuario(usuario);
        controllerIngresso.setUsuario2(usuario2);
        controllerIngresso.exibirDadosCompletos(usuario, SalvarPeca.getPecaEscolhida(), seatId, totalPrice);
        controllerIngresso.exibirDadosCompletos2(usuario2,SalvarPeca.getPecaEscolhida(), seatId, totalPrice);

        stage = (Stage) btnProsseguir.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private List<RadioButton> getAllSeats() {
        List<RadioButton> allSeats = new ArrayList<>();
        allSeats.addAll(plateiaA);
        allSeats.addAll(plateiaB);
        allSeats.addAll(frisa);
        allSeats.addAll(camarote);
        allSeats.addAll(balcaoNobre);
        return allSeats;
    }

    private void desabilitarAssentos(List<String> assentosSelecionados) {
        List<RadioButton> todosAssentos = getAllSeats();

        for (String id : assentosSelecionados) {
            RadioButton buttonToDisable = todosAssentos.stream()
                    .filter(button -> button.getId().equals(id))
                    .findFirst()
                    .orElse(null);

            if (buttonToDisable != null) {
                buttonToDisable.setDisable(true);
            }
        }
    }
    private void carregarAssentosSelecionados() {
        String pecaEscolhida = SalvarPeca.getPecaEscolhida();

        List<String> assentosSelecionados = switch (pecaEscolhida) {
            case "Peça A" -> SalvarDados.carregarAssentosA();
            case "Peça B" -> SalvarDados.carregarAssentosB();
            case "Peça C" -> SalvarDados.carregarAssentosC();
            default -> new ArrayList<>();
        };

        desabilitarAssentos(assentosSelecionados);
    }
    public void setupButtons() {
        Interface.setupButtons(stage, btnFechar, btnMinimizar);
    }

    private void mostrarAlerta(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
