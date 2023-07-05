package org.cesinha;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class QueueTest {

    @Test
    @Order(1)
    void testConstructor() {
        var queue = new Queue(3);
        assertNotNull(queue);
        assertEquals(3, queue.getFirst().value);
        assertEquals(3, queue.getLast().value);
        assertEquals(1, queue.getLength());
    }

    @Test
    @Order(2)
    void testConstructorEmpty() {
        var queue = new Queue();
        assertNotNull(queue);
        assertNull(queue.getFirst());
        assertNull(queue.getLast());
        assertEquals(0, queue.getLength());
    }

    @Test
    @Order(3)
    void testEnqueue() {
        var queue = new Queue(11);

        queue.enqueue(3);

        assertEquals(11, queue.getFirst().value);
        assertEquals(3, queue.getLast().value);
        assertEquals(2, queue.getLength());
    }

    @Test
    @Order(4)
    void testEnqueueEmptyQueue() {
        var queue = new Queue();

        queue.enqueue(11);

        assertEquals(11, queue.getFirst().value);
        assertEquals(11, queue.getLast().value);
        assertEquals(1, queue.getLength());
    }

    @Test
    @Order(5)
    void testDequeue() {
        var queue = new Queue(11);
        queue.enqueue(3);
        queue.enqueue(23);
        queue.enqueue(7);

        var removedNode = queue.dequeue();

        assertEquals(11, removedNode.value);
        assertEquals(3, queue.getLength());
        assertEquals(3, queue.getFirst().value);
        assertEquals(7, queue.getLast().value);
    }

    @Test
    @Order(6)
    void testDequeueSingleNode() {
        var queue = new Queue(11);

        var removedNode = queue.dequeue();

        assertEquals(11, removedNode.value);
        assertEquals(0, queue.getLength());
        assertNull(queue.getFirst());
        assertNull(queue.getLast());
    }

    @Test
    @Order(7)
    void testDequeueEmptyQueue() {
        var queue = new Queue();

        var removedNode = queue.dequeue();

        assertEquals(0, queue.getLength());
        assertNull(removedNode);
        assertNull(queue.getFirst());
        assertNull(queue.getLast());
    }
}