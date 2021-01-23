package org.yann.mybatis3;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.yann.mybatis3.entity.S0102Group;
import org.yann.mybatis3.entity.S0102User;
import org.yann.mybatis3.entity.S0102UserAssociation;
import org.yann.mybatis3.mapper.S0102GroupMapper;
import org.yann.mybatis3.mapper.S0102UserAssociationMapper;
import org.yann.mybatis3.mapper.S0102UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.security.acl.Group;

public class TestLazy {
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
    void lazy() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        S0102UserAssociationMapper s0102UserAssociationMapper = sqlSession.getMapper(S0102UserAssociationMapper.class);
        S0102UserAssociation user = s0102UserAssociationMapper.associationByStep(1L);
        System.out.println(user.getName());
        System.out.println(user.getGroup().getName());
    }

    @Test
    void insertAfterAssociation() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        S0102UserAssociationMapper s0102UserAssociationMapper = sqlSession.getMapper(S0102UserAssociationMapper.class);

        S0102UserAssociation x12 = new S0102UserAssociation();
        x12.setId(12L);
        x12.setUsername("xxx12");
        x12.setName("某某某12");

        S0102Group group = new S0102Group();
        group.setId(12L);
        x12.setGroup(group);

        s0102UserAssociationMapper.insertAfterAssociation(x12);

    }

    @Test
    void clearDirtyData() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        S0102UserMapper s0102UserMapper = sqlSession.getMapper(S0102UserMapper.class);
        s0102UserMapper.delete(12L);
        S0102User s0102User = s0102UserMapper.selectUser(12L);
        Assertions.assertNull(s0102User);
    }
}
