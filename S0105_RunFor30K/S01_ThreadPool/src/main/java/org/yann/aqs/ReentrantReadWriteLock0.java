package org.yann.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLock0 {

    static Logger logger = LoggerFactory.getLogger(ReentrantReadWriteLock0.class);

    /**
     * 写写
     * 读写
     * 读读
     * @param args
     */
    public static void main(String[] args) {
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        Lock rLock = rwLock.readLock();
        Lock wLock = rwLock.writeLock();
        //读读
        new Thread() {
          @Override
          public void run() {
              rLock.lock();
              try {
                  while (true) {
                      logger.info(Thread.currentThread().getName());
                  }
              } finally {
                  rLock.unlock();
              }
          }
        }.start();
        new Thread() {
            @Override
            public void run() {
                rLock.lock();
                try {
                    while (true) {
                        logger.info(Thread.currentThread().getName());
                    }
                } finally {
                    rLock.unlock();
                }
            }
        }.start();
    }

}
