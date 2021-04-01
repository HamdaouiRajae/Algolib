package com.myhamdaoui.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("/com/myhamdaoui/Views/app.fxml"));
        primaryStage.setTitle("Algorithmes de Tri");

        Scene scene = new Scene(root);
        scene.getStylesheets().addAll(getClass().getResource("/com/myhamdaoui/Views/app.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/myhamdaoui/Images/sort.png")));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
