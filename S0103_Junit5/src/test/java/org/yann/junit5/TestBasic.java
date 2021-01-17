package org.yann.junit5;

import org.junit.jupiter.api.*;

/**
 * 简单使用
 * JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage
 *      JUnit Platform： 用于JVM上启动测试框架的基础服务，提供命令行，IDE和构建工具等方式执行测试的支持。
 *      JUnit Jupiter：包含 JUnit 5 新的编程模型和扩展模型，主要就是用于编写测试代码和扩展代码。
 *      JUnit Vintage：用于在JUnit 5 中兼容运行 JUnit3.x 和 JUnit4.x 的测试用例。
 *
 */
public class TestBasic {

    @BeforeAll
    static void init() {
        System.out.println("测试数据初始化");
    }

    @BeforeEach
    void tearUp() {
        System.out.println("调用每个测试方法前执行");
    }

    @Test
    void first() {
        System.out.println("first test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("调用每个测试方法后执行");
    }

    @Test
    @DisplayName("我不叫second()")
    void second() {
        System.out.println("second test");
    }

    @Test
    @Disabled
    void third() {
        System.out.println("third test");
    }

    @AfterAll
    static void close() {
        System.out.println("关闭资源");
    }

}
