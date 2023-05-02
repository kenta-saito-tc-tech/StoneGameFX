package com.example.fxmyself;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

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
    private Button backToSettingButton;
    @FXML
    private Button gameStartButton;

    @FXML
    public void gameSettingShow(){

    }

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
        // ボタンがクリックされたときに実行される処理
        // ...
    }

    /**
     * 設定に戻るボタンが押されたときの処理
     * @param event
     */
    @FXML
    private void onButtonClickBack(ActionEvent event){
        // ボタンがクリックされたときに実行される処理

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
        StoneInitialShow.setText(deserializedSG.getStoneInitial());
        stoneStealShow.setText(String.valueOf(deserializedSG.getHowManySteal()));
        playerCountsShow.setText(String.valueOf(deserializedSP.getHowManyPeople()));

        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll(deserializedSP.getName());
        playerNamesShow.setItems(list);
    }
}
