package org.cesinha;

public class BinarySearchTree {

    Node root;

    static class Node {
        int value;
        Node left;
        Node right;

        private Node(int value) {
            this.value = value;
        }
    }
}
