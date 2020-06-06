package com.mzx.algorithm.priority;

import com.google.common.base.Joiner;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MaxPriorityQueueTest {
    private MaxPriorityQueue<String> queue;

    @BeforeAll
    public void init() {
        this.queue = new MaxPriorityQueue<>();
    }

    @Order(1)
    @Test
    void offer() {
        this.queue.offer("A");
        this.queue.offer("B");
        this.queue.offer("C");
        this.queue.offer("D");
        this.queue.offer("E");
        this.queue.offer("F");
        this.queue.offer("G");
        this.queue.offer("H");
    }

    @Order(2)
    @Test
    void poll() {
        List<String> list = new ArrayList<>();
        while (this.queue.size() > 0) {
            list.add(this.queue.poll());
        }
        System.out.println(Joiner.on(",").join(list));
    }
}