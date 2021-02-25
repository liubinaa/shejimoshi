package com.shejimoshi.creationtype.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liubin
 */
public class JdkProxy {

    public Object toInstance(Person person) {
        Class<? extends Person> personClass = person.getClass();
        return Proxy.newProxyInstance(personClass.getClassLoader(), personClass.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("执行代理");
                return method.invoke(person);
            }
        });
    }
}
