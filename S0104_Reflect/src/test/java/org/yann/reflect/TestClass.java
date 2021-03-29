package org.yann.reflect;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {

    static Class clazz;

    @BeforeEach
    void getClazz() {
        try {
            clazz = Class.forName("org.yann.reflect.Dog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void clazzObj() throws ClassNotFoundException, NoSuchFieldException {
        System.out.println("clazz.getClassLoader()：" + clazz.getClassLoader());
        System.out.println("class: " + clazz);
        System.out.println();
        System.out.println("class.getName(): " + clazz.getName());
        System.out.println("clazz.getSimpleName(): " + clazz.getSimpleName());
        System.out.println("clazz.getModifiers(): " + Modifier.toString(clazz.getModifiers()));
        System.out.println("clazz.getInterfaces(): " + Arrays.toString(clazz.getInterfaces()));
        System.out.println("clazz.getSuperclass(): " + clazz.getSuperclass());
    }

    @Test
    void clazzField() throws NoSuchFieldException {
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declareField : declaredFields) {
            System.out.println(declareField);
        }
        Field[] superClsFields = clazz.getSuperclass().getDeclaredFields();
        for (Field superClsField : superClsFields) {
            System.out.println(superClsField);
            System.out.println(superClsField.getName() + "#" + superClsField.getType()
                    + "#" + Modifier.toString(superClsField.getModifiers()));
        }
        Field declaredField = clazz.getDeclaredField("type");
        System.out.println(declaredField);
        Field field = clazz.getSuperclass().getField("nickname");
        System.out.println(field);
    }

    @Test
    void clazzConstructor() throws NoSuchMethodException {
        Constructor constructor = clazz.getConstructor();
        System.out.println(constructor);
        constructor = clazz.getDeclaredConstructor();
        System.out.println(constructor);
        //constructor = clazz.getConstructor(String.class, int.class, String.class);
        //System.out.println(constructor);
        constructor = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        System.out.println(constructor);

        Constructor[] constructors = clazz.getConstructors();
        System.out.println(Arrays.toString(constructors));
        constructors = clazz.getDeclaredConstructors();
        System.out.println(Arrays.toString(constructors));
    }

    @Test
    void clazzMethod() {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName()+"#"+method.getReturnType()+"#"
                    +Arrays.toString(method.getParameters()));
        }
        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName()+"#"+declaredMethod.getReturnType()+"#"
                    +Arrays.toString(declaredMethod.getParameters()));
        }
    }

}
