package org.yann.dynamicproxy;

import org.yann.dynamicproxy.util.ProxyClassFileUtil;

public class Test {

    public static void main(String[] args) {

        UserMapper userMapper = new UserMapper();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(userMapper);
        Mapper1 mapper1 = (Mapper1)myInvocationHandler.newProxyInstance();
        mapper1.operate();

        System.out.println("============");

        AbcMapper abcMapper = new AbcMapper();
        myInvocationHandler = new MyInvocationHandler(abcMapper);
        Mapper2 mapper2 = (Mapper2)myInvocationHandler.newProxyInstance();
        mapper2.abc("abc");

        ProxyClassFileUtil.createFile("$Proxy1", AbcMapper.class.getInterfaces());

    }

}
