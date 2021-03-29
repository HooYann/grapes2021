package org.yann.aqs;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock0 {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();

        Thread thread0 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    lock.lock();
                    count += 1;
                    lock.unlock();
                }
            }
        };
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    lock.lock();
                    count += 1;
                    lock.unlock();
                }
            }
        };

        thread0.start();thread1.start();
        thread0.join();thread1.join();

        System.out.println(count);
    }

}
