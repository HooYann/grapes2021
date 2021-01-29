package org.yann.reflect;

import lombok.Data;

import java.io.Serializable;

@Data
public final class Dog extends Animal implements Serializable, Cloneable {

    private String type;

    public Dog() {
        System.out.println("I am a dog");
    }
    private Dog(String nickname, int age, String type) {
        super(nickname, age);
        this.type = type;
        System.out.println("I am a dog, nickname=" + nickname + ", age=" + age + ", type=" + type);
    }

    String getType() {
        return this.getType();
    }
    protected void setType(String type) {
        System.out.println("type=" + type);
        this.type = type;
    }

    @Override
    public void eat() {
        System.out.println("===Dog eat()===");
    }

    private void guard() {
        System.out.println("请出示狗牌");
    }

    private int add(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public String toString() {
        return "Dog{nickname=" + nickname + ",age=" + age + ",type=" + type + "}";
    }
}
