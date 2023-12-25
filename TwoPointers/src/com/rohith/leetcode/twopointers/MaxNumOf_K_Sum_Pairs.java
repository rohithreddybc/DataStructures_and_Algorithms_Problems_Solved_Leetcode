package com.rohith.leetcode.twopointers;

import java.util.Arrays;

public class MaxNumOf_K_Sum_Pairs {

    public static void main(String[] args) {
        // Example usage or testing
        int[] nums = {1, 2, 3, 4, 5};
        int k = 6;
        MaxNumOf_K_Sum_Pairs solution = new MaxNumOf_K_Sum_Pairs();
        int result = solution.maxOperations(nums, k);
        System.out.println("Maximum number of operations: " + result);
    }

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);  // Sorting the array (O(n log n))

        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int operationCount = 0;

        while (leftIndex < rightIndex) {  // Traversing the array (O(n))
            int currentSum = nums[leftIndex] + nums[rightIndex];

            if (currentSum == k) {
                leftIndex++;
                rightIndex--;
                operationCount++;
            } else if (currentSum > k) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        return operationCount;
    }
}
