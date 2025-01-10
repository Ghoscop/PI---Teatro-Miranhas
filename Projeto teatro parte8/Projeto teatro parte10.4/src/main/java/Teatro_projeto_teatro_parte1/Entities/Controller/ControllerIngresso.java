package Teatro_projeto_teatro_parte1.Entities.Controller;

import Teatro_projeto_teatro_parte1.Entities.Interface.Interface;
import Teatro_projeto_teatro_parte1.Entities.Model.BO.SalvarPeca;
import Teatro_projeto_teatro_parte1.Entities.Model.DAO.ModelUsuario;
import Teatro_projeto_teatro_parte1.Entities.Model.DAO.ModelUsuario2;
import Teatro_projeto_teatro_parte1.Entities.Model.MO.GerenciadorAssentos;
import Teatro_projeto_teatro_parte1.Entities.Model.MO.UsuarioSessao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControllerIngresso {

    private Stage stage;
    private ModelUsuario usuario;
    private ModelUsuario2 usuario2;
    private SalvarPeca salvarPeca;

    @FXML
    private Text lbNome, lbCPF, lbEndereco, lbTelefone, lbDDD, lbAssentos, lbValortotal, lbPeca, lbHorari;

    @FXML
    private Button btnSair, btnComprarNovamente;

    @FXML
    private ImageView btnFechar, btnMinimizar;

    public void setStage(Stage stage) {
        this.stage = stage;
        setupButtons();
    }

    public void exibirDadosCompletos(ModelUsuario usuario, String pecaEscolhida, ArrayList<String> seats, int totalPrice) {
        usuario = UsuarioSessao.getUsuario();
        if (usuario == null) {
            System.out.println("Erro: Usuário não encontrado na sessão.");
            return;
        }

        lbNome.setText(usuario.getNome());
        lbCPF.setText(usuario.getCpf());
        lbDDD.setText(usuario.getDdd());
        lbTelefone.setText(usuario.getNumero());
        lbEndereco.setText(usuario.getEndereco());
        lbPeca.setText(pecaEscolhida);
        lbAssentos.setText(String.join(", ", seats));
        lbValortotal.setText(String.format("%.2f", (double) totalPrice));
        lbHorari.setText(SalvarPeca.getHorarioEscolhido());
    }

    public void exibirDadosCompletos2(ModelUsuario2 usuario2, String pecaEscolhida, ArrayList<String> seats, int totalPrice) {
        usuario2 = UsuarioSessao.getUsuario2();
        if (usuario2 == null) {
            System.out.println("Erro: Usuário não encontrado na sessão.");
            return;
        }

        lbCPF.setText(usuario2.getCpf());
        lbPeca.setText(pecaEscolhida);
        lbAssentos.setText(String.join(", ", seats));
        lbValortotal.setText(String.format("%.2f", (double) totalPrice));
        lbHorari.setText(SalvarPeca.getHorarioEscolhido());
    }

    @FXML
    public void btnComprarNovamente() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignMenuInicial.fxml"));
        Stage newStage = (Stage) btnComprarNovamente.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        ControllerMenuInicial controllerMenuInicial = loader.getController();
        controllerMenuInicial.setStage(newStage);
        controllerMenuInicial.setupButtons();
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    public void handleBtnSair() throws IOException {
        List<RadioButton> plateiaA = new ArrayList<>();
        List<RadioButton> plateiaB = new ArrayList<>();
        List<RadioButton> frisa = new ArrayList<>();
        List<RadioButton> camarote = new ArrayList<>();
        List<RadioButton> balcaoNobre = new ArrayList<>();
        GerenciadorAssentos gerenciadorAssentos = new GerenciadorAssentos(plateiaA, plateiaB, frisa, camarote, balcaoNobre);
        String resultado = gerenciadorAssentos.obterPecaMaisEMenosOcupada();
        System.out.println(resultado);

        String resultadoLucratividade = gerenciadorAssentos.calcularLucratividadePorPeca();
        System.out.println(resultadoLucratividade);

        double mediaLucro = gerenciadorAssentos.calcularMediaLucroPorPeca();
        System.out.println("Média de lucratividade das peças: " + String.format("%.2f", mediaLucro));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teatro_projeto_teatro_parte1/DesignLogin.fxml"));
        Stage newStage = (Stage) btnSair.getScene().getWindow();
        Scene scene = new Scene(loader.load());

        Controller controllerLogin = loader.getController();

        controllerLogin.setStage(newStage);
        controllerLogin.setupButtons();

        newStage.setScene(scene);
        newStage.show();
    }



    public void setupButtons() {
        Interface.setupButtons(stage, btnFechar, btnMinimizar);
    }

    public void setUsuario(ModelUsuario usuario) {
        this.usuario = usuario;
    }

    public void setUsuario2(ModelUsuario2 usuario2){
        this.usuario2 = usuario2;
    }
    public void receberPeca(SalvarPeca salvarPeca) {
        this.salvarPeca = salvarPeca;
    }
}
