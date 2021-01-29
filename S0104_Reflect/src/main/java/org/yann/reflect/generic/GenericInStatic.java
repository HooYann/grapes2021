package org.yann.reflect.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericInStatic {

    public static<T> void method0() {
        System.out.println("method0");
    }

    public static<T> void method1(T t) {
        System.out.println(t);
    }

    //public static<T> T method2() {
    //    return "method2";
    //}

    public static<T> T method3(T t) {
        return t;
    }

    public static<T> List<T> method4() {
        System.out.println("method4");
        return new ArrayList<>();
    }

    public static<T> List<T> method5(T t) {
        System.out.print("method5\t\t");
        List<T> list = new ArrayList<>();
        list.add(t);
        return list;
    }

    //public static<T> List<T> method6(String s) {
    //    List<T> list = new ArrayList<>();
    //    list.add(s);
    //    return list;
    //}

    public static<T> void method7(List<T> list) {
        System.out.println("method7");
    }

    public static<T, A, B, C> void method8() {
        System.out.println("method8");
    }

    public static<T, A, B, C> A method9(String s) {
        System.out.println(s);
        return null;
    }

    public static<T, A, B, C> B method10(B b) {
        return b;
    }

    public static void main(String[] args) {
        method0();
        method1("method1");
        //System.out.println(method2());
        System.out.println(method3("method3"));
        method4();

        List list = method5(true);
        list.add("123");
        System.out.println(list);

        method8();
        method9("method9");
        System.out.println(method10("method10"));

    }

}
