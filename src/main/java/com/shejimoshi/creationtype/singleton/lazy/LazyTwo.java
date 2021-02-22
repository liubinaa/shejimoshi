package com.shejimoshi.creationtype.singleton.lazy;

/**
 * 第二版 添加线程锁  解决了线程安全问题，但是性能上会有很大问题
 * 懒汉式单例 默认加载的时候不实例化，在需要用到这个实例的时候才实例化, 线程不安全
 * spring中的 延时加载就是用的它
 *
 * @author liubin
 */
public class LazyTwo {
    private LazyTwo(){};
    private static LazyTwo lazyTwo = null;
    public static synchronized LazyTwo getInstance() {
        if (lazyTwo == null) {
            lazyTwo = new LazyTwo();
        }
        return lazyTwo;
    }
}
