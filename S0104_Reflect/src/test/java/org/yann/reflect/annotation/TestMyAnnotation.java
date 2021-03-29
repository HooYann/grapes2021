package org.yann.reflect.annotation;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

public class TestMyAnnotation {

    @Test
    void orm() throws NoSuchFieldException {
        Class clazz = User.class;
        for (Annotation annotation : clazz.getAnnotations()) {
            System.out.println(annotation);
            Table table = (Table) annotation;
            System.out.println(table.value());
        }
        System.out.println();

        for (Annotation idAnnotation : clazz.getDeclaredField("id").getAnnotations()) {
            System.out.println(idAnnotation);
            Column column = (Column) idAnnotation;
            System.out.println(column.name());
        }
    }

}
