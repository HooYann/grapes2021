package org.yann.aqs;

import lombok.SneakyThrows;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrier0 {

    private static int count = 0;

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println(count);
            }
        });

        for (int i = 0; i < 8; i++) {
            new Thread() {
                @SneakyThrows
                @Override
                public void run() {
                    count += 1;
                    cyclicBarrier.await();
                }
            }.start();
        }
    }

}
