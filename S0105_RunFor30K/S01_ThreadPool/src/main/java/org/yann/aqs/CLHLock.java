package org.yann.aqs;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class CLHLock implements Lock {
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        CLHLock lock = new CLHLock();

        Thread[] threads = new Thread[200];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread() {
                @Override
                public void run() {
                    lock.lock();
                    try {
                        for (int i1 = 0; i1 < 1000000; i1++) {
                            count += 1;
                        }

                    } finally {
                        lock.unlock();
                    }
                }
            };
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
            //threads[i].join();
        }
        while(Thread.activeCount() > 2) {

        }
        System.out.println(count);
    }


//====================================================================//
    private static Logger logger = LoggerFactory.getLogger(CLHLock.class);

    private AtomicReference<Node> tail;
    private ThreadLocal<Node> nodeHolder;

    public CLHLock() {
        tail = new AtomicReference<>(new Node());
        nodeHolder = new ThreadLocal<Node>() {
            @Override
            protected Node initialValue() {
                return new Node(true);
            }
        };
    }

    static final class Node {
        Node prev;
        volatile boolean locked = false;

        public Node(){}
        public Node(boolean aLocked) {
            this.locked = aLocked;
        }
    }

    @Override
    public void lock() {
        Node curNode = nodeHolder.get();
        Node pred = tail.getAndSet(curNode);
        curNode.prev = pred;
        while(curNode.prev.locked) {
            //spin
            logger.debug(Thread.currentThread().getName());
        }
        //自旋完获得锁后，移除已执行完的节点，help GC
        pred = null;
        curNode.prev = null;
    }

    @Override
    public void unlock() {
        Node curNode = nodeHolder.get();
        curNode.locked = false;
        //help GC
        nodeHolder.remove();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}

class CLHLockTest0 {
    public static void main(String[] args) throws InterruptedException {
        CLHLock.Node node = new CLHLock.Node(true);
        ThreadLocal nodeHolder = new ThreadLocal();

        /*new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                nodeHolder.set(node);
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " " + (nodeHolder.get() == node));
                System.out.println(((CLHLock.Node) nodeHolder.get()).locked);
            }
        }.start();*/

        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                nodeHolder.set(node);
                ((CLHLock.Node) nodeHolder.get()).locked = false;
            }
        }.start();

        //node.locked = false;
        //System.out.println("locked=false");

        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread().getName() + " " + node.locked);
    }
}
