package com.rohith.leetcode.slidingwindow;

public class MaxConsecutiveOnes_3_dynamic_K_Zeros {

	public static void main(String[] args) {
		MaxConsecutiveOnes_3_dynamic_K_Zeros solution = new MaxConsecutiveOnes_3_dynamic_K_Zeros();

		// Example usage:
		int[] nums = { 1, 0, 0, 1, 1, 0, 1, 0, 1, 1 };
		int k = 2;
		int result = solution.longestOnes(nums, k);
		System.out.println("Length of the longest subarray with at most " + k + " zeros: " + result);
	}

	public int longestOnes(int[] nums, int maxZeros) {
		int windowStart = 0, windowEnd = 0, currentZeros = 0;

		while (windowEnd < nums.length) {
			if (nums[windowEnd] == 0) {
				currentZeros++;
			}
			windowEnd++;

			if (currentZeros > maxZeros) {
				if (nums[windowStart] == 0) {
					currentZeros--;
				}
				windowStart++;
			}
		}

		return windowEnd - windowStart;
	}
}

// same function as above, but removing zeros variable and reducing k (aka maxZeros) 
//reduced program performance from 3ms to 2ms

//public int longestOnes(int[] nums, int maxZeros) {
// int windleft = 0,zeros=0,windright=0;
// while(windright < nums.length){
// if(nums[windright++] == 0){
// zeros++;
// }
// // windright++;
// if(zeros>k){
// if(nums[windleft++] == 0){
// zeros--;
// }
// // windleft++;
// }
// }
// return windright - windleft;
