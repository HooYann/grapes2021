package org.yann.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class TestField {

    @Test
    void field() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Dog.class;
        Object obj = clazz.getConstructor().newInstance();
        Field field = clazz.getDeclaredField("type");
        field.setAccessible(true);
        field.set(obj, "土狗");
        System.out.println(field.get(obj));
    }

}
