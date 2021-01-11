package org.yann.staticproxy;

/**
 * 静态代理解决了一部分重复编码的成本，但不够灵活，必须指定接口、指定方法。
 * 遇到新的接口、新的方法又得写一个新的静态代理
 */
public class StaticProxy {

    public void enhance(Mapper mapper) {

        //获取连接
        System.out.println("获取连接");
        //执行业务逻辑
        mapper.operate();
        //关闭资源
        System.out.println("关闭连接");

    }

}
