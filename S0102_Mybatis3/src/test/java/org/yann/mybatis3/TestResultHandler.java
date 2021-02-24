package org.yann.mybatis3;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.result.DefaultResultHandler;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.yann.mybatis3.entity.S0102User;
import org.yann.mybatis3.mapper.S0102UserMapper;

import java.io.IOException;
import java.io.InputStream;

public class TestResultHandler {

    static SqlSessionFactory sqlSessionFactory = null;
    static SqlSession sqlSession;

    @BeforeAll
    static void init() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    void select() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        S0102UserMapper s0102UserMapper = sqlSession.getMapper(S0102UserMapper.class);
        S0102User s0102User = s0102UserMapper.selectUser(1L);
        System.out.println("======================");
        S0102User s0102User_1 = s0102UserMapper.selectUser(1L);
        System.out.println("======================");

        DefaultResultHandler resultHandler = new DefaultResultHandler();
        sqlSession.select("org.yann.mybatis3.mapper.S0102UserMapper.selectUser", 1L, resultHandler);
        System.out.println("======================");
        sqlSession.select("org.yann.mybatis3.mapper.S0102UserMapper.selectUser", 1L, resultHandler);
        System.out.println(resultHandler.getResultList());
    }

}
