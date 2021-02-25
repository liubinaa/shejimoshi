package com.shejimoshi.proxy.jdkproxy.customerproxy;

import java.lang.reflect.Method;

/**
 * @author liubin
 */
public interface CustomerInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
