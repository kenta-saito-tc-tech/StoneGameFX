package com.example.fxmyself;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;

public class GameSettingShowController implements Serializable {

    @FXML
    private Label stoneCountsShow;
    @FXML
    private Label StoneInitialShow;
    @FXML
    private Label stoneStealShow;
    @FXML
    private Label playerCountsShow;
    @FXML
    private ListView playerNamesShow;
    @FXML
    private Button gameStartButton;

    @FXML
    public void initialize() {
        //
    }


    /**
     * ゲーム開始ボタンが押された時の処理
     * @param event
     */
    @FXML
    private void onButtonClickStart(ActionEvent event) {
        Parent root = null;
        try {
            // FXMLファイルをロードして新しいSceneを作成する
            root = FXMLLoader.load(getClass().getResource("GameTurn-View.fxml"));
            Scene scene = new Scene(root);

            // Stageを取得し、新しいSceneをセットする
            Stage stage = (Stage) gameStartButton.getScene().getWindow(); // 現在のStageを取得
            stage.setScene(scene); // 新しいSceneをセットする
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 設定内容の取得
     * @param event
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @FXML
    private void onButtonShow(ActionEvent event) throws IOException, ClassNotFoundException {
        //オブジェクトを逆シリアル化して読み込み
        StoneGameClass deserializedSG = (StoneGameClass) ObjectSerializer.deserialize("sampleSG.ser");
        StonePlayerClass deserializedSP = (StonePlayerClass) ObjectSerializer.deserialize("sampleSP.ser");

        stoneCountsShow.setText(String.valueOf(deserializedSG.getHowManyStone()));

        StringBuilder sb = new StringBuilder(); // StringBuilderオブジェクトを作成
        String result = sb.toString(); // StringBuilderオブジェクトをString型に変換
        for(int i = 0; i < deserializedSG.getHowManyStone(); i++){
            sb.append(deserializedSG.getStoneInitial());
        }
        StoneInitialShow.setText(String.valueOf(sb));

        stoneStealShow.setText(String.valueOf(deserializedSG.getHowManySteal()));
        playerCountsShow.setText(String.valueOf(deserializedSP.getName().length));

        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll(deserializedSP.getName());
        playerNamesShow.setItems(list);
    }
}
