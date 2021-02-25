package com.shejimoshi.singleton;

import com.shejimoshi.singleton.lazy.LazyThree;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author liubin
 */
public class TestLazyThree {
    public static void main(String[] args) {
        Class<LazyThree> c = LazyThree.class;
        try {
            Constructor<LazyThree> constructor = c.getDeclaredConstructor();
            constructor.setAccessible(true);
            try {
                Method[] declaredMethods = c.getDeclaredMethods();
                for (Method m : declaredMethods) {
                    Object invoke = m.invoke(null);
                    System.out.println(invoke);
                    System.out.println(LazyThree.LazyHolder.getInstance());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
