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
}