package com.rohith.leetcode.binarytree_DFS;

import java.util.ArrayList;
import java.util.List;

public class Leaf_Similar_Trees__Leaf_Sequence_of_Similar_trees {
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
        
        // Create instances of TreeNode with the given input  Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
        TreeNode root1 = new TreeNode(3,
                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                new TreeNode(1, new TreeNode(9), new TreeNode(8))
        );

        TreeNode root2 = new TreeNode(3,
                new TreeNode(5, new TreeNode(6), new TreeNode(7)),
                new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(9), new TreeNode(8)))
        );
        Leaf_Similar_Trees__Leaf_Sequence_of_Similar_trees solution = new Leaf_Similar_Trees__Leaf_Sequence_of_Similar_trees();
        boolean result = solution.leafSimilar(root1, root2);

        System.out.println("Are the leaf sequences similar? " + result);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        findLeafs(root1, l1);
        findLeafs(root2, l2);

        return l1.equals(l2);
    }

    public void findLeafs(TreeNode root, List<Integer> list) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            list.add(root.val);
        }

        findLeafs(root.left, list);
        findLeafs(root.right, list);
    }
}
