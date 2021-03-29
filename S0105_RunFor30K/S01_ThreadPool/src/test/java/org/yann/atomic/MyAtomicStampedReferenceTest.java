package org.yann.atomic;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MyAtomicStampedReferenceTest {

    BigDecimal chargeLevel = BigDecimal.valueOf(20);
    BigDecimal perChargeAmount = BigDecimal.valueOf(80);
    BigDecimal perConsumeAmount = BigDecimal.valueOf(20);

    void charge(MyAtomicStampedReference<BigDecimal> balance) {
        int expectStamp;
        BigDecimal expectReference;
        if (balance.getReference().compareTo(chargeLevel) <= 0) {
            do {
                expectStamp = balance.getStamp();
                expectReference = balance.getReference();
            } while (!balance.compareAndSet(expectReference, expectReference.add(perChargeAmount), expectStamp, expectStamp+1));
            System.out.println("充值了");
        }
    }

    void consume(MyAtomicStampedReference<BigDecimal> balance) {
        int expectStamp;
        BigDecimal expectReference;
        do {
            expectStamp = balance.getStamp();
            expectReference = balance.getReference();
        } while (!balance.compareAndSet(expectReference, expectReference.subtract(perConsumeAmount), expectStamp, expectStamp+1));

    }

    @Test
    void mvcc() {
        MyAtomicStampedReference<BigDecimal> balance = new MyAtomicStampedReference<>(BigDecimal.valueOf(20), 0);

        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(){
                @Override
                public void run() {
                    while(true) {
                        charge(balance);
                        consume(balance);
                    }
                }
            };
        }


        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }



    }
}