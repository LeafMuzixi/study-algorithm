package com.mzx.algorithm.linear;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class QueueTest {
    private Queue<String> queue;

    @BeforeAll
    public void init() {
        queue = new Queue<>();
    }

    @Order(1)
    @Test
    public void offer() {
        this.queue.offer("a");
        this.queue.offer("b");
        this.queue.offer("c");
        this.queue.offer("d");
        this.queue.forEach(System.out::println);
    }

    @Order(2)
    @Test
    public void poll() {
        assertEquals(this.queue.poll(), "a");
        assertEquals(this.queue.poll(), "b");
        assertEquals(this.queue.poll(), "c");
        assertEquals(this.queue.poll(), "d");
        assertNull(this.queue.poll());
    }
}