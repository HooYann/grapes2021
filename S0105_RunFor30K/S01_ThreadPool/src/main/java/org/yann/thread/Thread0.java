package org.yann.thread;

public class Thread0 extends Thread {

    @Override
    public void run() {
        //System.out.println("run");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        //方法级别调用
        new Thread0().run();
        //线程级别调用
        new Thread0().start();
    }

}
