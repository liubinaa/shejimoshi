package com.shejimoshi.singleton.lazy;

/**
 * 第一版
 * 懒汉式单例 默认加载的时候不实例化，在需要用到这个实例的时候才实例化。因为线程有自己的工作内存，所以还会有线程安全问题，而且锁的是整个方法，效率低
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
