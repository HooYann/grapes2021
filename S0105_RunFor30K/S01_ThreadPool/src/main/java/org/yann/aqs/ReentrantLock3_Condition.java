package org.yann.aqs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock3_Condition {

    private static int count = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread() {
          @Override
          public void run() {
              while(true) {
                  try {
                      lock.lock();
                      while (count > 8) {
                          condition.await();
                      }
                      count += 1;
                      System.out.println(Thread.currentThread().getName() + " +1, " + count);
                      condition.signalAll();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  } finally {
                      lock.unlock();
                  }
              }
          }
        }.start();

        new Thread() {
          @Override
          public void run() {
              while (true) {
                  try {
                      lock.lock();
                      while (count < 1) {
                          condition.await();
                      }
                      count -= 1;
                      System.out.println(Thread.currentThread().getName() + " -1, " + count);
                      condition.signalAll();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  } finally {
                      lock.unlock();
                  }
              }
          }
        }.start();

        /*new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        lock.lock();
                        while (count < 1) {
                            condition.await();
                        }
                        count -= 1;
                        System.out.println(Thread.currentThread().getName() + " -1, " + count);
                        condition.signalAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }.start();*/

    }

}
