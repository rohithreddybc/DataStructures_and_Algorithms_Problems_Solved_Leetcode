package com.rohith.leetcode.binarytree_DFS;

import java.util.ArrayList;
import java.util.List;

public class Path_Sum__all_Paths_of_root_to_leaf_with_targetSum {

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
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
        // Example usage of the program
        TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        int targetSum = 22;

        Path_Sum__all_Paths_of_root_to_leaf_with_targetSum solution = new Path_Sum__all_Paths_of_root_to_leaf_with_targetSum();
        List<List<Integer>> result = solution.pathSum(root, targetSum);

        // Print the result
        System.out.println(result);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int sumTillNow = 0;
        findAllPathSum(root, targetSum, sumTillNow, list, finalList);
        return finalList;
    }

    public void findAllPathSum(TreeNode root, int targetSum, int sumTillNow, List<Integer> list, List<List<Integer>> finalList) {
        if (root == null) return;

        list.add(root.val);
        sumTillNow += root.val;

        if (root.left == null && root.right == null && targetSum == sumTillNow) {
            finalList.add(new ArrayList<>(list));
            sumTillNow -= root.val;
        }

        findAllPathSum(root.left, targetSum, sumTillNow, list, finalList);
        findAllPathSum(root.right, targetSum, sumTillNow, list, finalList);

        list.remove(list.size() - 1);
    }
}
