package com.shejimoshi.creationtype.factory.func;

/**
 * @author liubin
 */
public class FactoryTest {
    public static void main(String[] args) {

        //货比三家，不知道谁好谁坏，需要配置，可能出错
        Factory factory = new YiliFactory();
        System.out.println(factory.getMilk());
    }
}
