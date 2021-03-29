package org.yann.cas;

public class CAS0 {

    private volatile int value = 0;

    public int compareAndSet(int expect, int update) {
        for(;;) {
            if (value == expect) {
                value = update;
                return value;
            }
            expect = get();
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

        CAS0 obj = new CAS0();
        for (int i = 0; i < 10000; i++) {
            new Thread(){
                @Override
                public void run() {
                    int expect=obj.get();
                    obj.compareAndSet(expect, expect+1);
                }
            }.start();
        }

       while(Thread.activeCount() > 1) {
            if (Thread.activeCount() == 2) {
                System.out.println(obj.value);
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
