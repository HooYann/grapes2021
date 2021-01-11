package org.yann.staticproxy;

public class Test {

    public static void main(String[] args) {


        StaticProxy  staticProxy = new StaticProxy();

        UserMapper userMapper = new UserMapper();
        staticProxy.enhance(userMapper);

        System.out.println("==========");

        AdminMapper adminMapper = new AdminMapper();
        staticProxy.enhance(adminMapper);

    }

}
