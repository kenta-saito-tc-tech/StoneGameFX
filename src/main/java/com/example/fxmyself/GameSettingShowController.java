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

import java.net.URL;
import java.util.ResourceBundle;

public class GameSettingShowController{

//    private StoneGameClass instanceInformationSG;

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
        stoneCountsShow.setText(String.valueOf(StoneGameClass.getInstance().getHowManyStone()));
        StoneInitialShow.setText(StoneGameClass.getInstance().getStoneInitial());
        stoneStealShow.setText(String.valueOf(StoneGameClass.getInstance().getHowManySteal()));
        playerCountsShow.setText(String.valueOf(StonePlayerClass.getInstance().getHowManyPeople()));

//        ObservableList<String> list = FXCollections.observableArrayList();
//        list.addAll(StonePlayerClass.getInstance().getName());
//        playerNamesShow.setItems(list);
    }
    //todo textにシリアライズしてインスタンスのオブジェクトを使いまわす


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
    private void onButtonClickBack(ActionEvent event) {
        // ボタンがクリックされたときに実行される処理
        // ...
    }

//    //インスタンスの格納用
//    public void setInstanceInformation(StoneGameClass instanceInformation) {
//        this.instanceInformationSG = instanceInformation;
//    }
//
//    public StoneGameClass getInstanceInformation() {
//        return instanceInformationSG;
//    }
}
