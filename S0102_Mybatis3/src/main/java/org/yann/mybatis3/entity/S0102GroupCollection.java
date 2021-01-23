package org.yann.mybatis3.entity;

import lombok.Data;

import java.util.Collection;

@Data
public class S0102GroupCollection {

    private Long id;

    private String name;

    private Collection<S0102User> users;

}
