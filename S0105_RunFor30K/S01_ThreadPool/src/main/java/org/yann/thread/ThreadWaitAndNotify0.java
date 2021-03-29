package org.yann.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ThreadWaitAndNotify0 {
    //go to test;

    private static Logger logger = LoggerFactory.getLogger(ThreadWaitAndNotify0.class);

    private static int pushCount = 0;
    private static ThreadLocal<Integer> popCount = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    private static MyStack myStack = new MyStack();

    //Ali interview questions
    static class MyStack {
        private List<String> list = new ArrayList<>();

        //private final Object lockObj = new Object();

        public void push(String value) {
            //synchronized (lockObj) {
            synchronized (this) {
                list.add(value);
                pushCount += 1;
                notify();
                //lockObj.notify();
            }
        }

        public String pop() throws InterruptedException {
            //synchronized (lockObj) {
            synchronized (this) {
                //if (list.size() <= 0) {
                //虚假唤醒
                while (list.size() <= 0) {
                    wait();
                    //lockObj.wait();
                }
                //logger.debug("{} pop", Thread.currentThread().getName());
                String result = list.remove(list.size()-1);
                popCount.set(popCount.get() + 1);
                return result;
            }
        }
    }

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    myStack.push("" + System.currentTimeMillis());
                    logger.info("pushCount={}", pushCount);
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        myStack.pop();
                        logger.info("popCount={},{}", popCount.get(), Thread.currentThread().getName());
                        //System.out.println(Thread.currentThread().getName() + "：" + myStack.pop());
                    } catch (Exception e) {
                        logger.error("", e);
                        System.exit(0);
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        myStack.pop();
                        logger.info("popCount={},{}", popCount.get(), Thread.currentThread().getName());
                        //System.out.println(Thread.currentThread().getName() + "：" + myStack.pop());
                    } catch (Exception e) {
                        logger.error("", e);
                        System.exit(0);
                    }
                }
            }
        }.start();
    }

}
