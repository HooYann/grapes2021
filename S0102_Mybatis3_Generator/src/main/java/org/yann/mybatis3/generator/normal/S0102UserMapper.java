package org.yann.mybatis3.generator.normal;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.yann.mybatis3.generator.normal.S0102User;
import org.yann.mybatis3.generator.normal.S0102UserExample;

public interface S0102UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table S0102_USER
     *
     * @mbg.generated Sun Jan 24 20:48:44 CST 2021
     */
    long countByExample(S0102UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table S0102_USER
     *
     * @mbg.generated Sun Jan 24 20:48:44 CST 2021
     */
    int deleteByExample(S0102UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table S0102_USER
     *
     * @mbg.generated Sun Jan 24 20:48:44 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table S0102_USER
     *
     * @mbg.generated Sun Jan 24 20:48:44 CST 2021
     */
    int insert(S0102User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table S0102_USER
     *
     * @mbg.generated Sun Jan 24 20:48:44 CST 2021
     */
    int insertSelective(S0102User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table S0102_USER
     *
     * @mbg.generated Sun Jan 24 20:48:44 CST 2021
     */
    List<S0102User> selectByExample(S0102UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table S0102_USER
     *
     * @mbg.generated Sun Jan 24 20:48:44 CST 2021
     */
    S0102User selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table S0102_USER
     *
     * @mbg.generated Sun Jan 24 20:48:44 CST 2021
     */
    int updateByExampleSelective(@Param("record") S0102User record, @Param("example") S0102UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table S0102_USER
     *
     * @mbg.generated Sun Jan 24 20:48:44 CST 2021
     */
    int updateByExample(@Param("record") S0102User record, @Param("example") S0102UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table S0102_USER
     *
     * @mbg.generated Sun Jan 24 20:48:45 CST 2021
     */
    int updateByPrimaryKeySelective(S0102User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table S0102_USER
     *
     * @mbg.generated Sun Jan 24 20:48:45 CST 2021
     */
    int updateByPrimaryKey(S0102User record);
}