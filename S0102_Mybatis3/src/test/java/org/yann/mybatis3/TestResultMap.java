package org.yann.mybatis3;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.yann.mybatis3.mapper.S0102UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class TestResultMap {

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
    void hashMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        S0102UserMapper s0102UserMapper = sqlSession.getMapper(S0102UserMapper.class);
        Map<String, Object> data = s0102UserMapper.hashMap(1L);
        System.out.println(data);
    }
    @Test
    void hashMaps() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        S0102UserMapper s0102UserMapper = sqlSession.getMapper(S0102UserMapper.class);
        List<Map<String, Object>> datas = s0102UserMapper.hashMaps();
        System.out.println(datas.get(0));
    }

    @Test
    void resultMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        S0102UserMapper s0102UserMapper = sqlSession.getMapper(S0102UserMapper.class);
        Map<String, Object> data = s0102UserMapper.resultMap(1L).get(0);
        System.out.println(data);
    }
    @Test
    void resultMaps() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        S0102UserMapper s0102UserMapper = sqlSession.getMapper(S0102UserMapper.class);
        List<Map<String, Object>> datas = s0102UserMapper.resultMap(null);
        System.out.println(datas.get(0));
    }


}
