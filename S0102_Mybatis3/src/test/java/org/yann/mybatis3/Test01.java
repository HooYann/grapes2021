package org.yann.mybatis3;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.yann.mybatis3.entity.S0102User;
import org.yann.mybatis3.mapper.S0102UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Test01 {

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
    void select01() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            S0102User s0102User = session.selectOne(
                    "org.yann.mybatis3.mapper.S0102UserMapper.selectUser", 1L);
            System.out.println(s0102User.getName());
        }
    }

    @Test
    void select0101() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<S0102User> s0102UserList = session.selectList(
                    "org.yann.mybatis3.mapper.S0102UserMapper.selectUsers", null);
            System.out.println(s0102UserList);
        }

    }

    @Test
    void select02() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        S0102UserMapper s0102UserMapper = sqlSession.getMapper(S0102UserMapper.class);
        S0102User s0102User = s0102UserMapper.selectUser(1L);

        s0102User = s0102UserMapper.selectUserByUsername("lisi");
        System.out.println(s0102User);

    }

    @Test
    void insert() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        S0102UserMapper s0102UserMapper = sqlSession.getMapper(S0102UserMapper.class);

        S0102User x = new S0102User();
        x.setId(11L);
        x.setUsername("xxx");
        x.setName("某某某");
        s0102UserMapper.insert(x);

        S0102User s0102User = s0102UserMapper.selectUser(11L);
        System.out.println(s0102User.getName());
    }

    @Test
    void clearDirtyData() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        S0102UserMapper s0102UserMapper = sqlSession.getMapper(S0102UserMapper.class);
        s0102UserMapper.delete(11L);
        S0102User s0102User = s0102UserMapper.selectUser(11L);
        Assertions.assertNull(s0102User);
    }

}
