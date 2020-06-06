package com.mzx.algorithm.priority;

import com.google.common.base.Joiner;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IndexMinPriorityQueueTest {
    private IndexMinPriorityQueue<String> queue;

    @BeforeAll
    public void init() {
        this.queue = new IndexMinPriorityQueue<>(4);
    }

    @Order(1)
    @Test
    void offer() {
        this.queue.offer("H");
        this.queue.offer("E");
        this.queue.offer("G");
        this.queue.offer("A");
        this.queue.offer("B");
        this.queue.offer("D");
        this.queue.offer("C");
        this.queue.offer("F");
    }

    @Order(2)
    @Test
    void insert() {
        this.queue.insert(0, "I");
        this.queue.insert(0, "J");
        this.queue.insert(0, "K");
    }

    @Order(3)
    @Test
    void poll() {
        List<String> list = new ArrayList<>();
        while (this.queue.size() > 0) {
            System.out.println(this.queue.minIndex());
            list.add(this.queue.poll());
        }
        System.out.println(Joiner.on(",").join(list));
    }
}