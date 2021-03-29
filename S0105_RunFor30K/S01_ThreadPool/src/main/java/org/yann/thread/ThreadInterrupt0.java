package org.yann.thread;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt0 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("break.");
                        break;
                    }
                    System.out.println("I am running");
                }
            }
        };
        thread0.start();
        TimeUnit.MILLISECONDS.sleep(2000);
        thread0.interrupt();//中断线程
        System.out.println("中断结果：" + thread0.isInterrupted());
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("结束");
    }

}
