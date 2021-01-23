package org.yann.mybatis3.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.yann.mybatis3.entity.S0102UserCache;

public interface S0102UserCacheMapper {

    void insert(@Param("u")S0102UserCache u);

    @Delete("delete from s0102_user where id = #{id}")
    void delete(Long id);
}
