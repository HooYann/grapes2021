package org.yann.cas;

public class Volatile0 {

    private static volatile int race = 0;

    //复合操作，volatile是无法保证原子性的。
    //虽然增量操作（x++）看上去类似一个单独操作，实际上它是一个由读取－修改－写入操作序列组成的组合操作，
    //必须以原子方式执行，而 volatile 不能提供必须的原子特性。
    private static void increase() {
        race++;
        //race += 1;
        //race = race + 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(){
                @Override
                public void run() {
                    for (int i1 = 0; i1 < 10000; i1++) {
                        increase();
                    }
                }
            }.start();
        }

        while(Thread.activeCount() > 1) {
            if (Thread.activeCount() == 2) {
                System.out.println("race：" + race);
                break;
            } else {
                System.out.println(Thread.activeCount());
                Thread.yield();
            }
        }
    }

}
