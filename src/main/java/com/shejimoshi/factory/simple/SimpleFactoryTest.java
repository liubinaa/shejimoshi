package com.shejimoshi.factory.simple;

import com.shejimoshi.factory.Telunsu;

/**
 * @author liubin
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {

        //这个new的过程实际上是一个比较复杂的过程
        //有人民币就不需要自己new了
        System.out.println(new Telunsu().getName());

        //小作坊的生产模式
        //用户本身不再关心生产过程，而只需要关心生产结果
        SimpleFactory simpleFactory = new SimpleFactory();
        System.out.println(simpleFactory.getMilk("特仑苏").getName());

    }
}
