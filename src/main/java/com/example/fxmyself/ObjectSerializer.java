package com.example.fxmyself;

import java.io.*;

public class ObjectSerializer {

    // ObjectOutputStreamを作成する
    static ObjectOutputStream oos;
    static ObjectOutputStream oos2;

    public static void setOos(ObjectOutputStream oos) {
        ObjectSerializer.oos = oos;
    }

    public static void setOos2(ObjectOutputStream oos2) {
        ObjectSerializer.oos2 = oos2;
    }

    public static ObjectOutputStream getOos() {
        return oos;
    }

    public static ObjectOutputStream getOos2() {
        return oos2;
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
