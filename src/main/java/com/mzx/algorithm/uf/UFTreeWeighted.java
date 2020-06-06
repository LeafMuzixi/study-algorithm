package com.mzx.algorithm.uf;

import java.util.Arrays;

/**
 * 并查集
 */
public class UFTreeWeighted {
    /**
     * 记录节点及所在分组的标识
     */
    private int[] elementAndGroup;
    /**
     * 记录每一个根节点对应的树中保存的节点个数
     */
    private int[] size;
    /**
     * 分组个数
     */
    private int count;

    /**
     * 构造方法
     *
     * @param n 数组大小
     */
    public UFTreeWeighted(int n) {
        // 初始化分组，默认有 n 个分组
        this.count = n;
        // 初始化数组
        this.elementAndGroup = new int[n];
        this.size = new int[n];
        // 初始化元素及其索引所在标识符，让 elementAndGroup 数组中的索引作为并查集的每个节点的元素，并且让每个索引处的值（该元素所在的组的标识符）就是该索引
        for (int i = 0; i < this.elementAndGroup.length; i++) {
            this.elementAndGroup[i] = i;
        }
        Arrays.fill(this.size, 1);
    }

    /**
     * 获取并查集中分组个数
     *
     * @return 分组个数
     */
    public int count() {
        return this.count;
    }

    /**
     * 查询元素所在分组的标识符
     *
     * @param data 元素
     * @return 元素所在分组标识符
     */
    public int find(int data) {
        while (data != this.elementAndGroup[data]) {
            data = this.elementAndGroup[data];
        }
        return data;
    }

    /**
     * 判断两元素是否在同一分组中
     *
     * @param data1 元素1
     * @param data2 元素2
     * @return true / false;
     */
    public boolean connected(int data1, int data2) {
        return find(data1) == find(data2);
    }

    /**
     * 合并两元素所在分组
     *
     * @param data1 元素1
     * @param data2 元素2
     */
    public void union(int data1, int data2) {
        int group1 = find(data1);
        int group2 = find(data2);
        if (group1 == group2) {
            return;
        }
        if (this.size[group1] < this.size[group2]) {
            this.elementAndGroup[group1] = group2;
            this.size[group1] += this.size[group2];
        } else {
            this.elementAndGroup[group2] = group1;
            this.size[group2] = this.size[group1];
        }
        this.count--;
    }
}
