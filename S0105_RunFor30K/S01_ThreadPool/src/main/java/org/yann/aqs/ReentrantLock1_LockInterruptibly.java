package org.yann.aqs;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock1_LockInterruptibly {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                lock.lock();
                //while(true);
                //System.out.println("20s内不给锁");
                TimeUnit.SECONDS.sleep(20);
                //System.out.println("20s过去了给你锁");
                lock.unlock();
            }
        }.start();

        TimeUnit.SECONDS.sleep(2);
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + " 我拿到锁了");
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        thread.start();
        TimeUnit.SECONDS.sleep(4);
        //在获取锁的过程中断它
        System.out.println("10s打断");
        thread.interrupt();
    }
}
