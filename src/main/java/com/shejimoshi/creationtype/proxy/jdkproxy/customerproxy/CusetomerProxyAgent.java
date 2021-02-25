package com.shejimoshi.creationtype.proxy.jdkproxy.customerproxy;

import com.shejimoshi.creationtype.proxy.jdkproxy.Person;

import java.lang.reflect.Method;

/**
 * @author liubin
 */
public class CusetomerProxyAgent {
    public Object toInstance(Person person) {
        Class<? extends Person> personClass = person.getClass();
        return CustomerProxy.newProxyInstance(new CustomerClassloader(), personClass.getInterfaces(), new CustomerInvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("执行代理");
                return method.invoke(person);
            }
        });
    }
}
