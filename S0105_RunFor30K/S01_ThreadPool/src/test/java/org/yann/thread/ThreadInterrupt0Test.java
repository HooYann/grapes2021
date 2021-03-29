package org.yann.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import static org.junit.jupiter.api.Assertions.*;

class ThreadInterrupt0Test {

    @Test
    void testInterrupt() throws InterruptedException {
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("I am running");
                }
            }
        };
        thread0.start();
        TimeUnit.MILLISECONDS.sleep(2000);
        thread0.interrupt();//中断线程
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("结束");
    }

    @Test
    void testInterrupt1() throws InterruptedException {
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    System.out.println("I am running");
                }
            }
        };
        thread0.start();
        TimeUnit.MILLISECONDS.sleep(2000);
        thread0.interrupt();//中断线程
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("结束");
    }

    @Test
    void testInterruptWithSleep() throws InterruptedException {
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        //Thread.sleep()方法由于中断而抛出异常，同时它会清除中断标记。
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("I am running");
                }
            }
        };
        thread0.start();
        TimeUnit.MILLISECONDS.sleep(2000);
        thread0.interrupt();//中断线程
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("结束");
    }

    @Test
    void testInterruptWithWait() throws InterruptedException {
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    synchronized (this) {
                        try {
                            TimeUnit.MILLISECONDS.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            //obj.wait()方法由于中断而抛出异常，同时它会清除中断标记。
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("I am running");
                }
            }
        };
        thread0.start();
        TimeUnit.MILLISECONDS.sleep(2000);
        thread0.interrupt();//中断线程
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("结束");
    }

    @Test
    void testInterruptWithPark() throws InterruptedException {
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    LockSupport.park();
                    System.out.println("I am running");
                }
            }
        };
        thread0.start();
        TimeUnit.MILLISECONDS.sleep(2000);
        thread0.interrupt();//中断线程
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("结束");
    }


}