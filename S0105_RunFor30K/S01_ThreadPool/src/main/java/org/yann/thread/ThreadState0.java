package org.yann.thread;

import java.util.Arrays;

public class ThreadState0 {

    public static void main(String[] args) {
        Arrays.stream(Thread.State.values()).forEach(System.out::println);
    }

}
