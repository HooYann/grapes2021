package org.yann.reflect.annotation;

import org.junit.jupiter.api.Test;

public class TestAnnotation {

    @Test
    void deprecated() {
        Student student = new Student();
        student.method1();
        student.method2();
    }

    @Test
    void suppressWarnings() {
    }
}
