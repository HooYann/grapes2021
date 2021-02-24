package org.yann.mybatis3;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.yann.mybatis3.entity.S0102User;
import org.yann.mybatis3.mapper.S0102UserMapper;
import org.yann.mybatis3.mapper.S0102UserMapperForSelectProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestSelectProvider {

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
    void selectProvider() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        S0102UserMapperForSelectProvider s0102UserMapper = sqlSession.getMapper(S0102UserMapperForSelectProvider.class);
        S0102User s0102User = s0102UserMapper.selectUserByProvider(1L);
        System.out.println(s0102User);
    }

}
