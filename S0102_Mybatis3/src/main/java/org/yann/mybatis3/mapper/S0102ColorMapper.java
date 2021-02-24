package org.yann.mybatis3.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.yann.mybatis3.entity.S0102Color;

import java.util.List;

public interface S0102ColorMapper {

    @Insert("insert into s0102_color(v) values (#{color.v, typeHandler=org.yann.mybatis3.handler.ColorTypeHandler})")
    int insertColor(@Param("color") S0102Color color);

    List<S0102Color> selectColors();
}
