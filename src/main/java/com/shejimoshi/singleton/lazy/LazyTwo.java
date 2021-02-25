package com.shejimoshi.singleton.lazy;

/**
 * 第二版 双重检查锁  解决了线程安全问题，但是性能上会有很大问题
 * 在双重检查锁模式中为什么需要使用 volatile 关键字?
 *
 * 在java内存模型中，volatile 关键字作用可以是保证可见性或者禁止指令重排。这里是因为 singleton = new Singleton() ，它并非是一个原子操作，事实上，在 JVM 中上述语句至少做了以下这 3 件事：
 *
 * 第一步是给 singleton 分配内存空间；
 *
 * 第二步开始调用 Singleton 的构造函数等，来初始化 singleton；
 *
 * 第三步，将 singleton 对象指向分配的内存空间（执行完这步 singleton 就不是 null 了）。
 *
 * 这里需要留意一下 1-2-3 的顺序，因为存在指令重排序的优化，也就是说第 2 步和第 3 步的顺序是不能保证的，最终的执行顺序，可能是 1-2-3，也有可能是 1-3-2。
 * spring中的 延时加载就是用的它
 *
 * @author liubin
 */
public class LazyTwo {
    private LazyTwo(){};
    /**
     * 第二层锁，volatile关键字禁止指令重排
     */
    private static volatile LazyTwo lazyTwo;
    public static LazyTwo getInstance() {
        //第一层检查，检查是否有引用指向对象，高并发情况下会有多个线程同时进入
        if (lazyTwo == null) {
            //第一层锁，保证只有一个线程进入
            synchronized (LazyTwo.class) {
                //第二层检查，第二次判断是为了避免重复创建单例，因为可能会存在多个线程通过了第一次判断在等待锁，来创建新的实例对象。
                if (lazyTwo != null) {
                    lazyTwo = new LazyTwo();
                }
            }
        }
        return lazyTwo;
    }
}
