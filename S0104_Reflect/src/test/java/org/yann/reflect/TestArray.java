package org.yann.reflect;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestArray {

    @Test
    void arrayClass() {
        int[] array = new int[10];
        Class clazz = array.getClass();
        System.out.println(clazz);//[I 代表int类型数组
        Class componentClazz = clazz.getComponentType();
        System.out.println(componentClazz);//拿到数组的元素类型
    }

    /**
     * 正常
     */
    @Test
    void listClass() {
        List list1 = new ArrayList();
        Class clazz1 = list1.getClass();
        System.out.println(clazz1);
        System.out.println(clazz1.getComponentType());
        System.out.println();

        List list2 = new ArrayList();
        list2.add(1);
        list2.add(2);
        Class clazz2 = list2.getClass();
        System.out.println(clazz2);
        System.out.println(clazz2.getComponentType());
        System.out.println();

        List<Integer> list3 = new ArrayList<Integer>();
        Class clazz3 = list3.getClass();
        System.out.println(clazz3);
        System.out.println(clazz3.getComponentType());
        System.out.println();

        ArrayList<Integer> list4 = new ArrayList<Integer>();
        Class clazz4 = list4.getClass();
        System.out.println(clazz4);
        System.out.println(clazz4.getComponentType());
    }

}
