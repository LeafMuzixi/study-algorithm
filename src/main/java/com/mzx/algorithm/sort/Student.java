package com.mzx.algorithm.sort;

import org.jetbrains.annotations.NotNull;

/**
 * 定义一个学生类 Student，具有年龄 age 和姓名 username 两个属性，并通过 comparable 接口提供比较规则；
 */
public class Student implements Comparable<Student> {
    /**
     * 姓名
     */
    private String username;
    /**
     * 年龄
     */
    private int age;

    @Override
    public int compareTo(@NotNull Student o) {
        return this.getAge() - o.getAge();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
