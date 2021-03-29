package org.yann.aqs;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupport0 {
    
    private static Logger logger = LoggerFactory.getLogger(LockSupport0.class);
    
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread() {
          @SneakyThrows
          @Override
          public void run() {
              //TimeUnit.SECONDS.sleep(1);
              logger.info("{} before park", Thread.currentThread().getName());
              LockSupport.park();
              //LockSupport.park(this);
              logger.info("{} consume", Thread.currentThread().getName());
          }
        };

        Thread thread2 = new Thread() {
          @SneakyThrows
          @Override
          public void run() {
              TimeUnit.SECONDS.sleep(4);
              logger.info("{} unpark {}", Thread.currentThread().getName(), thread1.getName());
              LockSupport.unpark(thread1);
          }
        };

        /**
         * 先调用LockSupport.unpark()结果会怎样？
         */
        Thread thread3 = new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                logger.info("{} unpark {}", Thread.currentThread().getName(), thread1.getName());
                LockSupport.unpark(thread1);
            }
        };
        //thread3.start();

        Thread thread4 = new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                logger.info("{} before park", Thread.currentThread().getName());
                LockSupport.park(this);
                logger.info("{} consume", Thread.currentThread().getName());
            }
        };
        //thread4.start();

        thread1.start();
        thread2.start();

        /**
         * LockSupport.park()还可以被中断。
         */
        //thread0.interrupt();

        //thread3.start();

    }

}
