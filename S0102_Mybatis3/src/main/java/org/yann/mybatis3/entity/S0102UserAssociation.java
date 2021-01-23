package org.yann.mybatis3.entity;

import lombok.Data;

@Data
public class S0102UserAssociation {

    private Long id;

    //private Long group_id;

    private String username;

    private String name;

    private S0102Group group;

}
