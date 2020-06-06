package com.mzx.algorithm.sort;

/**
 * 冒泡排序
 */
public class Bubble {
    /**
     * 对数组 arr 中的元素进行排序
     *
     * @param arr {@link T}
     * @param <T> {@link Comparable}
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                // 比较索引 j 和 j+1 处的值
                if (greater(arr[j], arr[j + 1])) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 比较 c1 元素是否大于 c2 元素
     *
     * @param c1  {@link T}
     * @param c2  {@link T}
     * @param <T> {@link Comparable}
     * @return true / false;
     */
    private static <T extends Comparable<T>> boolean greater(T c1, T c2) {
        return c1.compareTo(c2) > 0;
    }

    /**
     * 交换数组 i 和 j 位置的元素
     *
     * @param arr {@link T}
     * @param i   索引
     * @param j   索引
     * @param <T> {@link Comparable}
     */
    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        if (i == j) return;
        T temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
