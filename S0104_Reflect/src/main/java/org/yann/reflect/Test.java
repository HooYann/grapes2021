package org.yann.reflect;

import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String clazzName = "org.yann.reflect.Dog";
        Class clazz = Class.forName(clazzName);
        Object obj = clazz.getConstructor().newInstance();
        Animal animal1 = (Animal) obj;
        clazz.getField("name").set(animal1, "旺财");
        System.out.println(animal1.getNickname());

        clazz.getMethod("setName").invoke(animal1, "旺财2");
        System.out.println(animal1.getNickname());

        //Animal animal = (Animal) obj;
        //animal.setName("旺财");
        //System.out.println(animal.name);
    }

}
