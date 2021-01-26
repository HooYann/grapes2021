package org.yann.mybatis3.generator.simple;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.yann.mybatis3.generator.simple.S0102User;

public interface S0102UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table S0102_USER
     *
     * @mbg.generated Sun Jan 24 20:32:36 CST 2021
     */
    @Delete({
        "delete from S0102_USER",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table S0102_USER
     *
     * @mbg.generated Sun Jan 24 20:32:36 CST 2021
     */
    @Insert({
        "insert into S0102_USER (ID, GROUP_ID, ",
        "USERNAME, NAME)",
        "values (#{id,jdbcType=BIGINT}, #{groupId,jdbcType=BIGINT}, ",
        "#{username,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR})"
    })
    int insert(S0102User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table S0102_USER
     *
     * @mbg.generated Sun Jan 24 20:32:36 CST 2021
     */
    @Select({
        "select",
        "ID, GROUP_ID, USERNAME, NAME",
        "from S0102_USER",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="GROUP_ID", property="groupId", jdbcType=JdbcType.BIGINT),
        @Result(column="USERNAME", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR)
    })
    S0102User selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table S0102_USER
     *
     * @mbg.generated Sun Jan 24 20:32:36 CST 2021
     */
    @Select({
        "select",
        "ID, GROUP_ID, USERNAME, NAME",
        "from S0102_USER"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="GROUP_ID", property="groupId", jdbcType=JdbcType.BIGINT),
        @Result(column="USERNAME", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<S0102User> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table S0102_USER
     *
     * @mbg.generated Sun Jan 24 20:32:36 CST 2021
     */
    @Update({
        "update S0102_USER",
        "set GROUP_ID = #{groupId,jdbcType=BIGINT},",
          "USERNAME = #{username,jdbcType=VARCHAR},",
          "NAME = #{name,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(S0102User record);
}