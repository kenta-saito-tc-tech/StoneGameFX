package com.example.fxmyself;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StoneGameApplication extends Application {

    public static void main(String[] args) throws IOException {
        StoneGameClass sg = new StoneGameClass();
        StonePlayerClass sp = new StonePlayerClass();
        //インスタンスオブジェクトをシリアライズ化
        ObjectSerializer.serialize(sg, "sampleSG.ser");
        ObjectSerializer.serialize(sp, "sampleSP.ser");

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(StoneGameApplication.class.getResource("GameSetting-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 275);
        primaryStage.setTitle("StoneGame");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
