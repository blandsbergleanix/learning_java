package net.leanix.bernhard.structure;

import java.util.ArrayList;
import java.util.List;

public class BBinaryTree {

    private Node root;

    public List<String> breadthFirst() {
        if (root == null) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        result.add(root.data);
        breadthFirstTraversal(root, result);
        return result;
    }

    private void breadthFirstTraversal(Node currentNode, List<String> alreadyVisited) {
        if (currentNode == null) {
            return; // Abbruch der Rekursion
        }

        // Add to list
        if (currentNode.left != null) {
            alreadyVisited.add(currentNode.left.data);
        }
        if (currentNode.right != null) {
            alreadyVisited.add(currentNode.right.data);
        }

        // Proceed with left/right subtree
        breadthFirstTraversal(currentNode.left, alreadyVisited);
        breadthFirstTraversal(currentNode.right, alreadyVisited);

    }

    public List<String> depthFirst() {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        depthFirstTraversal(root, result);
        return result;
    }

    private void depthFirstTraversal(Node currentNode, List<String> alreadyVisited) {
        if (currentNode == null) {
            return; // Abbruch der Rekursion
        }

        // Add to list
        alreadyVisited.add(currentNode.data);

        // Proceed with left/right subtree
        depthFirstTraversal(currentNode.left, alreadyVisited);
        depthFirstTraversal(currentNode.right, alreadyVisited);
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public static class Node {
        private String data;
        private Node left;
        private Node right;

        public Node(String data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data;
        }
    }
}
