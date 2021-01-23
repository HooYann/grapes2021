package org.yann.mybatis3;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.yann.mybatis3.entity.S0102GroupCache;
import org.yann.mybatis3.mapper.S0102GroupCacheMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestCache1 {

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
    void doubleSelect() {
        S0102GroupCacheMapper mapper = sqlSession.getMapper(S0102GroupCacheMapper.class);
        List<S0102GroupCache> groups = mapper.selectGroups();
        System.out.println(groups);

        groups = mapper.selectGroups();
        System.out.println(groups);
    }

    @Test
    void doubleSelect2() {
        S0102GroupCacheMapper mapper = sqlSession.getMapper(S0102GroupCacheMapper.class);

        //sql1
        List<S0102GroupCache> groups = mapper.selectGroups();
        System.out.println(groups);

        //sql2
        S0102GroupCache group = mapper.selectGroup(11L);
        System.out.println(group);

        //sql1
        groups = mapper.selectGroups();
        System.out.println(groups);

        //sql2
        group = mapper.selectGroup(11L);
        System.out.println(group);
    }

    @Test
    void differentSqlSession() {
        //第一个SqlSession
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        S0102GroupCacheMapper mapper1 = sqlSession1.getMapper(S0102GroupCacheMapper.class);
        //sql1
        List<S0102GroupCache> groups1 = mapper1.selectGroups();
        System.out.println(groups1);

        //第二个SqlSession
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        S0102GroupCacheMapper mapper2 = sqlSession2.getMapper(S0102GroupCacheMapper.class);
        //sql1
        List<S0102GroupCache> groups2 = mapper2.selectGroups();
        System.out.println(groups2);

        groups1 = mapper1.selectGroups();
        System.out.println(groups1);
    }

    @Test
    void afterInsert() {
        S0102GroupCacheMapper mapper = sqlSession.getMapper(S0102GroupCacheMapper.class);
        List<S0102GroupCache> groups = mapper.selectGroups();
        System.out.println(groups);

        S0102GroupCache group = new S0102GroupCache();
        group.setId(101L);
        group.setName("JDBC");
        mapper.insert(group);

        groups = mapper.selectGroups();
        System.out.println(groups);

        mapper.delete(101L);
    }

}
