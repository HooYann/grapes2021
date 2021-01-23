package org.yann.mybatis3.mapper;

import org.apache.ibatis.annotations.*;
import org.yann.mybatis3.entity.S0102GroupCache;
import org.yann.mybatis3.entity.S0102UserCache;

import java.util.List;

public interface S0102GroupCacheMapper {

    List<S0102GroupCache> selectGroups();

    S0102GroupCache selectGroup(Long id);

    //@Insert("insert into s0102_group (id, name) values (#{g.id}, #{g.name})")
    void insert(@Param("g") S0102GroupCache group);

    @Delete("delete from s0102_group where id = #{id}")
    void delete(long l);

    List<S0102UserCache> selectUsersByGroupId(Long id);
}
