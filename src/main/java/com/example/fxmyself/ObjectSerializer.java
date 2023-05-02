package com.example.fxmyself;

import java.io.*;

public class ObjectSerializer {
    public static void serialize(Object obj, String filename) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject(obj);
        out.close();
    }

    public static Object deserialize(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        Object obj = in.readObject();
        in.close();
        return obj;
    }
}
