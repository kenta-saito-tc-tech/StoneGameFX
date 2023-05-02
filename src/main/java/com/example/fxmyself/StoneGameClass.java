package com.example.fxmyself;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StoneGameClass implements App{
    //フィールド
    private int howManyStone;
    private String StoneInitial;
    private int howManySteal;
    //private static final StoneGameClass sg = new StoneGameClass();

    public StoneGameClass() {
        System.out.println("!");
    }
//    public static StoneGameClass getInstance(){
//        //new StoneGameClass();
//        return sg;
//    }

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

    //メソッド

    /**
     * ゲームのセッティングをするメソッド
     */
    public void gameSetting() {
        int inputStone = -1; //仮
        int inputSteal = -1; //仮
        boolean flgForStone = true;
        boolean flgForSteal = true;

        BasicMethod.oneNewBorderLine();
        Scanner scn = new Scanner(System.in);
        System.out.println("石取りゲームを開始します。");
        while(flgForStone){
            try{
                System.out.print("石の総数は?>>");
                inputStone = scn.nextInt();
                if(inputStone < 10 || inputStone > 100){
                    System.out.println("10~100の間でお願いします");
                }else {
                    flgForStone = false;
                }
            }catch (InputMismatchException e){
                System.out.println("数値ではありません。");
                System.out.println("最初からやり直します");
                gameSetting();
            }
        }
        setHowManyStone(inputStone); //総数セット
        System.out.print("石のイニシャルは?>>");
        setStoneInitial(scn.next()); //イニシャルセット
        while(flgForSteal){
            try{
                System.out.print("１度に取れる石の数は?>>");
                inputSteal = scn.nextInt();
                if(inputSteal < 1 || inputSteal > 10){
                    System.out.println("1~10の間でお願いします");
                }else {
                    flgForSteal = false;
                }
            }catch (InputMismatchException e){
                System.out.println("数値ではありません。");
                System.out.println("最初からやり直します");
                gameSetting();
            }
        }
        setHowManySteal(inputSteal); //取れる個数セット
    }

    /**
     * 石の残数表示メソッド
     * @param num 石の数（getHowManyStone）
     */
    public void stoneShow(int num){
        for(int i = 1; i <= num; i++){
            System.out.print(getStoneInitial());
        }
        System.out.println();
    }

    /**
     * 各プレイヤーのターンメソッド
     * @param str そのターンのプレイヤー名
     * @return -999の場合、例外発生　その他の場合、残りの石の数
     */
    public int playerTurn(String str) {
        BasicMethod.oneNewBorderLine();
        Scanner scn = new Scanner(System.in);
        System.out.println(str+"さんの番");
        System.out.println("石の数を入力してください。（1〜"+getHowManySteal()+"まで入力可能です。）");
        String numStr = scn.nextLine();
        try {
            int stealNum = Integer.parseInt(numStr);
            if (stealNum >0 && stealNum <= getHowManySteal()){
                changeHowManyStone(stealNum);
                System.out.println("残り" +getHowManyStone()+ "個");
                stoneShow(getHowManyStone());
            } else if (stealNum <= 0) {
                changeHowManyStone(1);
                System.out.println("残り" +getHowManyStone()+ "個");
                stoneShow(getHowManyStone());
            }else if(stealNum > getHowManySteal()){
                changeHowManyStone(getHowManySteal());
                System.out.println("残り" +getHowManyStone()+ "個");
                stoneShow(getHowManyStone());
            }
        } catch (NumberFormatException e) {
            System.out.println(numStr + "は数値ではありません。");
            return -999;
        }
        return getHowManyStone();
    }

    /**
     * 勝者と敗者を表示するメソッド
     * @param winName 勝者の名前
     * @param looseName 敗者の名前
     */
    public void winLooseShow(String winName, String looseName){
        Scanner scn = new Scanner(System.in);
        System.out.println("勝者:" +winName);
        System.out.println("敗者:" + looseName);
        scn.close();
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

