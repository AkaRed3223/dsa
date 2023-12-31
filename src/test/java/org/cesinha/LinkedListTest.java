package org.cesinha;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LinkedListTest {

    @Test
    @Order(1)
    public void testFindMiddleNode() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        assertEquals(3, linkedList.findMiddleNode().value);
    }

    @Test
    @Order(2)
    void testFindMiddleNodeEmptyList() {
        LinkedList linkedList = new LinkedList();
        assertNull(linkedList.findMiddleNode());
    }

    @Test
    @Order(3)
    void testFindMiddleNodeSingleNode() {
        LinkedList linkedList = new LinkedList(3);
        assertEquals(3, linkedList.findMiddleNode().value);
    }

    @Test
    @Order(4)
    void testHasLoopReturnTrueForListWithLoop() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        myList.getHead().next.next.next = myList.getHead().next;
        assertTrue(myList.hasLoop());
    }

    @Test
    @Order(5)
    void testHasLoopReturnFalseForListWithNoLoop() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        assertFalse(myList.hasLoop());
    }

    @Test
    @Order(6)
    void testHasLoopReturnFalseForEmptyList() {
        LinkedList myList = new LinkedList();
        assertFalse(myList.hasLoop());
    }

    @Test
    @Order(7)
    void testHasLoopReturnFalseForListWithOneNode() {
        LinkedList myList = new LinkedList(3);
        assertFalse(myList.hasLoop());
    }

    @Test
    @Order(8)
    void testFindKthFromEnd1() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        var result = myList.findKthFromEnd(2);
        assertEquals(4, result.value);
    }

    @Test
    @Order(9)
    void testFindKthFromEnd2() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        myList.append(6);
        var result = myList.findKthFromEnd(2);
        assertEquals(5, result.value);
    }

    @Test
    @Order(10)
    void testFindKthFromEnd3() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        assertNull(myList.findKthFromEnd(4));
    }

    @Test
    @Order(11)
    void testReverseBetweenEmptyList() {
        LinkedList myList = new LinkedList();
        myList.reverseBetween(1, 3);
        assertNull(myList.getHead());
        assertNull(myList.getTail());
        assertEquals(0, myList.getLength());
    }

    @Test
    @Order(12)
    void testReverseBetween1and3() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);

        myList.reverseBetween(1, 3);

        var nodeA = myList.getHead().next;
        var nodeB = myList.getHead().next.next.next;

        assertEquals(4, nodeA.value);
        assertEquals(2, nodeB.value);
    }

    @Test
    @Order(13)
    void testReverseBetween0and3() {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);

        myList.reverseBetween(0, 3);

        var nodeA = myList.getHead();
        var nodeB = myList.getHead().next.next.next;

        assertEquals(4, nodeA.value);
        assertEquals(1, nodeB.value);
    }
}