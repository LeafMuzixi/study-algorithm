package com.mzx.algorithm.heap;

import com.google.common.base.Joiner;
import com.mzx.algorithm.tree.BinaryTree;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HeapTest {

    private Heap<String> heap;

    @BeforeAll
    public void init() {
        this.heap = new Heap<>();
    }

    @Order(1)
    @Test
    void add() {
        this.heap.add("A");
        this.heap.add("B");
        this.heap.add("C");
        this.heap.add("D");
        this.heap.add("E");
        this.heap.add("F");
        this.heap.add("G");
        this.heap.add("H");
    }

    @Test
    void removeMax() {
        List<String> list = new ArrayList<>();
        while (this.heap.size() > 0) {
            list.add(this.heap.removeMax());
        }
        System.out.println(Joiner.on(",").join(list));
    }
}