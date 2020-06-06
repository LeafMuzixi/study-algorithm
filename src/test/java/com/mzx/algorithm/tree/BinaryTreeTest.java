package com.mzx.algorithm.tree;

import com.google.common.base.Joiner;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BinaryTreeTest {
    private BinaryTree<String, String> tree;

    @BeforeAll
    public void init() {
        this.tree = new BinaryTree<>();
    }

    @Order(1)
    @Test
    public void put() {
        this.tree.put("E", "5");
        this.tree.put("B", "2");
        this.tree.put("G", "7");
        this.tree.put("A", "1");
        this.tree.put("D", "4");
        this.tree.put("F", "6");
        this.tree.put("H", "8");
        this.tree.put("C", "3");
        assertEquals(this.tree.size(), 8);
    }

    @Order(2)
    @Test
    public void get() {
        assertEquals(this.tree.get("A"), "1");
        assertEquals(this.tree.get("B"), "2");
        assertEquals(this.tree.get("C"), "3");
        assertEquals(this.tree.get("D"), "4");
    }

    @Order(3)
    @Test
    public void key() {
        assertEquals(this.tree.minKey(), "A");
        assertEquals(this.tree.maxKey(), "H");
    }

    @Order(4)
    @Test
    public void preErgodic() {
        System.out.println(Joiner.on("-").join(this.tree.preErgodic()));
    }

    @Order(5)
    @Test
    public void midErgodic() {
        System.out.println(Joiner.on("-").join(this.tree.midErgodic()));
    }

    @Order(6)
    @Test
    public void afterErgodic() {
        System.out.println(Joiner.on("-").join(this.tree.afterErgodic()));
    }

    @Order(7)
    @Test
    public void layerErgodic() {
        System.out.println(Joiner.on("-").join(this.tree.layerErgodic()));
    }

    @Order(8)
    @Test
    public void maxDepth() {
        assertEquals(this.tree.maxDepth(), 4);
    }

    @Order(10)
    @Test
    public void remove() {
        this.tree.remove("E");
        assertNull(this.tree.get("E"));
        assertEquals(this.tree.size(), 7);
        this.tree.remove("B");
        assertNull(this.tree.get("B"));
        assertEquals(this.tree.size(), 6);
        this.tree.remove("C");
        assertNull(this.tree.get("C"));
        assertEquals(this.tree.size(), 5);
        this.tree.remove("A");
        assertNull(this.tree.get("A"));
        assertEquals(this.tree.size(), 4);
    }
}