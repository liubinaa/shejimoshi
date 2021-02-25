package com.shejimoshi.singleton;

import com.shejimoshi.singleton.serializable.SerializableSingleton;

import java.io.*;

/**
 * @author liubin
 */
public class TestSerializableSingleton {
    public static void main(String[] args) {
        SerializableSingleton s1 = null;
        SerializableSingleton s2 = SerializableSingleton.getInstance();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/java/Serializable.obj"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/java/Serializable.obj"));
) {
            oos.writeObject(s2);
            oos.flush();
            s1 = (SerializableSingleton)ois.readObject();
            System.out.println(s2);
            System.out.println(s1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
