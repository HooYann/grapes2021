package org.yann.mybatis3.entity;

import lombok.Data;
import org.yann.mybatis3.handler.Color;

@Data
public class S0102Color {
    private Color v;

    public S0102Color(){}
    public S0102Color(Color v){
        this.v = v;
    }
}
