package org.yann.thread;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class ThreadYield0 {

    public static void main(String[] args) {
        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println(Thread.currentThread().getName() + " do0");
                Thread.yield();
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println(Thread.currentThread().getName() + " do1");
                Thread.yield();
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println(Thread.currentThread().getName() + " do2");
                Thread.yield();
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println(Thread.currentThread().getName() + " do3");
                Thread.yield();
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println(Thread.currentThread().getName() + " do4");
            }
        }.start();

        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println(Thread.currentThread().getName() + " do0");
                //Thread.yield();
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println(Thread.currentThread().getName() + " do1");
                //Thread.yield();
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println(Thread.currentThread().getName() + " do2");
                //Thread.yield();
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println(Thread.currentThread().getName() + " do3");
                //Thread.yield();
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println(Thread.currentThread().getName() + " do4");
            }
        }.start();

        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println(Thread.currentThread().getName() + " do0");
                Thread.yield();
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println(Thread.currentThread().getName() + " do1");
                Thread.yield();
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println(Thread.currentThread().getName() + " do2");
                Thread.yield();
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println(Thread.currentThread().getName() + " do3");
                Thread.yield();
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println(Thread.currentThread().getName() + " do4");
            }
        }.start();

    }
}
