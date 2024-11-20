module heitor.larysson.matheus.natan.projeto_teatro_parte1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens Teatro_projeto_teatro_parte1 to javafx.fxml;
    exports Teatro_projeto_teatro_parte1;
    exports Teatro_projeto_teatro_parte1.Controller;
    opens Teatro_projeto_teatro_parte1.Controller to javafx.fxml;
    exports Teatro_projeto_teatro_parte1.Interface;
    opens Teatro_projeto_teatro_parte1.Interface to javafx.fxml;
}