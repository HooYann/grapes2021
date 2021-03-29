package org.yann.aqs;

import org.junit.jupiter.api.Test;

public class Test01 {

    @Test
    void doubleEquals() {
        int i,x,y;
        i = 1;
        x = 2;
        y = 3;
        y = x = i;
        System.out.println(y);
    }

}
