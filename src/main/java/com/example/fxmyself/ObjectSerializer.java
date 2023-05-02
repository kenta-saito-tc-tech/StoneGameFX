package com.example.fxmyself;

import java.io.*;

public class ObjectSerializer {
    public static void serialize(Object obj, String filename) throws IOException {
        // FileOutputStreamを作成する
        FileOutputStream fos = new FileOutputStream(filename);

        // ObjectOutputStreamを作成する
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // ObjectOutputStreamのwriteObjectメソッドを使用して、シリアライズ対象のオブジェクトをファイルに書き込む
        oos.writeObject(obj);
        oos.close();
        //fos.close();
    }

    public static Object deserialize(String filename) throws IOException, ClassNotFoundException {
        // 1. FileInputStreamオブジェクトを使用してファイルを読み込む
        FileInputStream fileIn = new FileInputStream(filename);
        // 2. ObjectInputStreamオブジェクトを作成し、逆シリアル化を実行
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Object obj = in.readObject();
        in.close();
        fileIn.close();
        return obj;
    }
}
