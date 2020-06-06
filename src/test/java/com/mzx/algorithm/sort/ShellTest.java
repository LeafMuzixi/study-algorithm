package com.mzx.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ShellTest {

    @Test
    void sort() {
        Integer[] arr = {4, 6, 8, 5, 7, 9, 2, 3, 1, 5};
        Shell.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}