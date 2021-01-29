package org.yann.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestConstructor {

    @Test
    void nonParameter() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = Dog.class.getConstructor();
        Animal animal = (Animal) constructor.newInstance();
        System.out.println(animal);
    }

    @Test
    void hasParameter() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //Animal an = new Dog("旺财", 1, "土狗");

        //Constructor constructor = Dog.class.getConstructor(String.class, int.class, String.class);
        Constructor constructor = Dog.class.getDeclaredConstructor(String.class, int.class, String.class);
        constructor.setAccessible(true);
        Animal animal = (Animal)constructor.newInstance("旺财", 1, "土狗");
        System.out.println(animal);
    }

}
