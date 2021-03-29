package org.yann.aqs;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock2_Fair {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        //ReentrantLock lock = new ReentrantLock(false);
        Thread thread1 = new Thread() {
          @Override
          public void run() {
              while (true) {
                  lock.lock();
                  System.out.println(Thread.currentThread().getName() + " get");
                  lock.unlock();
              }
          }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " get");
                    lock.unlock();
                }
            }
        };
        Thread thread3 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " get");
                    lock.unlock();
                }
            }
        };
        thread1.start();
        thread2.start();
        thread3.start();

    }

}
