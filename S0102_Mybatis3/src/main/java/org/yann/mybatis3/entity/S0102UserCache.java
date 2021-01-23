package org.yann.mybatis3.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class S0102UserCache implements Serializable {

    private static final long UID = 1L;

    private Long id;

    private Long groupId;

    private String username;

    private String name;

}
