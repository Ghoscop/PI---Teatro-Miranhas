package Teatro_projeto_teatro_parte1.Aplication;

import Teatro_projeto_teatro_parte1.Entities.Interface.Interface;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        String path = getClass().getResource("/Songs/Music.mp3").toExternalForm();

        MediaPlayer mediaPlayer = new MediaPlayer(new Media(path));
        mediaPlayer.setVolume(1.0);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        
        Interface interfaceApp = new Interface();
        interfaceApp.start(primaryStage, mediaPlayer);
    }
}
