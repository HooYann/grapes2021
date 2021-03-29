package org.yann.thread;

public class ThreadJoin0 {

    static int accumulate = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    accumulate += 1;
                }
            }
        };
        thread.start();
        thread.join();
        System.out.println(accumulate);
    }

}
