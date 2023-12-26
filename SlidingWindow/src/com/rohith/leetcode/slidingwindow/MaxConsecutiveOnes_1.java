package com.rohith.leetcode.slidingwindow;

public class MaxConsecutiveOnes_1 {

    public int longestOnes(int[] nums, int k) {
        int count = 0, i = 0, maxConsecutiveOnes = 0;
        
        while (i < nums.length) {
            if (nums[i] == 1) {
                count++;
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, count);
            }
            
            if (nums[i] == 0) {
                count = 0;
            }
            
            i++;
        }
        
        return maxConsecutiveOnes;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes_1 solution = new MaxConsecutiveOnes_1();

        // Example
        int[] nums = {1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1};
        int k = 2;
        int result = solution.longestOnes(nums, k);
        System.out.println("Maximum Consecutive Ones: " + result);
    }
}
