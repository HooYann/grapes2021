package org.yann.aqs;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch0 {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        for (int i = 0; i < 8; i++) {
            new Thread() {
                @Override
                public void run() {
                    count += 1;
                    latch.countDown();
                }
            }.start();
        }
        latch.await();
        System.out.println(count);
    }

}
