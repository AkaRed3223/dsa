package org.cesinha;

public class Stack {

    private Node top;
    private int height;

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Stack(int value) {
        top = new Node(value);
        height = 1;
    }

    public Stack() {
        top = null;
        height = 0;
    }

    public Node getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop() {
        if (height == 0) return null;

        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;

        return temp;
    }
}
