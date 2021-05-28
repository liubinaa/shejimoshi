package com.shejimoshi.proxy.jdkproxy.customerproxy;

import com.shejimoshi.proxy.jdkproxy.Person;
import com.shejimoshi.proxy.jdkproxy.ZhangSan;

/**
 * @author liubin
 */
public class CustomerProxyTest {
    public static void main(String[] args) {
        Person o = (Person) new CusetomerProxyAgent().toInstance(new ZhangSan());
        o.findLove();
        System.out.println(o);
    }
}
