package com.shejimoshi.creationtype.singleton.hungry;

/**
 * 饿汉式单例  在使用之前，先创建出来对象，避免了线程安全问题
 * @author liubin
 */
public class Hungry {
    private Hungry() {}
    private static final Hungry hungry = new Hungry();
    public static Hungry getInstance() {
        System.out.println(hungry);
        return hungry;
    }
}
