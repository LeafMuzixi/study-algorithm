package com.mzx.algorithm.sort;

import org.junit.jupiter.api.Test;

public class TestComparable {
    @Test
    public void testComparable() {
        Student student1 = new Student();
        student1.setUsername("张三");
        student1.setAge(18);

        Student student2 = new Student();
        student2.setUsername("李四");
        student2.setAge(20);

        Comparable<Student> max = getMax(student1, student2);
        System.out.println(max);
    }

    private Student getMax(Student student1, Student student2) {
        int result = student1.compareTo(student2);
        if (result > 0) {
            return student1;
        } else {
            return student2;
        }
    }
}