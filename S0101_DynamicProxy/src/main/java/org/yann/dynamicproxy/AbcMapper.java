package org.yann.dynamicproxy;

public class AbcMapper implements Mapper2, Mapper3 {
    @Override
    public void abc() {
        System.out.println("abc");
    }

    @Override
    public void abc2(String s) {
        System.out.println(s);
    }

    @Override
    public void efg() {
        System.out.println("efg");
    }
}
