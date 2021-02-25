package com.shejimoshi.singleton;

import com.shejimoshi.singleton.lazy.LazyTwo;

import java.util.concurrent.CountDownLatch;

/**
 * @author liubin
 */
public class ThreadSafeTest {
    public static void main(String[] args) {
        int count = 1000;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i ++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        //这个方法是阻塞，当初始的数量count减到0后，才会走这下面的代码。
                        latch.await();
                        LazyTwo instance = LazyTwo.getInstance();
                        System.out.println(instance);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }
            }.start();
        }

    }
}
