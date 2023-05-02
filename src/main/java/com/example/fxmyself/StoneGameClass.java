package com.example.fxmyself;

import java.io.Serializable;

public class StoneGameClass implements App, Serializable {
    //フィールド
    private int howManyStone;
    private String StoneInitial;
    private int howManySteal;

    public StoneGameClass() {
        System.out.println("!");
    }

    //ゲッター、セッター
    public int getHowManyStone() {
        return this.howManyStone;
    }

    public void setHowManyStone(int howManyStone) {
        this.howManyStone = howManyStone;
    }
    public void changeHowManyStone(int num){
        this.howManyStone -= num;
    }

    public String getStoneInitial() {
        return this.StoneInitial;
    }

    public void setStoneInitial(String stoneInitial) {
        this.StoneInitial = stoneInitial;
    }

    public int getHowManySteal() {
        return this.howManySteal;
    }

    public void setHowManySteal(int howManySteal) {
        this.howManySteal = howManySteal;
    }

    @Override
    public void start() {
        System.out.println("ゲーム開始");
    }
    @Override
    public String toString(){
        return "ストーンゲームアプリ";
    }
}

