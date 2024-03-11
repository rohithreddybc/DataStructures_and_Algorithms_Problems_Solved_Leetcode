package com.rohith.leetcode.binarysearch;

import java.util.Arrays;

public class Successful_Pairs_of_Spells_and_Potions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int start = 0;
            int end = m - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                long product = (long) spell * potions[mid];
                if (product > success) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            pairs[i] = m - start;
        }
        return pairs;
    }

    public static void main(String[] args) {
        Successful_Pairs_of_Spells_and_Potions solution = new Successful_Pairs_of_Spells_and_Potions();

        // Given input
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        long success = 7;
        int[] result = solution.successfulPairs(spells, potions, success);
        System.out.println(Arrays.toString(result)); // Output: [4, 0, 3]
    }
}
