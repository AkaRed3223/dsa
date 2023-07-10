package org.cesinha;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BinarySearchTreeTest {

    @Test
    @Order(1)
    void testConstructor() {
        var bst = new BinarySearchTree();
        assertNull(bst.root);
    }

    @Test
    @Order(2)
    void testInsert() {
        var bst = new BinarySearchTree();
        bst.insert(41);
        bst.insert(35);
        bst.insert(45);
        bst.insert(34);
        bst.insert(36);
        bst.insert(44);
        bst.insert(46);
        assertEquals(41, bst.root.value);
        assertEquals(35, bst.root.left.value);
        assertEquals(45, bst.root.right.value);
        assertEquals(34, bst.root.left.left.value);
        assertEquals(36, bst.root.left.right.value);
        assertEquals(44, bst.root.right.left.value);
        assertEquals(46, bst.root.right.right.value);
    }

    @Test
    @Order(3)
    void testInsertEmptyBST() {
        var bst = new BinarySearchTree();
        bst.insert(41);
        assertEquals(41, bst.root.value);
        assertNull(bst.root.left);
        assertNull(bst.root.right);
    }

    @Test
    @Order(4)
    void testInsertDuplicate() {
        var bst = new BinarySearchTree();
        bst.insert(41);
        bst.insert(35);
        bst.insert(45);
        bst.insert(45);

        assertEquals(41, bst.root.value);
        assertEquals(35, bst.root.left.value);
        assertEquals(45, bst.root.right.value);
        assertNull(bst.root.right.left);
        assertNull(bst.root.right.right);
    }

    @Test
    @Order(5)
    void testGet() {
        var bst = new BinarySearchTree();
        bst.insert(41);
        bst.insert(35);
        bst.insert(45);
        bst.insert(34);
        bst.insert(36);
        bst.insert(44);
        bst.insert(46);

        assertTrue(bst.contains(34));
        assertTrue(bst.contains(44));
        assertFalse(bst.contains(99));
        assertFalse(bst.contains(47));
    }

    @Test
    @Order(6)
    void testGetEmptyTree() {
        var bst = new BinarySearchTree();
        assertFalse(bst.contains(99));
    }
}