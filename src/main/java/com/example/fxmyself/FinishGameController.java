package com.example.fxmyself;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FinishGameController {
    static String winner;
    static String looser;
    @FXML
    private Label winnerName;
    @FXML
    private Label looserName;
    @FXML
    public void initialize(){
        winnerName.setText(winner);
        looserName.setText(looser);
    }
}
