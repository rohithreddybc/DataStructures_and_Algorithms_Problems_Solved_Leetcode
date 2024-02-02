package com.rohith.leetcode.binarytree_DFS;

public class Lowest_Common_Ancestor_of_a_BinaryTree {

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;  // This is the lowest common ancestor
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        // Instantiate a binary tree based on the provided input
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Nodes to find the lowest common ancestor
        TreeNode p = root.left;
        TreeNode q = root.left.right.right;

        // Call the lowestCommonAncestor method and print the result
        Lowest_Common_Ancestor_of_a_BinaryTree solution = new Lowest_Common_Ancestor_of_a_BinaryTree();
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);

        // Print the result
        System.out.println("Lowest Common Ancestor Value: " + lca.val);
    }
}
