package org.yann.thread.forkjoin;

public class FalseSharing implements Runnable {

    private long loops = 100 * 1000 * 1000;
    private static ValuePadding[] arr;
    private int index = 0;

    public FalseSharing(int aIndex) {
        this.index = aIndex;
    }


    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        arr = new ValuePadding[threads.length];
        for (int i = 0; i < threads.length; i++) {
            arr[i] = new ValuePadding();
            threads[i] = new Thread(new FalseSharing(i));
        }
        long start = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(System.currentTimeMillis()-start);
    }

    @Override
    public void run() {
        while(--loops != index) {
            arr[index].value = 0L;
        }

    }

    static final class ValuePadding {
        protected long p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15;
        protected volatile long value = 0L;
        protected long p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29,p30,p31;
    }
    static final class NoValuePadding {
        protected volatile long value = 0L;
    }
}
