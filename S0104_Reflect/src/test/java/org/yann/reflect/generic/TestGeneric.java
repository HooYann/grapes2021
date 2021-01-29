package org.yann.reflect.generic;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestGeneric {

    public void method1(Map<Integer, Student> map, List<Student> list, String str) {

    }

    public Map<Integer, Student> method2() {
        return null;
    }

    @Test
    void parameterizedTypeAndTypeVariable() throws NoSuchMethodException {
        Class clazz = TestGeneric.class;
        Method method1 = clazz.getMethod("method1", Map.class, List.class, String.class);

        //Class<?>[] parameterTypes = method1.getParameterTypes();
        //for (Class<?> parameterType : parameterTypes) {
        //    System.out.println(parameterType);
        //}

        Type[] genericParameterTypes = method1.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {

            //System.out.println(genericParameterType.getTypeName());
            if (genericParameterType instanceof  ParameterizedType) {
                //System.out.println(genericParameterType);
                ParameterizedType parameterizedType = (ParameterizedType)genericParameterType;
                //System.out.print("\tOwnerType：" + parameterizedType.getOwnerType());
                //System.out.print("\tRawType：" + parameterizedType.getRawType());
                //System.out.print("\tArguments：" + Arrays.toString(parameterizedType.getActualTypeArguments()));
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.print(actualTypeArgument);
                }
                System.out.println();
            }

        }
    }

    @Test
    void parameterizedTypeAndTypeVariable2() throws NoSuchMethodException {
        Class clazz = TestGeneric.class;
        Method method1 = clazz.getMethod("method2");

        //Class<?> returnType = method1.getReturnType();
        //System.out.println(returnType);

        Type genericReturnType = method1.getGenericReturnType();
        System.out.println(genericReturnType);

        ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
        for (Type actualTypeArgument : parameterizedType.getActualTypeArguments()) {
            System.out.println(actualTypeArgument);
        }
    }

    @Test
    void breakBorder() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list = new ArrayList<>();
        list.add("Reflect");
        list.add("Generic");
        //list.add(123);
        //list.add(true);
        //list.add(LocalDate.now());

        Class clazz = list.getClass();
        Method addMethod = clazz.getMethod("add", Object.class);
        addMethod.invoke(list, 123);
        addMethod.invoke(list, true);
        addMethod.invoke(list, LocalDate.now());
        System.out.println(list);
    }

}
