package org.yann.reflect.annotation;

@Table("s0104_user")
public class User {

    @Column(name = "_id", type = "int", length = 11)
    private int id;

    @Column(name = "_name", type = "varchar2", length = 50)
    private String name;

    @Column(name = "_sex", type = "char", length = 1)
    private String sex;

    @Column(name = "_id", type = "number", length = 13, precision = 2)
    private double balance;

}
