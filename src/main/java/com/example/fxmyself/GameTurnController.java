package com.example.fxmyself;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.stage.Stage;

import java.io.IOException;

public class GameTurnController {

    private double value;
    private int maxStealValue; //取れる最大数

    private int StoneLeftCounts; //残りの残数

    private int playerTurnNum = 0; //ターン数
    @FXML
    private Label playerTurn;
    @FXML
    private Label stoneCounts;
    @FXML
    private Label stoneInitial;
    @FXML
    private Label StealCounts;
    @FXML
    private ScrollBar scrollBar;
    @FXML
    private Button myTurnEnd;

    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        //オブジェクトを逆シリアル化して読み込み
        StoneGameClass deserializedSG = (StoneGameClass) ObjectSerializer.deserialize("sampleSG.ser");
        StonePlayerClass deserializedSP = (StonePlayerClass) ObjectSerializer.deserialize("sampleSP.ser");

        this.StoneLeftCounts = deserializedSG.getHowManyStone();
        setViewMethod();
        //スクロールバーの最大値設定
        scrollBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            StealCounts.setText(String.valueOf(initializeForScrollBar(scrollBar)));
        });
        this.maxStealValue = deserializedSG.getHowManySteal();
        scrollBar.setMax(this.maxStealValue +1);
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

    @FXML
    public void myTurnEndBtn(ActionEvent event) throws IOException, ClassNotFoundException {
        //オブジェクトを逆シリアル化して読み込み
        StoneGameClass deserializedSG = (StoneGameClass) ObjectSerializer.deserialize("sampleSG.ser");
        StonePlayerClass deserializedSP = (StonePlayerClass) ObjectSerializer.deserialize("sampleSP.ser");

        this.StoneLeftCounts -= Integer.parseInt(StealCounts.getText());
        if (this.StoneLeftCounts <= 0){

            Parent root = null;
            try {
                //Winner判定
                if(playerTurnNum == 0){
                    FinishGameController.winner = deserializedSP.getName()[deserializedSP.getName().length-2];
                    FinishGameController.looser = deserializedSP.getName()[deserializedSP.getName().length-1];
                }else if(playerTurnNum -1 == 0){
                    FinishGameController.winner = deserializedSP.getName()[deserializedSP.getName().length-1];
                    FinishGameController.looser = deserializedSP.getName()[playerTurnNum -1];
                }else {
                    FinishGameController.winner = deserializedSP.getName()[playerTurnNum-2];
                    FinishGameController.looser = deserializedSP.getName()[playerTurnNum -1];
                }
                // FXMLファイルをロードして新しいSceneを作成する
                root = FXMLLoader.load(getClass().getResource("FinishGame-View.fxml"));
                Scene scene = new Scene(root);

                // Stageを取得し、新しいSceneをセットする
                Stage stage = (Stage) myTurnEnd.getScene().getWindow(); // 現在のStageを取得
                stage.setScene(scene); // 新しいSceneをセットする
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        setViewMethod();
    }

    @FXML
    public void setViewMethod() throws IOException, ClassNotFoundException {
        //オブジェクトを逆シリアル化して読み込み
        StoneGameClass deserializedSG = (StoneGameClass) ObjectSerializer.deserialize("sampleSG.ser");
        StonePlayerClass deserializedSP = (StonePlayerClass) ObjectSerializer.deserialize("sampleSP.ser");

        //画面の初期化
        playerTurn.setText(playerTurnShow(deserializedSP, this.playerTurnNum));
        stoneCounts.setText(stoneLeftShow(this.StoneLeftCounts));
        StringBuilder sb = new StringBuilder(); // StringBuilderオブジェクトを作成
        String result = sb.toString(); // StringBuilderオブジェクトをString型に変換
        for(int i = 0; i < this.StoneLeftCounts; i++){
            sb.append(deserializedSG.getStoneInitial());
        }
        stoneInitial.setText(String.valueOf(sb));
        this.playerTurnNum++;
        if(this.playerTurnNum == deserializedSP.getName().length){
            this.playerTurnNum = 0;
        }
    }

    @FXML
    public String playerTurnShow(StonePlayerClass sp,int i){
        return sp.getName()[i] + "さんのターン";
    }

    @FXML
    public String stoneLeftShow(int counts){
        return "残り" + counts + "個";
    }

}
