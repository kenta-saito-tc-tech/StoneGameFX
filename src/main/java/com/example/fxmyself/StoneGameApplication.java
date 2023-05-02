package com.example.fxmyself;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class StoneGameApplication extends Application {

    public static void main(String[] args) throws IOException {
        // FileOutputStreamを作成する
        FileOutputStream fos = new FileOutputStream("sampleSG.ser");
        FileOutputStream fos2 = new FileOutputStream("sampleSP.ser");
        // ObjectOutputStreamを作成する
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        ObjectOutputStream oos2 = new ObjectOutputStream(fos2);

        ObjectSerializer.setOos(oos);
        ObjectSerializer.setOos2(oos2);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(StoneGameApplication.class.getResource("GameStart-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("StoneGame");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
