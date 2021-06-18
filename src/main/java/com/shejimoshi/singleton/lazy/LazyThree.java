package com.shejimoshi.singleton.lazy;

/**
 * 另一种懒汉 使用静态内部类
 * 通过jvm来保证其线程安全，而懒加载的机制则是依靠虚拟机规范制度的类“初始化”规则保证
 * 懒汉式单例 默认加载的时候不实例化，在需要用到这个实例的时候才实例化
 * 在单例对象占用资源大，需要延时加载的情况下优选
 * spring中的 延时加载就是用的它
 *
 * @author liubin
 */
public class LazyThree {

    /**
     * 默认使用LazyThree的时候，会先初始化内部类,如果没使用的话，内部类是不加载的
     */
    private LazyThree() {
    }

    public static class LazyHolder {
        private static final LazyThree LAZY = new LazyThree();

        public static LazyThree getInstance() {
            return LAZY;
        }
    }
}
