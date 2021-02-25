package com.shejimoshi.creationtype.singleton.lazy;

/**
 * 第三版 使用静态内部类
 * 通过jvm来保证其线程安全，而懒加载的机制则是依靠虚拟机规范制度的类“初始化”规则保证
 * 懒汉式单例 默认加载的时候不实例化，在需要用到这个实例的时候才实例化, 线程不安全
 * 在单例对象占用资源大，需要延时加载的情况下优选
 * spring中的 延时加载就是用的它
 *
 * @author liubin
 */
public class LazyThree {
    /**
     * 防止反射入侵，构造方法里使用，个人认为这里没必要使用。。。
     * 因为static修饰的只加载一次，测试的时候也是这样。而且可以通过反射改变这个变量的值
     */
    private static boolean initialized = false;
    /**
     * 默认使用LazyThree的时候，会先初始化内部类,如果没使用的话，内部类是不加载的
     */
    private LazyThree(){
        synchronized (LazyThree.class) {
            if (!initialized) {
                initialized = true;
            } else {
                throw new RuntimeException("单例已被侵犯");
            }
        }
    }

    public static class LazyHolder {
        private static final LazyThree lazy = new LazyThree();

        public static LazyThree getInstance() {
            return lazy;
        }
    }
}
