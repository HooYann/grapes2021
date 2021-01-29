package org.yann.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMethod {

    @Test
    void method() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Dog.class;
        Object obj = clazz.getConstructor().newInstance();

        Method method0 = clazz.getSuperclass().getMethod("shout");
        method0.invoke(obj);

        Method method1 = clazz.getDeclaredMethod("guard");
        method1.setAccessible(true);
        method1.invoke(obj);

        //protected方法需要使用getDeclaredMethod()方法来获取，
        //但不需要setAccessible(true)获取权限后执行。
        Method method2 = clazz.getDeclaredMethod("setType", String.class);
        method2.invoke(obj, "土狗");

        Method method3 = clazz.getDeclaredMethod("add", int.class, int.class);
        method3.setAccessible(true);
        Object result = method3.invoke(obj, 1, 1);
        System.out.println(result);

    }
}
