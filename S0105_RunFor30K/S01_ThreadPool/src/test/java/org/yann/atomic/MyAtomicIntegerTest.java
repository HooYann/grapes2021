package org.yann.atomic;

import org.junit.jupiter.api.Test;

import java.util.function.IntBinaryOperator;

import static org.junit.jupiter.api.Assertions.*;

class MyAtomicIntegerTest {

    @Test
    void getAndAddWithDelta() {
        MyAtomicInteger atomicInteger = new MyAtomicInteger(0);
        int delta = 2;
        System.out.println(atomicInteger.getAndAdd(delta));
    }

    @Test
    void addAndGetWithDelta() {
        MyAtomicInteger atomicInteger = new MyAtomicInteger(0);
        int delta = 2;
        System.out.println(atomicInteger.addAndGet(2));
    }

    @Test
    void accumulateAndGet() {
        IntBinaryOperator operator = (x, y) -> (x + y);
        System.out.println(operator.applyAsInt(5, 6));

        MyAtomicInteger atomicInteger = new MyAtomicInteger(5);
        System.out.println(atomicInteger.accumulateAndGet(6, operator));
    }

}