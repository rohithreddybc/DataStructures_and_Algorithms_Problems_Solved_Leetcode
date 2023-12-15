package com.rohith.leetcode75.arrayAndString;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {

		int preProd = 1;
		int postProd = 1;

		int[] outputArr = new int[nums.length];

		for (int i = 0; i <= nums.length - 1; i++) {
			outputArr[i] = preProd;
			preProd *= nums[i];
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			outputArr[i] *= postProd;
			postProd *= nums[i];
		}
		return outputArr;
	}

	public static void main(String[] args) {
		// Test the solution with example input
		ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
		int[] input = { 1, 2, 3, 4 };
		int[] result = solution.productExceptSelf(input);

		// Print the result
		System.out.println(Arrays.toString(result));
	}
}
