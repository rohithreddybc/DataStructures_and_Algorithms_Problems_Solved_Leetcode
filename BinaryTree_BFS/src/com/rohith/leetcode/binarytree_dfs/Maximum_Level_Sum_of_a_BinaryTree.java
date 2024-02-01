package com.rohith.leetcode.binarytree_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Level_Sum_of_a_BinaryTree {
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

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int currentSum = 0, TotalMaxSum = Integer.MIN_VALUE, maxLevel = 1, level = 1;
        while (!q.isEmpty()) {
            int currentLevelSize = q.size();
            currentSum = 0;
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = q.poll();
                currentSum += node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            if (TotalMaxSum < currentSum) {
                TotalMaxSum = currentSum;
                maxLevel = level;
            }

            level++;
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        // Instantiate a binary tree based on the provided input
        TreeNode root = new TreeNode(1,
                new TreeNode(7, new TreeNode(7), new TreeNode(-8)),
                new TreeNode(0));

        // Call the maxLevelSum method and print the result
        Maximum_Level_Sum_of_a_BinaryTree solution = new Maximum_Level_Sum_of_a_BinaryTree();
        int result = solution.maxLevelSum(root);

        // Print the result
        System.out.println("Maximum Level Sum Level: " + result);
    }
}
