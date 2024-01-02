
package com.rohith.leetcode.hashmapandset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Find_the_Difference_of_Two_Arrays {

	public static class ArrayDifferenceFinder {
		public List<List<Integer>> findDifference(int[] array1, int[] array2) {
			List<List<Integer>> result = new ArrayList<>();
			List<Integer> uniqueInArray1 = new ArrayList<>();
			List<Integer> uniqueInArray2 = new ArrayList<>();

			Set<Integer> set1 = new HashSet<>();
			Set<Integer> set2 = new HashSet<>();

			for (int num : array1)
				set1.add(num);
			for (int num : array2)
				set2.add(num);

			for (int element : set1) {
				if (!set2.contains(element)) {
					uniqueInArray1.add(element);
				}
			}

			for (int element : set2) {
				if (!set1.contains(element)) {
					uniqueInArray2.add(element);
				}
			}

			result.add(uniqueInArray1);
			result.add(uniqueInArray2);

			return result;
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 4, 5 };
		int[] nums2 = { 3, 4, 5, 6, 7 };

		ArrayDifferenceFinder arrayDifferenceFinder = new ArrayDifferenceFinder();
		List<List<Integer>> result = arrayDifferenceFinder.findDifference(nums1, nums2);

		System.out.println("Elements unique to nums1: " + result.get(0));
		System.out.println("Elements unique to nums2: " + result.get(1));
	}
}
