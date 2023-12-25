package com.rohith.leetcode.twopointers;

import java.util.HashMap;
import java.util.Map;

public class MaxNumOf_K_Sum_Pairs_using_HashMap {
	public int maxOperations(int[] nums, int k) {
		//below code uses HashMap with complexity O(n) but it will be fat only when the inputs are large
		int operationCount = 0;
		Map<Integer, Integer> numOccurrences = new HashMap<>();

		for (int num : nums) {
			if (numOccurrences.containsKey(k - num) && numOccurrences.get(k - num) > 0) {
				operationCount++;
				numOccurrences.put(k - num, numOccurrences.get(k - num) - 1);
			} else {
				numOccurrences.put(num, numOccurrences.getOrDefault(num, 0) + 1);
			}
		}

		return operationCount;
	}

	public static void main(String[] args) {
		// Example usage
		int[] nums = { 2, 1, 3, 4, 3, 3 };
		int k = 6;
//    	 int[] nums = {1, 2, 3, 4};
//       int k = 5;

		// Create an instance of the solution class
		MaxNumOf_K_Sum_Pairs_using_HashMap solution = new MaxNumOf_K_Sum_Pairs_using_HashMap();

		// Call the maxOperations method and print the result
		int result = solution.maxOperations(nums, k);
		System.out.println("The maximum number of operations: " + result);
	}
}
