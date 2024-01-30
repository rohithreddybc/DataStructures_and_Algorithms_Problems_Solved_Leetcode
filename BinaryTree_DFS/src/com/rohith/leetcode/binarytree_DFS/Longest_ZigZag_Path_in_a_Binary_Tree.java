package com.rohith.leetcode.binarytree_DFS;

public class Longest_ZigZag_Path_in_a_Binary_Tree {

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

    int totalMaxCount = 0;

    public int longestZigZag(TreeNode root) {
        findZigzagLength(root, "leftParent", 0);
        return totalMaxCount;
    }

    public void findZigzagLength(TreeNode root, String direction, int currentMax) {
        if (root == null) return;
        totalMaxCount = Math.max(totalMaxCount, currentMax);
        if (direction.equals("rightParent")) {
            findZigzagLength(root.left, "leftParent", currentMax + 1);
            findZigzagLength(root.right, "rightParent", 1);
        } else {
            findZigzagLength(root.right, "rightParent", currentMax + 1);
            findZigzagLength(root.left, "leftParent", 1);
        }
    }

    public static void main(String[] args) {
        // Example usage or additional testing can be done here
        // Instantiate a binary tree
    	 TreeNode root = new TreeNode(1,
    	            null,
    	            new TreeNode(1,
    	                    new TreeNode(1,
    	                            new TreeNode(1),
    	                            new TreeNode(1)),
    	                    new TreeNode(1,
    	                            null,
    	                            new TreeNode(1,
    	                                    null,
    	                                    new TreeNode(1)))));

        // Call the longestZigZag method and print the result
        Longest_ZigZag_Path_in_a_Binary_Tree solution = new Longest_ZigZag_Path_in_a_Binary_Tree();
        int result = solution.longestZigZag(root);

        // Print the result
        System.out.println("Longest ZigZag Path Length: " + result);
    }
}
