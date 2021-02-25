package com.shejimoshi.singleton.hungry;

/**
 * 单例模式：初衷就是为了使资源能够共享，只需要赋值或者初始化一次，大家都能重复使用
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
