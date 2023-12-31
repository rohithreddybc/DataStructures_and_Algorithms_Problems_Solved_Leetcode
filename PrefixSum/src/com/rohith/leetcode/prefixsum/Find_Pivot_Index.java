package com.rohith.leetcode.prefixsum;

public class Find_Pivot_Index {
    public int findPivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            totalSum -= nums[i];
            if (totalSum == leftSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
    	Find_Pivot_Index solution = new Find_Pivot_Index();
        
        // Example usage:
        int[] nums = {1, 7, 3, 6, 5, 6};
        int result = solution.findPivotIndex(nums);
        System.out.println("Pivot Index: " + result);
    }
}
