package com.mzx.algorithm.sort;

/**
 * 快速排序
 */
public class Quick {

    /**
     * 对数组 arr 中的元素进行排序
     *
     * @param arr {@link T}
     * @param <T> {@link Comparable}
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length);
    }

    /**
     * 对数组 arr 中从 low 到 high 的元素进行排序
     *
     * @param arr  {@link T}
     * @param low  起始索引
     * @param high 结束索引
     * @param <T>  {@link Comparable}
     */
    public static <T extends Comparable<T>> void sort(T[] arr, int low, int high) {
        // 安全校验
        if (low >= high - 1) return;
        // 需要对数组中 low 到 high 索引处的元素进行分组
        int partition = partition(arr, low, high);
        // 让左子组有序
        sort(arr, low, partition);
        // 让右子组有序
        sort(arr, partition + 1, high);
    }

    /**
     * 对数组 arr 中从索引 low 到 high 之间的元素进行分组，并返回分组界限的索引
     *
     * @param arr  {@link T}
     * @param low  起始索引
     * @param high 结束索引
     * @param <T>  {@link Comparable}
     * @return 分组界限的索引
     */
    public static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        // 确定分界值
        T t = arr[low];
        // 定义两个指针，分别指向待切分元素的最小索引处和最大索引处的下一个位置
        int leftIndex = low;
        int rightIndex = high;
        // 切分
        while (leftIndex < rightIndex) {
            // 从右往左扫描，找到一个比分界值小的元素，停止
            while (less(t, arr[--rightIndex])) {
                if (rightIndex == leftIndex) {
                    break;
                }
            }
            // 从左往右扫描，找到一个比分界值大的元素，停止
            while (less(arr[++leftIndex], t)) {
                if (leftIndex == rightIndex) {
                    break;
                }
            }
            if (leftIndex >= rightIndex) {
                break;
            } else {
                swap(arr, leftIndex, rightIndex);
            }
        }
        // 交换分界值
        swap(arr, low, rightIndex);
        return rightIndex;
    }

    /**
     * 比较 c1 元素是否大于 c2 元素
     *
     * @param c1  {@link T}
     * @param c2  {@link T}
     * @param <T> {@link Comparable}
     * @return true / false;
     */
    private static <T extends Comparable<T>> boolean less(T c1, T c2) {
        return c1.compareTo(c2) < 0;
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
