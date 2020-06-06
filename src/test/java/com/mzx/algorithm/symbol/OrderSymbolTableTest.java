package com.mzx.algorithm.symbol;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderSymbolTableTest {
    private OrderSymbolTable<Integer, String> table;

    @BeforeAll
    public void init() {
        table = new OrderSymbolTable<>();
    }

    @Order(1)
    @Test
    void put() {
        this.table.put(1, "张三");
        this.table.put(2, "李四");
        this.table.put(4, "赵六");
        this.table.put(17, "钱七");

        this.table.put(3, "王五");
    }

    @Order(2)
    @Test
    void get() {
        assertEquals(this.table.get(2), "李四");
        assertEquals(this.table.get(3), "王五");
        assertNull(this.table.get(5));
    }

    @Order(3)
    @Test
    void remove() {
        assertEquals(this.table.remove(2), "李四");
        assertEquals(this.table.size(), 4);
    }
}