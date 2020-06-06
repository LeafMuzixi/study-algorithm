package com.mzx.algorithm.linear;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StackTest {
    private Stack<String> stack;

    @BeforeAll
    public void init() {
        this.stack = new Stack<>();
    }

    @Order(1)
    @Test
    public void push() {
        assertTrue(this.stack.isEmpty());
        this.stack.push("a");
        this.stack.push("b");
        this.stack.push("c");
        this.stack.push("d");
        this.stack.push("e");
        assertEquals(this.stack.size(), 5);
        this.stack.forEach(System.out::println);
    }

    @Order(2)
    @Test
    public void pop() {
        assertEquals(this.stack.pop(), "e");
        assertEquals(this.stack.pop(), "d");
        assertEquals(this.stack.pop(), "c");
        assertEquals(this.stack.pop(), "b");
        assertEquals(this.stack.pop(), "a");
    }
}