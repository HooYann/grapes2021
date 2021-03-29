package org.yann.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class CAS1 {

    private static final Unsafe unsafe;
    private static final long valueOffset;

    volatile int value = 0;

    static{
        try {
            Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            unsafe = (Unsafe) unsafeField.get(null);

            Field valueOffsetField = CAS1.class.getDeclaredField("value");
            valueOffset = unsafe.objectFieldOffset(valueOffsetField);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public int compareAndSet(int expect, int update) {
        for(;;) {
            if (unsafe.compareAndSwapInt(this, valueOffset, expect, update)) {
                return update;
            }
            expect = unsafe.getIntVolatile(this, valueOffset);
            update = expect+1;
        }
    }

    public int get() {
        return value;
    }

    public static void main(String[] args) {
        /*CAS0 obj = new CAS0();
        for (int i = 0; i < 10000; i++) {
            new Thread(){
                @Override
                public void run() {
                    obj.value+=1;
                }
            }.start();
        }
        */

        CAS1 obj = new CAS1();
        for (int i = 0; i < 10000; i++) {
            new Thread(){
                @Override
                public void run() {
                    int expect = obj.get();
                    obj.compareAndSet(expect, expect+1);
                }
            }.start();
        }

        while(Thread.activeCount() >= 1) {
            //idea run
            if (Thread.activeCount() == 2) {
                Thread.currentThread().getThreadGroup().list();
                System.out.println(obj.get());
                break;
            }
            //debug
            if (Thread.activeCount() == 1) {
                Thread.currentThread().getThreadGroup().list();
                System.out.println(obj.get());
                break;
            }
            Thread.yield();
        }

        /*try {
            TimeUnit.MICROSECONDS.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(obj.value);*/
    }

}
