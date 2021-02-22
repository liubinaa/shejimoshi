package com.shejimoshi.creationtype.singleton;

import com.shejimoshi.creationtype.singleton.lazy.LazyOne;
import com.shejimoshi.creationtype.singleton.lazy.LazyThree;
import com.shejimoshi.creationtype.singleton.lazy.LazyTwo;

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
                    LazyThree instance = LazyThree.getInstance();
                    latch.countDown();
                    System.out.println(instance);
                }
            }.start();
        }
        try {
            //这个方法是阻塞，当初始的数量count减到0后，才会走这下面的代码。
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
