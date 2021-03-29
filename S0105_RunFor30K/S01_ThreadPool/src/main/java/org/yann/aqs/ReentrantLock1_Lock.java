package org.yann.aqs;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock1_Lock {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                lock.lock();
                //while(true);
                //System.out.println("20s内不给锁");
                TimeUnit.SECONDS.sleep(600);
                //System.out.println("20s过去了给你锁");
                lock.unlock();
            }
        }.start();

        TimeUnit.SECONDS.sleep(2);
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    //lock.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + " 我拿到锁了");
                    lock.unlock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    //lock.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + " 我拿到锁了");
                    lock.unlock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread3 = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    //lock.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + " 我拿到锁了");
                    lock.unlock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread4 = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    //lock.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + " 我拿到锁了");
                    lock.unlock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread5 = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    //lock.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + " 我拿到锁了");
                    lock.unlock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread4.start();
        thread3.start();
        thread1.start();
        thread2.start();
        thread5.start();
    }

}
