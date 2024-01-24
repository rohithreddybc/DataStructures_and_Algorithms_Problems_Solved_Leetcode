package com.rohith.leetcode.binarytree_DFS;

//Definition for a binary tree node.
class TreeNode {
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

public class Maximum_Depth_of_Binary_Tree {

 public int maxDepth(TreeNode root) {
     if (root == null) return 0;
     int left = maxDepth(root.left);
     int right = maxDepth(root.right);

     return Math.max(left, right) + 1;
 }

 public static void main(String[] args) {
     // Example usage:
     TreeNode root = new TreeNode(3);
     root.left = new TreeNode(9);
     root.right = new TreeNode(20);
     root.right.left = new TreeNode(15);
     root.right.right = new TreeNode(7);

     Maximum_Depth_of_Binary_Tree solution = new Maximum_Depth_of_Binary_Tree();
     int depth = solution.maxDepth(root);
     System.out.println("Maximum Depth of Binary Tree: " + depth);
 }
}

