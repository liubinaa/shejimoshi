package com.shejimoshi.singleton.register;

/**
 * 枚举单例
 * 单元素的枚举类型已经成为实现Singleton的最佳方法
 * <p>
 * 编译器生成的values()方法和valueOf(String name)方法是编译器生成的static方法
 *
 * @author liubin
 */
public enum RegisterEnum {
    /**
     * 单例
     */
    INSTANCE;

    private RegisterEnum getInstance() {
        return INSTANCE;
    }
}
