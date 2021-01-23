package org.yann.mybatis3;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.yann.mybatis3.entity.S0102Group;
import org.yann.mybatis3.entity.S0102GroupCollection;
import org.yann.mybatis3.entity.S0102User;
import org.yann.mybatis3.mapper.S0102GroupCollectionMapper;
import org.yann.mybatis3.mapper.S0102GroupMapper;
import org.yann.mybatis3.mapper.S0102UserMapper;

import java.io.IOException;
import java.io.InputStream;

public class TestCollection {

    static SqlSessionFactory sqlSessionFactory = null;

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
    }

    @Test
    void collection() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        S0102GroupCollectionMapper s0102GroupCollectionMapper = sqlSession.getMapper(S0102GroupCollectionMapper.class);
        S0102GroupCollection group = s0102GroupCollectionMapper.collection(11L);
        System.out.println(group);
    }
    @Test
    void collectionByStep() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        S0102GroupCollectionMapper s0102GroupCollectionMapper = sqlSession.getMapper(S0102GroupCollectionMapper.class);
        S0102GroupCollection group = s0102GroupCollectionMapper.collectionByStep(12L);
        System.out.println(group);
    }


}
