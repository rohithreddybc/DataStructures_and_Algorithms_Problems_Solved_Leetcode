package com.rohith.leetcode.slidingwindow;

/**
 * Find the max sum subarray of a fixed size K
 *
 * Example input: [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]
 *
 */
public class Max_Average_Subarray {

    public static double findMaxSumSubarray(int[] nums, int k) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        // Calculate the initial sum for the first window of size k
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        maxSum = currentSum;

        // Slide the window and update the sum
        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i] - nums[i - k]; // Update the sum by adding the new element and subtracting the old one
            maxSum = Math.max(currentSum, maxSum);
        }

        return (double) maxSum / k; // Calculate the average
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
        int k = 3;

        double result = findMaxSumSubarray(nums, k);
        System.out.println("Max Average Subarray: " + result);
    }
}
