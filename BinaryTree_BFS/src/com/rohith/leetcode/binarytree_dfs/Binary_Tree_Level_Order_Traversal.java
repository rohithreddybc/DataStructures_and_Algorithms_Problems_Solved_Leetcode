package com.rohith.leetcode.binarytree_dfs;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Level_Order_Traversal {

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

    List<List<Integer>> levelOrderList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        findLevelOrder(root, 0);
        return levelOrderList;
    }

    public void findLevelOrder(TreeNode root, int level) {
        if (root == null) return;
        if (levelOrderList.size() == level) {
            levelOrderList.add(new ArrayList<>());
        }

        levelOrderList.get(level).add(root.val);
        findLevelOrder(root.left, level + 1);
        findLevelOrder(root.right, level + 1);
    }

    public static void main(String[] args) {
        // Instantiate a binary tree based on the provided input
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));

        // Call the levelOrder method and print the result
        Binary_Tree_Level_Order_Traversal solution = new Binary_Tree_Level_Order_Traversal();
        List<List<Integer>> result = solution.levelOrder(root);

        // Print the result
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
