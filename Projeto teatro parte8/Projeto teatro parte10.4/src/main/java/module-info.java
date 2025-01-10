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
    requires javafx.media;

    opens Teatro_projeto_teatro_parte1 to javafx.fxml;
    exports Teatro_projeto_teatro_parte1.Entities.Controller;
    opens Teatro_projeto_teatro_parte1.Entities.Controller to javafx.fxml;
    exports Teatro_projeto_teatro_parte1.Entities.Interface;
    opens Teatro_projeto_teatro_parte1.Entities.Interface to javafx.fxml;
    exports Teatro_projeto_teatro_parte1.Aplication;
    opens Teatro_projeto_teatro_parte1.Aplication to javafx.fxml;
}