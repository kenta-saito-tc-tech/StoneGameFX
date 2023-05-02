package com.example.fxmyself;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class GameStartController {
    @FXML
    private Button gameStartBtn;

    @FXML
    public void initialize(){
    }

    /**
     * ゲームスタートボタンクリック時
     * @param event
     */
    @FXML
    public void gameStartBtn(ActionEvent event){
        //進むボタンクリック時処理
        Parent root = null;
        try {
            // FXMLファイルをロードして新しいSceneを作成する
            root = FXMLLoader.load(getClass().getResource("GameSetting-View.fxml"));
            Scene scene = new Scene(root);

            // Stageを取得し、新しいSceneをセットする
            Stage stage = (Stage) gameStartBtn.getScene().getWindow(); // 現在のStageを取得
            stage.setScene(scene); // 新しいSceneをセットする
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
