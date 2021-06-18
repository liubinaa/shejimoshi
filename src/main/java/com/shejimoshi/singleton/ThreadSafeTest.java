package com.shejimoshi.singleton;

import com.shejimoshi.singleton.lazy.LazyTwo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;

/**
 * @author liubin
 */
public class ThreadSafeTest {
    public static void main(String[] args) {
        int count = 1;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                try {
                    Class<? extends LazyTwo> lazy = LazyTwo.class;
                    try {
                        Constructor<? extends LazyTwo> constructor = lazy.getDeclaredConstructor();
                        constructor.setAccessible(true);
                        try {
                            LazyTwo lazyTwo = constructor.newInstance();
                            try {
                                Field initialized = lazy.getDeclaredField("initialized");
                                initialized.setAccessible(true);
                                initialized.setBoolean(lazyTwo, false);
                            } catch (NoSuchFieldException e) {
                                e.printStackTrace();
                            }
                            LazyTwo lazyTwo1 = constructor.newInstance();
                            System.out.println(lazyTwo);
                            System.out.println(lazyTwo1);
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                } finally {
                    latch.countDown();
                }
            }).start();
        }
        //这个方法是阻塞，当初始的数量count减到0后，才会走这下面的代码。
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
