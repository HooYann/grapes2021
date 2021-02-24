package org.yann.mybatis3.mapper;

import org.apache.ibatis.annotations.SelectProvider;
import org.yann.mybatis3.entity.S0102User;

/**
 * public interface UserMapper {
 *
 *      @SelectProvider(type = SqlProvider.class, method = "selectById")
 *      User selectById(int id);
 *
 *      public static class SqlProvider {
 *        public static String selectById() {
 *          return "SELECT id, name FROM users WHERE id = #{id}";
 *        }
 *      }
 *
 *    }
 */

public interface S0102UserMapperForSelectProvider {

    @SelectProvider(type = S0102SqlProvider.class, method = "me")
    S0102User selectUserByProvider(Long id);

}


