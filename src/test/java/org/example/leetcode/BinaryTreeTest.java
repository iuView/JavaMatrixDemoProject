package org.example.leetcode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeTest {

    static BinaryTree tree = null;

    @BeforeAll
    static void pre() {
        generateTestData();
    }

    private static void generateTestData() {
        Node leaf1 = new Node(1);
        Node node2 = new Node(2, leaf1, null);
        Node leaf4 = new Node(4);
        Node leaf7 = new Node(7);
        Node node6 = new Node(6, null, leaf7);
        Node node5 = new Node(5, leaf4, node6);
        Node root = new Node(3, node2, node5);
        tree = new BinaryTree(root);
    }

    @Test
    void maxHeight() {
        int h = tree.maxHeightBFS();
        assertThat(h).isEqualTo(3);
    }


}