package org.yann.reflect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGetClass {

    @Test
    void getClazz() throws ClassNotFoundException {
        //获取方法1
        Class clazz0 = Class.forName("org.yann.reflect.Dog");
        //获取方法2
        Class clazz1 = Dog.class;//.class方法更简单、更安全
        //获取方法3
        Dog dog = new Dog();
        Class clazz2 = dog.getClass();

        Assertions.assertSame(clazz0, clazz1);
        Assertions.assertEquals(clazz1, clazz2);

        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Assertions.assertEquals(dog1.getClass(), dog2.getClass());
    }

    @Test
    void getIntClazz() {
        Class clazz0 = Integer.TYPE;
        System.out.println(clazz0);
        Class clazz1 = Integer.class;
        System.out.println(clazz1);
        Assertions.assertEquals(clazz0, clazz1);
    }

}
