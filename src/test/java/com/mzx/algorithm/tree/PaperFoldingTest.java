package com.mzx.algorithm.tree;

import com.google.common.base.Joiner;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class PaperFoldingTest {
    @Test
    public void paperFolding() {
        System.out.println(Joiner.on(",").join(paperFolding(3)));
    }

    private Queue<String> paperFolding(int n) {
        Node<String> root = null;
        Queue<Node<String>> nodeQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (root == null) {
                root = new Node<>("DOWN", null, null);
                nodeQueue.offer(root);
            } else {
                int size = nodeQueue.size();
                for (int j = 0; j < size; j++) {
                    Node<String> node = nodeQueue.poll();
                    assert node != null;
                    node.left = new Node<>("DOWN", null, null);
                    nodeQueue.offer(node.left);
                    node.right = new Node<>("UP", null, null);
                    nodeQueue.offer(node.right);
                }
            }
        }
        ArrayDeque<String> queue = new ArrayDeque<>();
        midErgodic(root, queue);
        return queue;
    }

    private void midErgodic(Node<String> node, Queue<String> queue) {
        if (node == null) {
            return;
        }
        midErgodic(node.left, queue);
        queue.offer(node.data);
        midErgodic(node.right, queue);
    }

    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
