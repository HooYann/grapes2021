package org.yann.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class TestRepeated {

    //@Test  xxx
    @RepeatedTest(value = 3)
    void repeated() {
        System.out.println("你猜我会执行几次");
    }

    @RepeatedTest(value = 3, name="{displayName}第{currentRepetition} of {totalRepetitions}")
    @DisplayName("自定义测试")
    void repeatedII() {
        System.out.println("repeated test");
    }

}
