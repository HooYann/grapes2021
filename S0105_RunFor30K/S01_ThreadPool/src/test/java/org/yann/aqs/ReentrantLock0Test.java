package org.yann.aqs;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.jupiter.api.Assertions.*;

class ReentrantLock0Test {

    private int count = 0;


    @Test
    void reEntrant() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        new Thread(){
            @Override
            public void run() {
                lock.lock();
                lock.lock();
                count += 1;
                lock.unlock();
                lock.unlock();
            }
        }.start();

        TimeUnit.MILLISECONDS.sleep(1000);

        new Thread(){
            @Override
            public void run() {
                try{
                    lock.lock();
                    count += 1;
                    lock.unlock();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //lock.unlock();
                }

            }
        }.start();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println(count);
    }

    @Test
    void tryLock() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Thread thread0 = new Thread(){
            @Override
            public void run() {
                lock.lock();
                while(!Thread.currentThread().isInterrupted()) {
                }
                lock.unlock();
            }
        };
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                while(!lock.tryLock()) {
                    System.out.println("tryLock=" + false);
                }
                System.out.println("tryLock=" + true);
                lock.unlock();
            }
        };
        thread0.start();
        TimeUnit.MILLISECONDS.sleep(1000);
        thread1.start();
        TimeUnit.MILLISECONDS.sleep(3000);
        thread0.interrupt();
    }

}