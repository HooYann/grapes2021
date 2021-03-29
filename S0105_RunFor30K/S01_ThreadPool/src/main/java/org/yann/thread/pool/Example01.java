package org.yann.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Example01 {

    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            };
            thread.start();
            thread.join();
        }
        System.out.println("时间：" + (System.currentTimeMillis()-start));
        System.out.println("大小：" + list.size());
    }



}