package com.mzx.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SelectionTest {

    @Test
    void sort() {
        Integer[] arr = {4, 6, 8, 5, 7, 9, 2, 10, 3, 1};
        Selection.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}