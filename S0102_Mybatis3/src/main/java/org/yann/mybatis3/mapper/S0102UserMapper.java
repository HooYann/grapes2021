package org.yann.mybatis3.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.yann.mybatis3.entity.S0102User;

import java.util.List;
import java.util.Map;

public interface S0102UserMapper {

    S0102User selectUser(Long id);

    @Select("select * from s0102_user where username = #{username}")
    S0102User selectUserByUsername(String username);

    @Insert("insert into s0102_user(id, username, name) values (#{user.id}, #{user.username}, #{user.name})")
    void insert(@Param("user") S0102User user);

    @Delete("delete from s0102_user where id = #{id}")
    void delete(Long id);

    Map<String, Object> hashMap(Long id);
    List<Map<String, Object>> hashMaps();

    List<Map<String, Object>> resultMap(Long id);

    List<S0102User> selectUsersByGroupId(Long groupId);


}
