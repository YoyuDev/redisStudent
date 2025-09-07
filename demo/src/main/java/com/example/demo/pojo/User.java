package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;



public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    // 无参构造函数
    public User() {
    }

    // 带参构造函数
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 必须提供公共的getter和setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
