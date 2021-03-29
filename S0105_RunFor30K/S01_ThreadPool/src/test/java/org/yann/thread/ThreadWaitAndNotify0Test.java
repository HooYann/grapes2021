package org.yann.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ThreadWaitAndNotify0Test {

    public void doWait() {
        synchronized (this) {
            try {
                wait();
                System.out.println(Thread.currentThread().getName() + " receiveNotify");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void doNotify() {
        synchronized (this) {
            try {
                System.out.println(Thread.currentThread().getName() + " doNotify");
                notify();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void doNotifyAll() {
        synchronized (this) {
            try {
                System.out.println(Thread.currentThread().getName() + " doNotifyAll");
                notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void test0() throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                System.out.println("wait: " + Thread.currentThread().getName());
                doWait();
            }
        }.start();

        TimeUnit.MICROSECONDS.sleep(2000);

        new Thread() {
            @Override
            public void run() {
                doNotify();
            }
        }.start();
    }

    @Test
    void test1() throws InterruptedException {
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                System.out.println("wait: " + Thread.currentThread().getName());
                doWait();
            }
        };

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("wait: " + Thread.currentThread().getName());
                doWait();
            }
        };

        thread1.start();
        thread0.start();

        TimeUnit.MICROSECONDS.sleep(2000);

        new Thread() {
            @Override
            public void run() {
                doNotifyAll();
            }
        }.start();

    }

}