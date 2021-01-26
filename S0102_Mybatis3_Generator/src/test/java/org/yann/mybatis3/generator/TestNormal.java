package org.yann.mybatis3.generator;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.yann.mybatis3.generator.normal.S0102UserExample;
import org.yann.mybatis3.generator.normal.S0102UserMapper;

import java.io.IOException;
import java.io.InputStream;

public class TestNormal {

    static SqlSessionFactory sqlSessionFactory;
    static SqlSession sqlSession;

    @BeforeAll
    static void init(){
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch(IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    void normal() {
        S0102UserMapper userMapper = sqlSession.getMapper(S0102UserMapper.class);
        S0102UserExample example = new S0102UserExample();
        example.createCriteria().andIdGreaterThan(0L);
        long count = userMapper.countByExample(example);
        Assertions.assertTrue(count > 0);
    }

}
