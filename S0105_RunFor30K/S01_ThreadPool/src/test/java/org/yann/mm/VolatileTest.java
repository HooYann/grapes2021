package org.yann.mm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VolatileTest {

    private int race = 0;
    private volatile int volatileRace = 0;

    @Test
    @DisplayName("无volatile")
    void nonVolatile() {
        for (int i = 0; i < 1000; i++) {
            new Thread(){
                @Override
                public void run() {
                    for (int i1 = 0; i1 < 10; i1++) {
                        System.out.println(race++);
                    }
                }
            }.start();
        }
    }

    @Test
    @DisplayName("不保证原子性")
    void hasVolatile() {
        for (int i = 0; i < 1000; i++) {
            new Thread(){
                @Override
                public void run() {
                    for (int i1 = 0; i1 < 10; i1++) {
                        System.out.println(volatileRace++);
                    }
                }
            }.start();
        }
    }

    @Test
    void visible() {
        boolean initialized = false;
        while(true) {
            if(initialized) {
                break;
            }
        }
    }

}
