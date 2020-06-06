package com.mzx.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickTest {

    @Test
    void sort() {
        Integer[] arr = {4, 6, 8, 5, 7, 2, 3, 1, 5};
        Quick.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}