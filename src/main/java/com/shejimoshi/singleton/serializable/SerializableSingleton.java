package com.shejimoshi.singleton.serializable;

import java.io.Serializable;

/**
 * 序列化单例
 * @author liubin
 */
public class SerializableSingleton implements Serializable {
    private SerializableSingleton() {}
    public final static SerializableSingleton INSTANCE = new SerializableSingleton();
    public static SerializableSingleton getInstance() {
        return INSTANCE;
    }

    /**
     * 方法由jvm自动调用，序列化里面的两个方法之一
     * @return
     */
    private Object readResolve() {
        return INSTANCE;
    }
}
