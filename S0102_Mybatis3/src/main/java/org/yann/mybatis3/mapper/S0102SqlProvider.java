package org.yann.mybatis3.mapper;

public class S0102SqlProvider {
    public String me() {
        return "select * from s0102_user where id = #{id}";
    }
}