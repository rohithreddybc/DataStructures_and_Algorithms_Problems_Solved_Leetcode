package com.rohith.leetcode.binarysearchtree;

public class Delete_Node_in_a_BST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        // Create a sample binary search tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        // Print the original tree
        System.out.println("Original Tree:");
        printInOrder(root);

        // Create an instance of Delete_Node_in_a_BST
        Delete_Node_in_a_BST solution = new Delete_Node_in_a_BST();

        // Delete a node (e.g., 3) from the BST
        int keyToDelete = 3;
        root = solution.deleteNode(root, keyToDelete);

        // Print the modified tree after deletion
        System.out.println("\nTree after deleting node with key " + keyToDelete + ":");
        printInOrder(root);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.val = minVal(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    public int minVal(TreeNode root) {
        int min = root.val;
        while (root.left != null) {
            min = root.left.val;
            root = root.left;
        }
        return min;
    }

    // Helper method to print the binary search tree in-order
    public static void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }
}
