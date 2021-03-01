package com.shejimoshi.decorator;

import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

/**
 * 装饰器模式
 * 对原来的方法 修饰增强，扩展其他方法  关键字：wrapper，decorator
 *
 * 装饰者和被装饰者都要实现同一个接口，主要目的是为了扩展，依旧保留OOP关系 满足 is a  注重覆盖、扩展
 * 而适配器：适配者和被适配者没有必然的层级关系，通常采用代理或者继承形式进行包装 满足 has a   注重兼容、转换
 * @author liubin
 */
public class DecoratorTest {
    public static void main(String[] args) {
        //为了某个实现类在不修改原始类的基础上进行动态的覆盖或者增加方法
        //与适配器模式的区别：该实现保持跟原有类的层级关系
        //采用装饰模式
        //装饰器模式实际上是一种非常特殊的适配器模式
        InputStream inputStream = null;
        //DataInputStream功能更强大
        //DataInputStream同样要实现inputStream
        FilterInputStream fis =  new DataInputStream(inputStream);
    }
}
