package org.yann.dynamicproxy;

public class UserMapper implements Mapper1 {
    public void operate() {
        //获取连接
        //System.out.println("获取连接");
        //业务逻辑
        System.out.println("operate user");
        //关闭连接
        //System.out.println("关闭连接");
    }
}
