package org.yann.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MCSLock implements Lock {

    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        MCSLock lock = new MCSLock();

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
        while(Thread.activeCount() > 1) {

        }
        System.out.println(count);
    }


//==========================================================================//
    private static Logger logger = LoggerFactory.getLogger(MCSLock.class);
    //private static final int spinThreshold = 1 << 64;

    private AtomicReference<Node> tail;
    private ThreadLocal<Node> nodeHolder = new ThreadLocal<Node>() {
        @Override
        protected Node initialValue() {
            return new Node(true);
        }
    };
    static final class Node {
        private Node next;
        private volatile boolean locked = false;

        public Node(){}
        public Node(boolean aLocked) {
            this.locked = aLocked;
        }

    }
    public MCSLock() {
        tail = new AtomicReference<>(null);
    }

    @Override
    public void lock() {
        Node curNode = nodeHolder.get();
        Node pred = tail.getAndSet(curNode);
        if (pred == null) {
            curNode.locked = false;
        } else {
            pred.next = curNode;
            while(curNode.locked);
            //spin
            logger.debug(Thread.currentThread().getName());
        }
    }
    @Override
    public void unlock() {
        Node curNode = nodeHolder.get();
        //难点：后续节点还未加入进来
        //重点：&& !tail.compareAndSet(curNode, null)。//难道就没有没来得及的后续节点？
        while (curNode.next == null && !tail.compareAndSet(curNode, null)) {
            Thread.yield();
        }
        if (curNode.next != null) {
            //解锁
            curNode.next.locked = false;
            // help GC
            curNode.next = null;
            curNode = null;
        }
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

class MCSLockTest0 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
