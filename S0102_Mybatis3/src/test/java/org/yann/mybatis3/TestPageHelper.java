package org.yann.mybatis3;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.yann.mybatis3.entity.S0102User;
import org.yann.mybatis3.mapper.S0102UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestPageHelper {

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
    void test01() {
        S0102UserMapper userMapper = sqlSession.getMapper(S0102UserMapper.class);
        PageHelper.startPage(1, 10);
        List<S0102User> users = userMapper.selectUsers();
        System.out.println(users);
    }

    @Test
    void test02() {
        S0102UserMapper userMapper = sqlSession.getMapper(S0102UserMapper.class);
        PageHelper.startPage(1, 10);
        List<S0102User> users = userMapper.selectUsers();
        System.out.println(users);

        PageInfo pageInfo = new PageInfo(users);
        System.out.println(pageInfo.getTotal());
    }

}
