package org.yann.mybatis3.generator;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mybatis.dynamic.sql.select.render.DefaultSelectStatementProvider;
import org.yann.mybatis3.generator.dynamicsql.S0102UserMapper;

import java.io.IOException;
import java.io.InputStream;

public class TestDynamicSql {
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

    /*@Test
    void dynamicSql() {
        S0102UserMapper userMapper = sqlSession.getMapper(S0102UserMapper.class);
        DefaultSelectStatementProvider.withSelectStatement()
        userMapper.count()
    }*/
}
