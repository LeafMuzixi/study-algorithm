package com.mzx.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class InsertionTest {

    @Test
    void sort() {
        Integer[] arr = {4, 6, 8, 5, 7, 9, 11, 2, 12, 10, 3, 1};
        Insertion.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}