package com.shejimoshi.factory.func;

/**
 * @author liubin
 */
public class FactoryTest {
    public static void main(String[] args) {

        //货比三家，不知道谁好谁坏，需要配置，可能出错
        Factory yiliFactory = new YiliFactory();
        System.out.println(yiliFactory.getMilk());

        Factory telunsuFactory = new YiliFactory();
        System.out.println(telunsuFactory.getMilk());
    }
}
