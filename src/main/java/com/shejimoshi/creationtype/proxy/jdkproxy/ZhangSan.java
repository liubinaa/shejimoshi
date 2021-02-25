package com.shejimoshi.creationtype.proxy.jdkproxy;

/**
 * @author liubin
 */
public class ZhangSan implements Person {

    @Override
    public void findLove() {
        System.out.println("这里是被代理类");
    }
}
