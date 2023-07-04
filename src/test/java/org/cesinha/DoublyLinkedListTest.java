package org.cesinha;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DoublyLinkedListTest {

    @Test
    @Order(1)
    void testConstructor() {
        DoublyLinkedList dll = new DoublyLinkedList(2);
        var head = dll.getHead();
        var tail = dll.getTail();
        var length = dll.getLength();
        assertNotNull(head);
        assertNull(head.prev);
        assertNotNull(tail);
        assertNull(tail.next);
        assertEquals(1, length);
        assertEquals(2, head.value);
    }

    @Test
    @Order(2)
    void testConstructorEmpty() {
        DoublyLinkedList dll = new DoublyLinkedList();
        assertNull(dll.getHead());
        assertNull(dll.getTail());
        assertEquals(0, dll.getLength());
    }

    @Test
    @Order(3)
    void testAppend1() {
        DoublyLinkedList dll = new DoublyLinkedList(1);
        dll.append(2);
        var head = dll.getHead();
        var tail = dll.getTail();
        var length = dll.getLength();
        
        assertEquals(1, head.value);
        assertEquals(2, tail.value);
        assertEquals(2, length);
    }

    @Test
    @Order(4)
    void testAppend2() {
        DoublyLinkedList dll = new DoublyLinkedList(1);
        dll.append(2);
        dll.append(5);
        var head = dll.getHead();
        var tail = dll.getTail();
        var length = dll.getLength();

        assertNull(head.prev);
        assertEquals(1, head.value);
        assertEquals(5, tail.value);
        assertEquals(2, tail.prev.value);
        assertEquals(3, length);
    }

    @Test
    @Order(5)
    void testAppendEmptyList() {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.append(1);
        var head = dll.getHead();
        var tail = dll.getTail();
        var length = dll.getLength();

        assertEquals(1, head.value);
        assertEquals(1, tail.value);
        assertEquals(1, length);
    }

    @Test
    @Order(6)
    void testRemoveLast() {
        var dll = new DoublyLinkedList(1);
        dll.append(2);
        dll.append(3);
        dll.removeLast();

        assertEquals(1, dll.getHead().value);
        assertEquals(2, dll.getTail().value);
        assertEquals(2, dll.getLength());
        assertNull(dll.getTail().next);
        assertNotNull(dll.getTail().prev);
    }

    @Test
    @Order(7)
    void testRemoveLastSingleNode() {
        var dll = new DoublyLinkedList(1);
        var node = dll.removeLast();
        assertEquals(1, node.value);
        assertNull(node.prev);
        assertNull(node.next);
        assertNull(dll.getTail());
        assertNull(dll.getHead());
        assertEquals(0, dll.getLength());
    }

    @Test
    @Order(8)
    void testRemoveLastEmptyList() {
        var dll = new DoublyLinkedList();
        assertNull(dll.getTail());
        assertNull(dll.getHead());
        assertEquals(0, dll.getLength());
    }

    @Test
    @Order(9)
    void testPrepend() {
        var dll = new DoublyLinkedList(11);
        dll.append(3);
        dll.append(23);
        dll.append(7);

        dll.prepend(4);

        var head = dll.getHead();
        var length = dll.getLength();

        assertEquals(5, length);
        assertEquals(4, head.value);
        assertEquals(11, head.next.value);
        assertEquals(4, head.next.prev.value);
    }

    @Test
    @Order(10)
    void testPrependEmptyList() {
        var dll = new DoublyLinkedList();
        dll.prepend(4);

        assertEquals(4, dll.getHead().value);
        assertEquals(4, dll.getTail().value);
        assertNull(dll.getHead().next);
        assertNull(dll.getHead().prev);
        assertNull(dll.getTail().next);
        assertNull(dll.getTail().prev);
    }
}