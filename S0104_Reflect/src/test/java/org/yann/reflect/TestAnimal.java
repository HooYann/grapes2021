package org.yann.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class TestAnimal {

    @Test
    void test01() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        String clazzName = "org.yann.reflect.Dog";
        Class clazz = Class.forName(clazzName);
        Object obj = clazz.getConstructor().newInstance();
        Animal animal1 = (Animal) obj;
        clazz.getField("nickname").set(animal1, "旺财");
        System.out.println(animal1.getNickname());

        clazz.getMethod("toString").invoke(animal1);
        System.out.println(animal1.toString());

        //Animal animal = (Animal) obj;
        //animal.setName("旺财");
        //System.out.println(animal.name);
    }

}