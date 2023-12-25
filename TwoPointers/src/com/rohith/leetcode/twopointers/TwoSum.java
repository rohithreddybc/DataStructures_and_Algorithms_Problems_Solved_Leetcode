package com.rohith.leetcode.twopointers;

import java.util.HashMap;

class TwoSum {
	public int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		int[] ans = new int[2];
		for (int i = 0; i < nums.length; i++) {

			if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
				ans[0] = i;
				ans[1] = map.get(target - nums[i]);
				return ans;

			}

		}
		return ans;
	}

	public static void main(String[] args) {
		// Example usage
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;

		// Create an instance of the solution class
		TwoSum solution = new TwoSum();

		// Call the twoSum method and print the result
		int[] result = solution.twoSum(nums, target);
		System.out.println(
				"Indices of the two numbers that add up to the target: [" + result[0] + ", " + result[1] + "]");
	}
}
