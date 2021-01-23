package org.yann.mybatis3.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.yann.mybatis3.entity.S0102User;
import org.yann.mybatis3.entity.S0102UserAssociation;

public interface S0102UserAssociationMapper {

    S0102UserAssociation association(Long id);
    S0102UserAssociation associationByStep(Long id);

    @Insert("insert into s0102_user(id, group_id, username, name) values(#{user.id}, #{user.group.id}, #{user.username}, #{user.name})")
    void insertAfterAssociation(@Param("user") S0102UserAssociation user);
}
