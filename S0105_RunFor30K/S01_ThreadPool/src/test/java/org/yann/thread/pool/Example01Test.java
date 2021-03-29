package org.yann.thread.pool;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class Example01Test {

    @Test
    void normal() throws InterruptedException {
        Long start = System.currentTimeMillis();
        Set<Thread> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    list.add(random.nextInt());
                    set.add(Thread.currentThread());
                }
            };
            thread.start();
            thread.join();
        }
        System.out.println("时间：" + (System.currentTimeMillis()-start));
        System.out.println("大小：" + list.size());
        System.out.println("线程大小：" + set.size());
    }

    @Test
    void cachedThreadPool() throws InterruptedException {
        Long start = System.currentTimeMillis();

        final Set<Thread> set = new HashSet<>();
        final List<Integer> list = new ArrayList<>();
        final Random random = new Random();
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 100000; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                    set.add(Thread.currentThread());
                }
            });
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("时间：" + (System.currentTimeMillis()-start));
        System.out.println("大小：" + list.size());
        System.out.println("线程大小：" + set.size());
    }

    @Test
    void selfCachedThreadPool() throws InterruptedException {
        Long start = System.currentTimeMillis();

        final Set<Thread> set = new HashSet<>();
        final List<Integer> list = new ArrayList<>();
        final Random random = new Random();
        ExecutorService service = new ThreadPoolExecutor(0, 100000,
                0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>());
        for (int i = 0; i < 100000; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                    set.add(Thread.currentThread());
                }
            });
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("时间：" + (System.currentTimeMillis()-start));
        System.out.println("大小：" + list.size());
        System.out.println("线程大小：" + set.size());
    }

}