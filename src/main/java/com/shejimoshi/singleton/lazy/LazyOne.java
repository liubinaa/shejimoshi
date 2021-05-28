package com.shejimoshi.singleton.lazy;

/**
 * 第一版
 * 懒汉式单例 默认加载的时候不实例化，在需要用到这个实例的时候才实例化, 这个是有问题的，线程不安全
 *
 * @author liubin
 */
public class LazyOne {
    private LazyOne() {
    }

    private static LazyOne lazyOne = null;

    public static synchronized LazyOne getInstance() {
        if (lazyOne == null) {
            lazyOne = new LazyOne();
        }
        return lazyOne;
    }
}
