package org.yann.mybatis3.generator;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.yann.mybatis3.generator.simple.S0102User;
import org.yann.mybatis3.generator.simple.S0102UserMapper;

import java.io.IOException;
import java.io.InputStream;

public class TestSimple {

    static SqlSessionFactory sqlSessionFactory;
    static SqlSession sqlSession;

    @BeforeAll
    static void init() {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    void simple() {
        S0102UserMapper userMapper = sqlSession.getMapper(S0102UserMapper.class);
        S0102User s0102User = userMapper.selectByPrimaryKey(1L);
        Assertions.assertEquals("张三", s0102User.getName());
    }

}
