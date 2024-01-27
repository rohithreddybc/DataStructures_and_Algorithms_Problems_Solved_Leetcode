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
public class Path_Sum_3_Number_of_Paths_Where_the_Sum_of_the_Values_Along_the_Path_Equals_TargetSum {
	
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        
        return (int) findPathSum(root, targetSum, 0) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public long findPathSum(TreeNode root, int targetSum, long currentSum){
        if (root == null) return 0;
        currentSum += root.val;
        long count = (targetSum == currentSum) ? 1 : 0;
        count += findPathSum(root.left, targetSum, currentSum);
        count += findPathSum(root.right, targetSum, currentSum);
        return count;
    }

    public static void main(String[] args) {
        // Example usage
        Path_Sum_3_Number_of_Paths_Where_the_Sum_of_the_Values_Along_the_Path_Equals_TargetSum solution = new Path_Sum_3_Number_of_Paths_Where_the_Sum_of_the_Values_Along_the_Path_Equals_TargetSum();

        // Create the binary tree based on the provided input
        TreeNode root = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(3),
                                new TreeNode(-2)),
                        new TreeNode(2,
                                null,
                                new TreeNode(1))),
                new TreeNode(-3,
                        null,
                        new TreeNode(11)));

        int targetSum = 8;

        // Call the pathSum method
        int result = solution.pathSum(root, targetSum);

        // Display the result
        System.out.println("Number of paths with sum " + targetSum + ": " + result);
    }
}
