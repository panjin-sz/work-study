/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.concurrent.test;

import java.util.concurrent.CountDownLatch;

/**
 *
 *
 * @author panjin
 * @version $Id: CountDownLatchTest.java 2016年9月5日 下午4:39:10 $
 */
public class CountDownLatchTest {

    /**
     * CountDownLatch类似计数器的功能，比如有一个任务A，它要等待其它N个任务执行完成才能执行，可以利用CountDownLatch来实现这种功能
     * @param args
     */
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        
        new Thread() {
            public void run () {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(2000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        
        new Thread() {
            public void run () {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(2000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        
        try {
            System.out.println("等待2个子线程执行完毕");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
