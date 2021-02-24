package org.yann.mybatis3;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.yann.mybatis3.entity.S0102Color;
import org.yann.mybatis3.handler.Color;
import org.yann.mybatis3.mapper.S0102ColorMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.yann.mybatis3.handler.Color.*;

public class TestColorTypeHandler {

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
    void valueOf() {
        Color color = Color.valueOf("RED");
        System.out.println(color.getValue());
    }

    @Test
    void insertRed() {
        S0102ColorMapper mapper = sqlSession.getMapper(S0102ColorMapper.class);
        int i = mapper.insertColor(new S0102Color(RED));
        System.out.println(i);
    }

    @Test
    void insertGreen() {
        S0102ColorMapper mapper = sqlSession.getMapper(S0102ColorMapper.class);
        int i = mapper.insertColor(new S0102Color(GREEN));
        System.out.println(i);
    }

    @Test
    void insertBlue() {
        S0102ColorMapper mapper = sqlSession.getMapper(S0102ColorMapper.class);
        int i = mapper.insertColor(new S0102Color(BLUE));
        System.out.println(i);
    }


    @Test
    void selectList() {
        S0102ColorMapper mapper = sqlSession.getMapper(S0102ColorMapper.class);
        List<S0102Color> list = mapper.selectColors();
        System.out.println(list);
    }


}
