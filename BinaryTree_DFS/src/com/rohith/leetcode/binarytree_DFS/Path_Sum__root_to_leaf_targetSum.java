package com.rohith.leetcode.binarytree_DFS;

public class Path_Sum__root_to_leaf_targetSum {
    
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    public static void main(String[] args) {
        // Example usage:
        // Constructing a sample tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        // Creating an instance of the class
        Path_Sum__root_to_leaf_targetSum pathSum = new Path_Sum__root_to_leaf_targetSum();

        // Checking if there exists a root-to-leaf path with the given target sum
        boolean result = pathSum.hasPathSum(root, targetSum);

        // Displaying the result
        System.out.println("Does there exist a root-to-leaf path with sum " + targetSum + "? " + result);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
         return findPathSum(root, targetSum, 0);
    }

    public boolean findPathSum(TreeNode root, int targetSum, int sumTillNow) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            sumTillNow += root.val;
            return targetSum == sumTillNow;
        }
        sumTillNow += root.val;

        return findPathSum(root.left, targetSum, sumTillNow) || findPathSum(root.right, targetSum, sumTillNow);
    }
}
