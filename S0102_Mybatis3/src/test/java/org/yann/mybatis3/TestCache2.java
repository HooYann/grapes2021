package org.yann.mybatis3;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.yann.mybatis3.entity.S0102GroupCache;
import org.yann.mybatis3.entity.S0102UserCache;
import org.yann.mybatis3.mapper.S0102GroupCacheMapper;
import org.yann.mybatis3.mapper.S0102UserCacheMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * 1、从MappedStatement难道Cache对象
 * 2、把Cache对象作为Key通过TransactionalCacheManager拿二级缓存
 * 3、如果没有就把Cache通过TransactionalCacheManager暂时存进TransactionalCache的
 * entriesToAddOnCommit属性中
 *
 * 其中TransactionalCacheManager维护者一个TransactionalCache的Map
 *
 * 4、SqlSession.commit()方法会调用CachingExecutor.commit()方法
 * CachingExecutor.commit()方法会调用TransactionalCacheManager.commit()方法
 * TransactionalCacheManager.commit()会调用TransactionalCache.commit()方法
 * TransactionalCache.commit()方法会调用TransactionCache.flushPendingEntries()方法
 * TransactionCache.flushPendingEntries()方法会将entriesToAddOnCommit的缓存正式存入缓存中。
 */

public class TestCache2 {

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
    void cache2() {
        //第一个SqlSession
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        S0102GroupCacheMapper mapper1 = sqlSession1.getMapper(S0102GroupCacheMapper.class);
        //sql1
        List<S0102GroupCache> groups1 = mapper1.selectGroups();
        System.out.println(groups1);
        sqlSession1.commit();

        //第二个SqlSession
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        S0102GroupCacheMapper mapper2 = sqlSession2.getMapper(S0102GroupCacheMapper.class);
        //sql1
        List<S0102GroupCache> groups2 = mapper2.selectGroups();
        System.out.println(groups2);
    }

    @Test
    void cache2AfterInsert() {
        S0102GroupCacheMapper mapper = sqlSession.getMapper(S0102GroupCacheMapper.class);
        List<S0102GroupCache> groups = mapper.selectGroups();
        System.out.println(groups);
        sqlSession.commit();

        S0102GroupCache group = new S0102GroupCache();
        group.setId(102L);
        group.setName("SpringMVC");
        mapper.insert(group);
        sqlSession.commit();
        //如果不主动调用sqlSession.commit()
        // 此时TransactionalCache.clearOnCommit=true，标记将要提交，但并没有完成提交动作，缓存还在。
        // 所以LoggingCache.requests和hits的计数还是缓存时的数据计数。
        // 只有当sqlSession.close()执行时才会完成提交动作。

        groups = mapper.selectGroups();
        System.out.println(groups);

        mapper.delete(102L);
        sqlSession.commit();
    }

    @Test
    void cache2Ref() {
        S0102GroupCacheMapper mapper = sqlSession.getMapper(S0102GroupCacheMapper.class);
        List<S0102UserCache> users = mapper.selectUsersByGroupId(11L);
        System.out.println(users);
        sqlSession.commit();

        S0102UserCacheMapper userCacheMapper = sqlSession.getMapper(S0102UserCacheMapper.class);
        S0102UserCache u = new S0102UserCache();
        u.setId(13L);
        u.setGroupId(11L);
        u.setUsername("huyitian");
        u.setName("胡一天");
        userCacheMapper.insert(u);
        sqlSession.commit();

        users = mapper.selectUsersByGroupId(11L);
        System.out.println(users);

        userCacheMapper.delete(13L);
        sqlSession.commit();
    }

    @Test
    void cache2ReadOnly() {
        S0102GroupCacheMapper mapper = sqlSession.getMapper(S0102GroupCacheMapper.class);
        S0102GroupCache group = mapper.selectGroup(11L);
        System.out.println(group.getName());
        sqlSession.commit();

        group.setName("替换");

        group = mapper.selectGroup(11L);
        System.out.println(group.getName());
    }

}
