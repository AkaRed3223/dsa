package org.cesinha;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StackTest {

    @Test
    @Order(1)
    void testConstructor() {
        var stack = new Stack(3);

        assertNotNull(stack);
        assertEquals(1, stack.getHeight());
        assertEquals(3, stack.getTop().value);
        assertNull(stack.getTop().next);
    }

    @Test
    @Order(2)
    void testConstructorEmpty() {
        var emptyStack = new Stack();

        assertNull(emptyStack.getTop());
        assertEquals(0, emptyStack.getHeight());
    }

    @Test
    @Order(3)
    void testPush() {
        var stack = new Stack(2);

        stack.push(1);

        assertEquals(1, stack.getTop().value);
        assertEquals(2, stack.getTop().next.value);
        assertEquals(2, stack.getHeight());
    }

    @Test
    @Order(4)
    void testPushEmpty() {
        var emptyStack = new Stack();

        emptyStack.push(7);

        assertNotNull(emptyStack.getTop());
        assertEquals(7, emptyStack.getTop().value);
        assertEquals(1, emptyStack.getHeight());
    }

    @Test
    @Order(5)
    void testPop() {
        var stack = new Stack(7);
        stack.push(23);
        stack.push(3);
        stack.push(11);

        var node = stack.pop();

        assertNotNull(node);
        assertEquals(11, node.value);
        assertEquals(3, stack.getHeight());
    }

    @Test
    @Order(6)
    void testPopEmpty() {
        var emptyStack = new Stack();

        var node = emptyStack.pop();

        assertNull(node);
        assertNull(emptyStack.getTop());
        assertEquals(0, emptyStack.getHeight());
    }



}