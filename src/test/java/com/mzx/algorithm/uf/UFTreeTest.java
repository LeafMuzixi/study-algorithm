package com.mzx.algorithm.uf;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UFTreeTest {
    private UFTree uf;

    @BeforeAll
    public void init() {
        this.uf = new UFTree(5);
    }

    @Order(1)
    @Test
    public void union() {
        assertEquals(this.uf.count(), 5);
        this.uf.union(1, 4);
        assertEquals(this.uf.count(), 4);
        this.uf.union(2, 3);
        assertEquals(this.uf.count(), 3);
        this.uf.union(1, 2);
        assertEquals(this.uf.count(), 2);
        this.uf.union(0, 4);
        assertEquals(this.uf.count(), 1);
    }
}