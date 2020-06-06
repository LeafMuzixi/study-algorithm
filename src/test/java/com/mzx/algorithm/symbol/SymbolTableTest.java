package com.mzx.algorithm.symbol;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SymbolTableTest {
    private SymbolTable<Integer, String> table;

    @BeforeAll
    public void init() {
        table = new SymbolTable<>();
    }

    @Order(1)
    @Test
    void put() {
        this.table.put(1, "乔峰");
        this.table.put(2, "虚竹");
        this.table.put(3, "段誉");
        assertEquals(this.table.size(), 3);
        this.table.put(2, "慕容复");
        assertEquals(this.table.size(), 3);
    }

    @Order(2)
    @Test
    void get() {
        assertEquals(this.table.get(2), "慕容复");
        assertEquals(this.table.get(3), "段誉");
        assertNull(this.table.get(4));
    }

    @Order(3)
    @Test
    void remove() {
        assertEquals(this.table.remove(2), "慕容复");
        assertEquals(this.table.size(), 2);
    }
}