package com.mzx.algorithm.sort;

/**
 * 选择排序
 */
public class Selection {
    /**
     * 对数组 arr 中的元素进行排序
     *
     * @param arr {@link T}
     * @param <T> {@link Comparable}
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i; j < arr.length; j++) {
                // 找出最小值的索引
                if (greater(arr[minIndex], arr[j])) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
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
