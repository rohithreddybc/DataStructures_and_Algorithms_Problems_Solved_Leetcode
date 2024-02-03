package com.rohith.leetcode.binarysearchtree;

public class Search_in_a_Binary_Search_Tree {
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

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;

        if (root.val > val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }

    public static void main(String[] args) {
        // Create a sample binary search tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // Create an instance of Search_in_a_Binary_Search_Tree
        Search_in_a_Binary_Search_Tree solution = new Search_in_a_Binary_Search_Tree();

        // Search for a node with value 2 in the BST
        int targetValue = 2;
        TreeNode result = solution.searchBST(root, targetValue);

        // Print the result
        if (result != null) {
            System.out.println("Node with value " + targetValue + " found in the BST.");
        } else {
            System.out.println("Node with value " + targetValue + " not found in the BST.");
        }
    }
}
