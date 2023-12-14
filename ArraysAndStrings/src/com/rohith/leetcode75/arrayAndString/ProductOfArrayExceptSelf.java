package com.rohith.leetcode75.arrayAndString;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);

        // Forward pass
        int curr = 1;
        for (int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }

        // Backward pass
        curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        // Test the solution with example input
    	ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        int[] input = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(input);

        // Print the result
        System.out.println(Arrays.toString(result));
    }
}
