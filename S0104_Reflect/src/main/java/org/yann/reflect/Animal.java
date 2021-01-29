package org.yann.reflect;

import lombok.Data;

@Data
public abstract class Animal {

    public String nickname;
    int age;

    public Animal() {

    }
    public Animal(String nickname, int age) {
        this.nickname = nickname;
        this.age = age;
    }

    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void shout() {
        System.out.println("===shout===");
    }
    public void shout(String str) {
        System.out.println("===shout===" + str);
    }
    public void shout(String str, int num) {
        System.out.println("===shout===" + str + "  " + num);
    }

    public abstract void eat();

    @Override
    public String toString() {
        return "Animal{nickname=" + nickname + ",age=" + age + "}";
    }

}
