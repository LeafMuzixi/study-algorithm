package com.mzx.algorithm.tree;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RedBlackTreeTest {
    private RedBlackTree<String, String> tree;

    @BeforeAll
    public void init() {
        this.tree = new RedBlackTree<>();
    }

    @Order(1)
    @Test
    public void put() {
        this.tree.put("1", "张三");
        this.tree.put("2", "李四");
        this.tree.put("3", "王五");
        this.tree.put("4", "赵六");
        this.tree.put("5", "田七");
    }

    @Order(2)
    @Test
    public void get() {
        assertEquals(this.tree.get("1"), "张三");
        assertEquals(this.tree.get("2"), "李四");
        assertEquals(this.tree.get("3"), "王五");
        assertEquals(this.tree.get("4"), "赵六");
        assertEquals(this.tree.get("5"), "田七");
    }
}