package com.rohith.leetcode.binarytree_DFS;

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
public class Count_Good_Nodes_in_Binary_Tree {

    public int count = 0;

    public int goodNodes(TreeNode root) {
        findGood(root, root.val);
        return count;
    }

    public void findGood(TreeNode root, int maxSoFar) {
        if (root == null) return;

        if (root.val >= maxSoFar) {
            maxSoFar = root.val;
            count++;
        }

        findGood(root.left, maxSoFar);
        findGood(root.right, maxSoFar);
    }

    public static void main(String[] args) {
        // Create a sample binary tree based on the provided input
        TreeNode root = new TreeNode(3,
                new TreeNode(1,
                        new TreeNode(3),
                        null
                ),
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(5)
                )
        );

        // Create an instance of Count_Good_Nodes_in_Binary_Tree
        Count_Good_Nodes_in_Binary_Tree solution = new Count_Good_Nodes_in_Binary_Tree();

        // Call the goodNodes method and print the result
        int result = solution.goodNodes(root);
        System.out.println("Number of good nodes: " + result);
    }
}
