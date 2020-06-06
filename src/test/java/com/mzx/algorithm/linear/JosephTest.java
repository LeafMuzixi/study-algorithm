package com.mzx.algorithm.linear;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JosephTest {
    private Node<Integer> head;

    @BeforeEach
    public void initEach() {
        head = new Node<>(1, null);
        Node<Integer> temp = head;
        Node<Integer> last = head;
        for (int i = 2; i <= 41; i++) {
            temp.next = new Node<>(i, null);
            last = temp.next;
            temp = temp.next;
        }
        last.next = head;
    }

    /**
     * 解决约瑟夫环问题
     */
    @Test
    public void joseph() {
        int count = 0;
        // 记录每次遍历的上一个节点
        Node<Integer> pre = null;
        // 记录每次遍历的节点，默认从头节点开始
        Node<Integer> current = head;

        while (current != current.next) {
            // 模拟报数
            count++;
            // 判断当前报数是否为 3
            if (count == 3) {
                // 删除当前节点
                assert pre != null;
                pre.next = current.next;
                System.out.print(current.data+",");
                count = 0;
            } else {
                pre = current;
            }
            current = current.next;
        }

        System.out.println(current.data);
    }

    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
