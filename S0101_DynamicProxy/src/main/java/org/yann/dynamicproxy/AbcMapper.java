package org.yann.dynamicproxy;

public class AbcMapper implements Mapper2 {
    @Override
    public void abc(String s) {
        System.out.println(s);
    }
}
