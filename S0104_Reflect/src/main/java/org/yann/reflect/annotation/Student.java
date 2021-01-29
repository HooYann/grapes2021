package org.yann.reflect.annotation;

import java.io.Serializable;
import java.util.Date;

//@SuppressWarnings({"deprecation", "unchecked", "failthrough", "path", "serial"})
//@SuppressWarnings(value = "all")
public class Student implements Comparable<Integer>, Serializable {

    @Override
    public int compareTo(Integer i) {
        return i>0 ? i: 0;
    }
    //@Override
    public int compareTo1(Integer i) {
        return i>0 ? i: 0;
    }
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void method1() {
    }

    @SuppressWarnings(value = "deprecation")
    public void method2() {
        Date date = new Date();
        date.toLocaleString();
    }

}
