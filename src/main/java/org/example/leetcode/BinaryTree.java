package org.example.leetcode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
    Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    /**
     * returns the maximum depth of the tree. If it has just
     * the root, then return 0 for the height. If it is null tree, return -1.
     * This version is the BFS version. It seems more intuitive than the DFS.
     * @return
     */
    public int maxHeightBFS() {
        int retval = -1;

        if (root == null)
            return retval;

        Deque<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            retval++;

            // we need all nodes to be polled from queue
            // it is count as one more level
            List<Node> toAdd = new ArrayList<>();
            while (queue.size() > 0) {
                Node node = queue.poll();
                if (node.left != null) {
                    toAdd.add(node.left);
                }
                if (node.right != null) {
                    toAdd.add(node.right);
                }
            }

            queue.addAll(toAdd);

        }

        return retval;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}