package org.yann.cas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileSingleton {

    static VolatileSingleton instance = null;

    private VolatileSingleton() {}

    public static VolatileSingleton newInstance() {
        if(instance == null) {
            instance = new VolatileSingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);

        Runnable r = () -> System.out.println(newInstance());

        while(true) {
            service.execute(r);
        }
    }

}
