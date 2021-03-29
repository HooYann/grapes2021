package org.yann.fun;

import java.util.function.Function;

public class Function0 {

    public static void main(String[] args) {
        Function<Integer, String> fun1 = x -> {return "\"" + x + "\"";};
        System.out.println(fun1.apply(1));
    }

}
