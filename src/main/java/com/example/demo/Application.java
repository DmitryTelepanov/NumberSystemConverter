package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.nio.file.Path;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 630);
        stage.setResizable(false);
        stage.setTitle("Конвертер");
        stage.setScene(scene);
        stage.getIcons().add(new Image(Path.of("src/main/Source/Icon.png").toAbsolutePath().toString()));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}