package com.mzx.algorithm.heap;

import com.mzx.algorithm.sort.Merge;
import com.mzx.algorithm.sort.Quick;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class HeapSortTest {

    @Test
    void sort() {
        Integer[] arr = {4, 6, 8, 5, 7, 9, 11, 2, 12, 10, 3, 1};
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    void time() {
        Integer[] original = new Integer[10000000];
        for (int i = 0; i < original.length; i++) {
            original[i] = (int) (Math.random() * 10000000);
        }
        Integer[] arr = Arrays.copyOf(original, original.length);
        long start = System.currentTimeMillis();
        HeapSort.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("堆排序: " + (end - start) + "ms");

        arr = Arrays.copyOf(original, original.length);
        start = System.currentTimeMillis();
        Quick.sort(arr);
        end = System.currentTimeMillis();
        System.out.println("快速排序: " + (end - start) + "ms");

        arr = Arrays.copyOf(original, original.length);
        start = System.currentTimeMillis();
        Merge.sort(arr);
        end = System.currentTimeMillis();
        System.out.println("归并排序: " + (end - start) + "ms");

        arr = Arrays.copyOf(original, original.length);
        start = System.currentTimeMillis();
        Arrays.sort(arr);
        end = System.currentTimeMillis();
        System.out.println("Arrays.sort 排序: " + (end - start) + "ms");
    }
}