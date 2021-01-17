package org.yann.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class TestAssertions {

    @Test
    void assertions() {
        //Assertions.assertEquals("1", 1);
        //Assertions.assertTrue(false);
        //Assertions.assertFalse(false);
        //Assertions.assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
        //Assertions.assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 4});
        //Assertions.assertNull(null);

        //String s1 = "abc";
        //String s2 = "abc";
        //Assertions.assertSame(s1, s2);
        //s2 = new String("abc");
        //Assertions.assertSame(s1, s2);

        //Assertions.assertTimeout(Duration.ofSeconds(1), () -> Thread.sleep(500));
        //Assertions.assertTimeout(Duration.ofSeconds(1), () -> Thread.sleep(10000));

        //超时方法测试
        //Assertions.assertTimeoutPreemptively(Duration.of(1, ChronoUnit.SECONDS), () -> Thread.sleep(10000));

        //抓捕异常
        Assertions.assertThrows(IllegalArgumentException.class, () -> Integer.valueOf("String"));
    }

    @Test
    void groupAssertions() {
        int[] numbers = {0, 1, 2, 3, 4};
        Assertions.assertAll("numbers",
                () -> Assertions.assertEquals(numbers[1], 1),
                () -> Assertions.assertEquals(numbers[2], 2),
                () -> Assertions.assertEquals(numbers[3], 3),
                () -> Assertions.assertEquals(numbers[4], 4));
    }

}
