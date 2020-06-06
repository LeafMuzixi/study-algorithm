package com.mzx.algorithm.linear;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FastSlowTest {
    private Node<String> head;

    @BeforeAll
    public void initEach() {
        Node<String> node1 = new Node<>("张三", null);
        Node<String> node2 = new Node<>("李四", null);
        Node<String> node3 = new Node<>("王五", null);
        Node<String> node4 = new Node<>("赵六", null);
        Node<String> node5 = new Node<>("钱七", null);
        Node<String> node6 = new Node<>("孙八", null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        this.head = node1;
    }

    /**
     * 快慢指针获取中值
     */
    @Order(1)
    @Test
    public void mid() {
        String mid = getMid(this.head);
        System.out.println(mid);
    }

    /**
     * 获取链表的中间值
     *
     * @param node 头节点
     * @return 中间值
     */
    private <T> T getMid(Node<T> node) {
        // 定义两个指针
        Node<T> fast = node;
        Node<T> slow = node;
        // 使用两个指针遍历链表，当快指针指向的节点没有下一个节点了，慢指针指向的就是中间值
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast == null) {
                break;
            }
            slow = slow.next;
        }
        return slow.data;
    }

    /**
     * 检测环
     */
    @Order(2)
    @Test
    public void circle() {
        this.head.next.next.next.next.next.next = this.head.next.next.next;
        System.out.println(isCircle(this.head));
    }

    /**
     * 判断链表中是否有环
     *
     * @param node 头节点
     * @param <T>  {@link T}
     * @return true / false;
     */
    private <T> boolean isCircle(Node<T> node) {
        // 定义两个指针
        Node<T> fast = node;
        Node<T> slow = node;
        // 使用两个指针遍历链表，如果快慢指针指向了同一个节点，证明有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast == null) {
                break;
            }
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取环入口
     */
    @Order(3)
    @Test
    public void entrance() {
        System.out.println(getEntrance(this.head).data);
    }

    /**
     * 获取链表环入口
     *
     * @param node 头节点
     * @param <T>  {@link T}
     * @return {@link Node<T>}
     */
    private <T> Node<T> getEntrance(Node<T> node) {
        // 定义两个指针
        Node<T> fast = node;
        Node<T> slow = node;
        Node<T> temp = null;
        // 使用两个指针遍历链表，如果快慢指针指向了同一个节点，证明有环
        while (fast.next != null && slow.next != null) {
            fast = fast.next.next;
            if (fast.next == null) {
                break;
            }
            slow = slow.next;
            if (fast == slow && temp == null) {
                temp = node;
                continue;
            }
            // 移动临时指针
            if (temp != null) {
                temp = temp.next;
                // 判断临时指针是否和慢指针相遇
                if (temp == slow) {
                    break;
                }
            }
        }
        return temp;
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
