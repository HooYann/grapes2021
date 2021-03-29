package org.yann.cas;

import java.util.concurrent.TimeUnit;

public class Volatile1 {

    static boolean offWork = false;

    public static void doWork() {
        System.out.println("今天又是打鸡血的一天");
        while(!offWork) {
            System.out.println("工作...");
        }
    }

    public static void goOffWork() {
        offWork = true;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(){
                @Override
                public void run() {
                    doWork();
                }
            }.start();
        }

        new Thread(){
            @Override
            public void run() {
                try {
                    //12小时后
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                goOffWork();
                System.out.println("下班了：" + offWork);
            }
        }.start();

    }

}
