package com.rohith.leetcode.binarytree_dfs;

import java.util.List;
import java.util.ArrayList;

public class Binary_Tree_Right_Side_View {

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    List<Integer> resultList = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return resultList;
        findRightSideView(root, resultList, 0);
        return resultList;
    }

    public void findRightSideView(TreeNode root, List<Integer> resultList, int level) {
        if (root == null) return;
        if (resultList.size() == level) {
            resultList.add(root.val);
        }
        findRightSideView(root.right, resultList, level + 1);
        findRightSideView(root.left, resultList, level + 1);
    }

    public static void main(String[] args) {
        // Instantiate a binary tree based on the provided input
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        // Call the rightSideView method and print the result
        Binary_Tree_Right_Side_View solution = new Binary_Tree_Right_Side_View();
        List<Integer> result = solution.rightSideView(root);

        // Print the result
        System.out.println("Right Side View: " + result);
    }
}
