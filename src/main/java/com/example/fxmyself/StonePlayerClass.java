package com.example.fxmyself;

import java.io.Serializable;
import java.util.Scanner;

public class StonePlayerClass implements Serializable {
    //フィールド
    private String[] name;
    private int howManyPeople;

    public StonePlayerClass() {
        System.out.println("%");
    }

    //ゲッター、セッター

    public String[] getName() {
        return this.name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public int getHowManyPeople() {
        // howManyPeople = name.length;
        return this.howManyPeople;
    }

    public void setHowManyPeople(int howManyPeople) {
        this.howManyPeople = howManyPeople;
        this.name = new String[this.howManyPeople];
    }
}
