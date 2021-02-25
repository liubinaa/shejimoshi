package com.shejimoshi.singleton.register;

/**
 * 枚举单例
 * 单元素的枚举类型已经成为实现Singleton的最佳方法
 * @author liubin
 */
public enum RegisterEnum {
    /**
     * 单例
     */
    INSTANCE;
    private RegisterEnum getInstance(){
        return INSTANCE;
    }
}
