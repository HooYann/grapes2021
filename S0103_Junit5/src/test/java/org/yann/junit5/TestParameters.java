package org.yann.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestParameters {

    @ParameterizedTest
    @ValueSource(ints = {2, 4 ,8})
    void isEven(int n) {
        Assertions.assertEquals(0, n%2);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void isOdd(int n) {
        Assertions.assertEquals(1, n%2);
    }

    @ParameterizedTest
    @CsvSource({"1,zhangshan","2,lisi"})
    void csvData(Long id, String username) {
        System.out.println(id + username);
    }

}
