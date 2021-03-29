package org.yann.aqs;

import java.util.concurrent.Semaphore;

public class Semaphore0 {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);
        for (int i = 0; i < 12; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        while (true) {
                            System.out.println(Thread.currentThread().getName());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }
            }.start();
        }

    }

}
