package com.shejimoshi.creationtype.singleton.lazy;

/**
 * 第一版
 * 懒汉式单例 默认加载的时候不实例化，在需要用到这个实例的时候才实例化, 线程不安全
 * spring中的 延时加载就是用的它
 * @author liubin
 */
public class LazyOne {
    private LazyOne(){};
    private static LazyOne lazyOne = null;
    public static LazyOne getInstance() {
        if (lazyOne == null) {
            lazyOne = new LazyOne();
        }
        return lazyOne;
    }
}
