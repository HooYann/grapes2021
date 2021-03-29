package org.yann.thread.forkjoin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForkJoinPool0Test {

    @Test
    void bitOperation() {
        int indexSeed = 0;
        int SEED_INCREMENT = 0x9e3779b9;
        int s = indexSeed += SEED_INCREMENT;
        System.out.println(Integer.toBinaryString(s));

        int m = 3;

        int i = ((s << 1) | 1) & m;
        System.out.println(i);
    }

    @Test
    void bitOperation_1() {
        // 0 0011                0 0011
        // 1 1110 >反 1 0001 >补 1 0010
        //                      1 0001 = -1
        System.out.println(3 | ~1);
        // 1 111 1111
        // 0 111 1111
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(-128));
    }

    @Test
    void bitOperation_2() {
        int s;
        int indexSeed = 0;
        int SEED_INCREMENT = 0x9e3779b9;
        int length = 8;
        for (int i = 0; i < length; i++) {
            System.out.println(s = indexSeed = (indexSeed + SEED_INCREMENT));
            System.out.println(s = (s << 1));
            int j = (s | 1) & (length-1);
            System.out.println(j);
        }

    }

    @Test
    void bitCount() {
        System.out.println(Integer.bitCount(7));
    }

}