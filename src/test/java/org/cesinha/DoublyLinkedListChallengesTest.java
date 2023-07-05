package org.cesinha;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DoublyLinkedListChallengesTest {

    @Test
    @Order(1)
    void testSwapFirstLast() {
        var dll = new DoublyLinkedList(1);
        dll.append(2);
        dll.append(3);

        dll.swapFirstLast();

        assertEquals(3, dll.getHead().value);
        assertEquals(1, dll.getTail().value);
    }

    @Test
    @Order(2)
    void testReverse1() {
        var dll = new DoublyLinkedList(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        dll.append(6);
        dll.append(7);

        dll.reverse();

        assertEquals(7, dll.getHead().value);
        assertEquals(6, dll.getHead().next.value);
        assertEquals(5, dll.getHead().next.next.value);
        assertEquals(4, dll.getHead().next.next.next.value);
        assertEquals(3, dll.getHead().next.next.next.next.value);
        assertEquals(2, dll.getHead().next.next.next.next.next.value);
        assertEquals(1, dll.getTail().value);
        assertEquals(7, dll.getLength());
    }

    @Test
    @Order(3)
    void testReverse2() {
        var dll = new DoublyLinkedList(6);
        dll.append(13);
        dll.append(26);

        dll.reverse();

        assertEquals(26, dll.getHead().value);
        assertEquals(13, dll.getHead().next.value);
        assertEquals(6, dll.getTail().value);
        assertEquals(3, dll.getLength());
    }

    @Test
    @Order(4)
    void testReverseSingleNode() {
        var dll = new DoublyLinkedList(6);

        dll.reverse();

        assertEquals(6, dll.getHead().value);
        assertEquals(6, dll.getTail().value);
        assertEquals(1, dll.getLength());
    }

    @Test
    @Order(5)
    void testReverseEmptyList() {
        var dll = new DoublyLinkedList();

        dll.reverse();

        assertNull(dll.getHead());
        assertNull(dll.getTail());
        assertEquals(0, dll.getLength());
    }

    @Test
    @Order(6)
    void testReverseIsPalindromeTrue() {
        var dll = new DoublyLinkedList(1);
        dll.append(2);
        dll.append(3);
        dll.append(2);
        dll.append(1);

        assertTrue(dll.isPalindrome());
    }

    @Test
    @Order(7)
    void testReverseIsPalindromeFalse() {
        var dll = new DoublyLinkedList(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);

        assertFalse(dll.isPalindrome());
    }

    @Test
    @Order(8)
    void testReverseIsPalindromeSingleNode() {
        var dll = new DoublyLinkedList(1);
        assertTrue(dll.isPalindrome());
    }

    @Test
    @Order(9)
    void testReverseIsPalindromeEmptyList() {
        var dll = new DoublyLinkedList();
        assertTrue(dll.isPalindrome());
    }

    @Test
    @Order(10)
    void testSwapPairsEvenLength() {
        var dll = new DoublyLinkedList(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);

        dll.swapPairs();

        assertEquals(2, dll.getHead().value);
        assertEquals(1, dll.getHead().next.value);
        assertEquals(4, dll.getHead().next.next.value);
        assertEquals(3, dll.getHead().next.next.next.value);
        assertEquals(4, dll.getLength());
    }

    @Test
    @Order(11)
    void testSwapPairsOddLength() {
        var dll = new DoublyLinkedList(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);

        dll.swapPairs();

        assertEquals(2, dll.getHead().value);
        assertEquals(1, dll.getHead().next.value);
        assertEquals(4, dll.getHead().next.next.value);
        assertEquals(3, dll.getHead().next.next.next.value);
        assertEquals(5, dll.getHead().next.next.next.next.value);
        assertEquals(5, dll.getLength());
    }

    @Test
    @Order(12)
    void testSwapPairsSingleNode() {
        var dll = new DoublyLinkedList(3);

        dll.swapPairs();

        assertEquals(3, dll.getHead().value);
        assertEquals(1, dll.getLength());
    }

    @Test
    @Order(13)
    void testSwapPairsEmptyList() {
        var dll = new DoublyLinkedList();

        dll.swapPairs();

        assertNull(dll.getHead());
        assertEquals(0, dll.getLength());
    }
}