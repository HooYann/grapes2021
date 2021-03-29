package org.yann.cas;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Volatile2 {

    public static void main(String[] args) {
        Thread[] threads = new Thread[40];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread() {
                @Override
                public void run() {
                    ConfigBuilder.doWork();
                }
            };
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }


    static class ConfigBuilder {

        static boolean initialized = false;

        static void doWork() {
            Map<String, Object> config = initialize();
            config.getOrDefault("environment", "test");
            while (!ready()) {
                System.out.println(Thread.currentThread().getName() + " wait");
                break;
            }
            System.out.println(Thread.currentThread().getName() + " work");
        }

        static Map<String, Object> initialize() {
            Map<String, Object> config = new HashMap<>();
            config.put("environment", "test");
            try {
                TimeUnit.MILLISECONDS.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            initialized = true;
            return config;
        }

        public static boolean ready() {
            return initialized;
        }
    }

}




