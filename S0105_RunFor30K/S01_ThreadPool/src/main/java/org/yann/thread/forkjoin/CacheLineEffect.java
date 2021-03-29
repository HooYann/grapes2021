package org.yann.thread.forkjoin;

import java.time.Duration;
import java.time.Instant;

public class CacheLineEffect {
    public static void main(String[] args) {
        long[][] block = new long[1024*1024][8];
        Instant markTime = null;
        for (int i=0; i<1024*1024; i++) {
            for (int j=0; j<8; j++) {
                block[i][j] = 0L;
            }
        }
        long sum = 0;
        markTime = Instant.now();
        for (int i=0; i<1024*1024; i++) {
            for (int j=0; j<8; j++) {
                sum += block[i][j];
            }
        }
        System.out.println(Duration.between(markTime, Instant.now()).toMillis());
        sum = 0;
        markTime = Instant.now();
        for (int i=0; i<8; i++) {
            for (int j=0; j<1024*1024; j++) {
                sum += block[j][i];
            }
        }
        System.out.println(Duration.between(markTime, Instant.now()).toMillis());
    }

}
