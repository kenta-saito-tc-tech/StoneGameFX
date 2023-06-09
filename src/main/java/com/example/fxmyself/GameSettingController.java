package com.example.fxmyself;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class GameSettingController {
    private double value;
    private String str;


    //石の総数
    @FXML
    private ScrollBar stoneCounts;
    @FXML
    private Label stoneCountsShow;
    //石のイニシャル
    @FXML
    private ChoiceBox stoneInitial;
    //１度に取れる石の数
    @FXML
    private ScrollBar stealCounts;
    @FXML
    private Label stealCountsShow;
    //参加人数
    @FXML
    private ScrollBar playerCounts;
    @FXML
    private Label playerCountsShow;
    //PLAYER名
    @FXML
    private TextArea playerNames;
    //ボタン
    @FXML
    private Button goPageToShowAll;

    /**
     * ChoiceBoxの値の設定
     */
    @FXML
    public void initialize() {
        stoneCounts.valueProperty().addListener((observable, oldValue, newValue) -> {
            stoneCountsShow.setText(String.valueOf(initializeForScrollBar(stoneCounts) +1));
        });
        stealCounts.valueProperty().addListener((observable, oldValue, newValue) -> {
            stealCountsShow.setText(String.valueOf(initializeForScrollBar(stealCounts) +1));
        });

        playerCounts.valueProperty().addListener((observable, oldValue, newValue) -> {
            playerCountsShow.setText(String.valueOf(initializeForScrollBar(playerCounts) +1));
        });

        ObservableList<String> list = FXCollections.observableArrayList("*", "%", "&", "$","￥");
        stoneInitial.setItems(list);
    }

    /**
     * ChoiceBoxの値の取得
     * @return String
     */
    @FXML
    public String initializeForChoiceBox() {
        //ChoiceBoxの値の取得
        stoneInitial.valueProperty().addListener((observable, oldValue, newValue) -> {
            this.str = newValue.toString();
        });
        return this.str;
    }

    /**
     * ScrollBarのIDを取得してその値を表示する例
     * @param scl Scrollbar
     * @return String
     */
    @FXML
    public int initializeForScrollBar(ScrollBar scl) {
        scl.valueProperty().addListener((observable, oldValue, newValue) -> {
            this.value = newValue.doubleValue();
        });
        return (int) this.value;
    }

    /**
     * 進むが押された時の処理
     * @param event
     */
    @FXML
    private void onButtonClickToShow(ActionEvent event) {
        //進むボタンクリック時処理
            Parent root = null;
            try {
                // FXMLファイルをロードして新しいSceneを作成する
                root = FXMLLoader.load(getClass().getResource("GameSettingShow-View.fxml"));
                Scene scene = new Scene(root);

                StoneGameClass sg = new StoneGameClass();
                StonePlayerClass sp = new StonePlayerClass();

                sg.setHowManyStone(Integer.parseInt(stoneCountsShow.getText()));
                sg.setHowManySteal(Integer.parseInt(stealCountsShow.getText()));
                sg.setStoneInitial(stoneInitial.getValue().toString());
                sp.setHowManyPeople(Integer.parseInt(playerCountsShow.getText()));
                sp.setName(playerNames.getText().split(","));

                ObjectSerializer.getOos().writeObject(sg);
                ObjectSerializer.getOos().close();
                ObjectSerializer.getOos2().writeObject(sp);
                ObjectSerializer.getOos2().close();

                // Stageを取得し、新しいSceneをセットする
                Stage stage = (Stage) goPageToShowAll.getScene().getWindow(); // 現在のStageを取得
                stage.setScene(scene); // 新しいSceneをセットする
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
        }
    }

}
