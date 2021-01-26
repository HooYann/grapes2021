package org.yann.mybatis3;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.yann.mybatis3.entity.S0102UserAssociation;
import org.yann.mybatis3.mapper.S0102UserAssociationMapper;

import java.io.IOException;
import java.io.InputStream;

public class TestAssociation {

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
    void association() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        S0102UserAssociationMapper s0102UserAssociationMapper = sqlSession.getMapper(S0102UserAssociationMapper.class);
        S0102UserAssociation user = s0102UserAssociationMapper.association(1L);
        System.out.println(user);
    }
    @Test
    void associationByStep() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        S0102UserAssociationMapper s0102UserAssociationMapper = sqlSession.getMapper(S0102UserAssociationMapper.class);
        S0102UserAssociation user = s0102UserAssociationMapper.associationByStep(1L);
        System.out.println(user);
    }


}
