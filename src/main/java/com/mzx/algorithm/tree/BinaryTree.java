package com.mzx.algorithm.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二叉树
 *
 * @param <Key>
 * @param <Value>
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {
    /**
     * 根节点
     */
    private Node root;
    /**
     * 树中元素个数
     */
    private int N;

    /**
     * 节点类
     */
    private class Node {
        /**
         * 键
         */
        Key key;
        /**
         * 值
         */
        Value value;
        /**
         * 左子节点
         */
        Node left;
        /**
         * 右子节点
         */
        Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 树中元素个数
     *
     * @return 树大小
     */
    public int size() {
        return this.N;
    }

    /**
     * 添加键值对
     *
     * @param key   键
     * @param value 值
     */
    public void put(Key key, Value value) {
        this.root = put(this.root, key, value);
    }

    /**
     * 向指定的树 node 中插入键值对，并返回更新元素后的树
     *
     * @param node  树根节点
     * @param key   键
     * @param value 值
     * @return {@link Node}
     */
    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            this.N++;
            return new Node(key, value, null, null);
        }
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = put(node.left, key, value);
        } else if (compare > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    /**
     * 获取键值
     *
     * @param key 键
     * @return {@link Value}
     */
    public Value get(Key key) {
        return get(this.root, key);
    }

    /**
     * 获取指定的树 node 中的键值
     *
     * @param node 树根节点
     * @param key  键
     * @return {@link Value}
     */
    public Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            return get(node.left, key);
        } else if (compare > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    /**
     * 删除指定键值
     *
     * @param key 键
     */
    public void remove(Key key) {
        this.root = remove(this.root, key);
    }

    /**
     * 删除指定的树 node 中的键值
     *
     * @param node 树根节点
     * @param key  键
     * @return {@link Node}
     */
    private Node remove(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = remove(node.left, key);
        } else if (compare > 0) {
            node.right = remove(node.right, key);
        } else {
            N--;
            // 如果左子树为空，右子树上升
            if (node.left == null) {
                return node.right;
            }
            // 如果右子树为空，左子树上升
            if (node.right == null) {
                return node.left;
            }
            Node minNode = node.right;
            Node preNode = null;
            while (minNode.left != null) {
                preNode = minNode;
                minNode = minNode.left;
            }
            // 如果不是直接右节点
            if (preNode != null) {
                // 原父节点的左子树置为空
                preNode.left = null;
                minNode.right = node.right;
            }
            minNode.left = node.left;
            node = minNode;
        }
        return node;
    }

    /**
     * 查找树中最小键
     *
     * @return {@link Key}
     */
    public Key minKey() {
        return minKey(this.root);
    }


    /**
     * 查找树中最小键
     *
     * @param node 树根节点
     * @return {@link Key}
     */
    private Key minKey(Node node) {
        if (node == null) {
            return null;
        }
        Node temp = node;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp.key;
    }

    /**
     * 查找树中最大键
     *
     * @return {@link Key}
     */
    public Key maxKey() {
        return maxKey(this.root);
    }


    /**
     * 查找树中最大键
     *
     * @param node 树根节点
     * @return {@link Key}
     */
    private Key maxKey(Node node) {
        if (node == null) {
            return null;
        }
        Node temp = node;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp.key;
    }

    /**
     * 前序遍历获取所有键
     *
     * @return {@link Queue<Key>}
     */
    public Queue<Key> preErgodic() {
        Queue<Key> queue = new ArrayDeque<>();
        preErgodic(this.root, queue);
        return queue;
    }

    /**
     * 前序遍历获取指定树 node 下的所有键
     *
     * @param node  根节点
     * @param queue {@link Queue<Key>}
     */
    private void preErgodic(Node node, Queue<Key> queue) {
        if (node == null) {
            return;
        }
        queue.offer(node.key);
        preErgodic(node.left, queue);
        preErgodic(node.right, queue);
    }

    /**
     * 中序遍历获取所有键
     *
     * @return {@link Queue<Key>}
     */
    public Queue<Key> midErgodic() {
        Queue<Key> queue = new ArrayDeque<>();
        midErgodic(this.root, queue);
        return queue;
    }

    /**
     * 中序遍历获取指定树 node 下的所有键
     *
     * @param node  根节点
     * @param queue {@link Queue<Key>}
     */
    private void midErgodic(Node node, Queue<Key> queue) {
        if (node == null) {
            return;
        }
        midErgodic(node.left, queue);
        queue.offer(node.key);
        midErgodic(node.right, queue);
    }

    /**
     * 后序遍历获取所有键
     *
     * @return {@link Queue<Key>}
     */
    public Queue<Key> afterErgodic() {
        Queue<Key> queue = new ArrayDeque<>();
        afterErgodic(this.root, queue);
        return queue;
    }

    /**
     * 后序遍历获取指定树 node 下的所有键
     *
     * @param node  根节点
     * @param queue {@link Queue<Key>}
     */
    private void afterErgodic(Node node, Queue<Key> queue) {
        if (node == null) {
            return;
        }
        afterErgodic(node.left, queue);
        afterErgodic(node.right, queue);
        queue.offer(node.key);
    }

    /**
     * 层序遍历获取所有键
     *
     * @return {@link Queue<Key>}
     */
    public Queue<Key> layerErgodic() {
        Queue<Node> nodeQueue = new ArrayDeque<>();
        Queue<Key> queue = new ArrayDeque<>();
        if (this.root == null) {
            return queue;
        }
        nodeQueue.offer(this.root);
        layerErgodic(nodeQueue, queue);
        return queue;
    }

    /**
     * 层序遍历获取指定树 node 下的所有键
     *
     * @param nodeQueue {@link Queue<Node>}
     * @param queue     {@link Queue<Key>}
     */
    private void layerErgodic(Queue<Node> nodeQueue, Queue<Key> queue) {
        while (nodeQueue.size() > 0) {
            Node node = nodeQueue.poll();
            queue.offer(node.key);
            if (node.left != null) {
                nodeQueue.offer(node.left);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
            }
        }
    }

    /**
     * 获取最大深度
     *
     * @return 最大深度
     */
    public int maxDepth() {
        return maxDepth(this.root);
    }

    /**
     * 获取指定树 node 下的最大深度
     *
     * @param node 根节点
     * @return 指定树 node 的最大深度
     */
    private int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int maxLeft = maxDepth(node.left);
        int maxRight = maxDepth(node.right);
        return Math.max(maxLeft, maxRight) + 1;
    }
}
