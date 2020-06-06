package com.mzx.algorithm.linear;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TwoWayLinkedListTest {
    private TwoWayLinkedList<String> list;

    @BeforeAll
    public void init() {
        this.list = new TwoWayLinkedList<>();
    }

    @Order(1)
    @Test
    public void insert() {
        assertTrue(this.list.isEmpty());
        this.list.insert("张三");
        assertEquals(this.list.length(), 1);
        this.list.insert("李四");
        assertEquals(this.list.length(), 2);
        this.list.insert("王五");
        assertEquals(this.list.length(), 3);
        this.list.insert("赵六");
        assertEquals(this.list.length(), 4);
        this.list.insert(2, "钱七");
        assertEquals(this.list.length(), 5);
        assertFalse(this.list.isEmpty());
        this.list.forEach(System.out::println);
    }

    @Order(2)
    @Test
    public void get() {
        assertEquals(this.list.get(0), "张三");
        assertEquals(this.list.get(1), "李四");
        assertEquals(this.list.get(2), "钱七");
        assertEquals(this.list.get(3), "王五");
        assertEquals(this.list.get(4), "赵六");
        assertEquals(this.list.getFirst(), "张三");
        assertEquals(this.list.getLast(), "赵六");
    }

    @Order(3)
    @Test
    public void indexOf() {
        assertEquals(this.list.indexOf("李四"), 1);
        assertEquals(this.list.indexOf("赵六"), 4);
    }

    @Order(4)
    @Test
    public void remove() {
        assertEquals(this.list.remove(0), "张三");
        assertEquals(this.list.length(), 4);
        assertEquals(this.list.get(0), "李四");
    }

    @Order(5)
    @Test
    public void clear() {
        this.list.clear();
        assertEquals(this.list.length(), 0);
        assertTrue(this.list.isEmpty());
    }
}