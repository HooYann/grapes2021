package org.yann.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TestNested {

    @Nested
    @DisplayName("嵌套1")
    class Nested01 {
        @Test
        void first() {
            System.out.println("first test");
        }

        @Test
        void first_01() {
            System.out.println("first test II");
        }
    }

    @Nested
    @DisplayName("嵌套2")
    class Nested02 {
        @Test
        void second() {
            System.out.println("second test");
        }
        @Test
        void second_01() {
            System.out.println("second test II");
        }
    }

}
