package com.mzx.algorithm.sort;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BubbleTest {

    @Test
    public void sort() {
        Integer[] arr = {4, 5, 6, 3, 2, 1};
        Bubble.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}