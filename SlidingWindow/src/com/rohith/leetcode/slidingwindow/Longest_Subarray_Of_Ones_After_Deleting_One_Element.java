package com.rohith.leetcode.slidingwindow;

public class Longest_Subarray_Of_Ones_After_Deleting_One_Element {
    // Function to find the length of the longest subarray of 1's after deleting one element
    public int longestOnes(int[] nums) {
        int windowStart = 0, windowEnd = 0, currentZeros = 0, maxZeros = 1;

        while (windowEnd < nums.length) {
            // Expand the window
            if (nums[windowEnd] == 0) {
                currentZeros++;
            }
            windowEnd++;

            // Shrink the window if there are more than maxZeros zeros
            if (currentZeros > maxZeros) {
                if (nums[windowStart] == 0) {
                    currentZeros--;
                }
                windowStart++;
            }
        }

        // Return the length of the longest subarray
        return windowEnd - windowStart - 1;
    }

    // Main function for testing the solution
    public static void main(String[] args) {
        // Example usage or test cases
        int[] nums = {1, 1, 0, 0, 1, 1, 1, 0, 1};
        Longest_Subarray_Of_Ones_After_Deleting_One_Element solution = new Longest_Subarray_Of_Ones_After_Deleting_One_Element();
        int result = solution.longestOnes(nums);
        System.out.println("Length of longest subarray of 1's after deleting one element: " + result);
    }
}
