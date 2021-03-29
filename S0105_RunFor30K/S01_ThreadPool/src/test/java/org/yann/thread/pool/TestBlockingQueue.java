package org.yann.thread.pool;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.SynchronousQueue;

public class TestBlockingQueue {

    @Test
    void arrayBlockingQueue() throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);
        queue.put(1);
        queue.put(2);
        queue.take();
    }

    @Test
    void linkedTransferQueue() throws InterruptedException {
        LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<Integer>();



        /*new Thread(){
            @Override
            public void run() {
                try {
                    Integer rs1 = (Integer)queue.take();
                    System.out.println(rs1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();*/



        new Thread(){
            @Override
            public void run() {
                queue.put(1);
                //queue.put(2);
            }
        }.start();

        Thread.sleep(1000);

        new Thread(){
            @Override
            public void run() {
                try {
                    Integer rs0 = (Integer)queue.take();
                    System.out.println(rs0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    @Test
    void synchronousQueue() throws InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>(true);

        /*new Thread(){
            @Override
            public void run() {
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
*/
        Thread.sleep(1000);

        new Thread(){
            @Override
            public void run() {
                try {
                    Integer rs = (Integer)queue.take();
                    System.out.println(rs);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    @Test
    void priorityQueue() {
        List<Integer> list = new ArrayList<>();

        list.add(15);
        list.add(14);
        list.add(13);
        list.add(12);
        list.add(11);
        list.add(10);
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        PriorityQueue<Integer> queue = new PriorityQueue<>(list);
        //queue.poll();
        System.out.println(queue.remove(4));
    }


    @Test
    void hashMapCapacity() {
        int cap = 33;
        int n = cap - 1;

        n |= n >>> 1;// n = n | (n >>> 1)
        System.out.println(">>>1：" + n);

        //int m = cap - 1;
        //m = m | (m >>> 1);
        //System.out.println(">>>1m：" + m);

        n |= n >>> 2;
        System.out.println(">>>2：" + n);
        n |= n >>> 4;
        System.out.println(">>>3：" + n);
        n |= n >>> 8;
        System.out.println(">>>4：" + n);
        n |= n >>> 16;
        System.out.println(">>>5：" + n);
        int rs = (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
        System.out.println("rs：" + rs);
    }

    @Test//bitOr、bitNon、bitExclusiveOr
    void bitAnd() {

        int COUNT_BITS = Integer.SIZE - 3;
        int CAPACITY   = (1 << COUNT_BITS) - 1;
        System.out.println(CAPACITY);

        int rs = -1 << COUNT_BITS;
        int wc = 0;
        int ctl = rs | wc;
        System.out.println(ctl);

        System.out.println(ctl & CAPACITY);
    }


}
