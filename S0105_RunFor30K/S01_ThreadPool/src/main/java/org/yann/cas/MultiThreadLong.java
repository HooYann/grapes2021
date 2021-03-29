package org.yann.cas;

public class MultiThreadLong {

    /**
     * 对于23位操作系统来说，long型数据的读写不是原子性的。
     */
    private static long t = 0;

    public static void main(String[] args) {
        //我电脑是64位的，不会有结果的。
        new Thread(new WriteT(-999L)).start();
        new Thread(new WriteT(-444L)).start();
        new Thread(new WriteT(111L)).start();
        new Thread(new WriteT(333L)).start();
        new Thread(new ReadT()).start();
    }

    public static class WriteT implements Runnable {
        private long v;
        public WriteT(long v) {
            this.v = v;
        }
        @Override
        public void run() {
            while (true) {
                MultiThreadLong.t = v;
                //System.out.println("t = " + t);
                Thread.yield();
            }
        }
    }

    public static class ReadT implements Runnable {
        @Override
        public void run() {
            while (true) {
                long temp = t;
                if (temp != -999L && temp != -444L && temp != 111L && temp != 333L) {
                    System.out.println(temp);
                }
                //System.out.println(temp);
                Thread.yield();
            }
        }
    }
}
