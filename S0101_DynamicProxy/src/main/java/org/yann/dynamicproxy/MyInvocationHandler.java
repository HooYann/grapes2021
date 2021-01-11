package org.yann.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * java.lang.reflect.InvocationHandler.invoke();
 *
 * java.lang.reflect.Proxy.newProxyInstance();
 *
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler() {}
    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    //动态代理对象
    public Object newProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //获取连接
        System.out.println("获取连接");

        method.invoke(target, args);

        //关闭资源
        System.out.println("关闭连接");

        return null;
    }

}
