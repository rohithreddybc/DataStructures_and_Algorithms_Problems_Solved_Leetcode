package com.rohith.leetcode.heapAndPriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

// Define a class named Maximum_Subsequence_Score to solve the problem
public class Maximum_Subsequence_Score {
    
    // Define a method to calculate the maximum score
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        // Create a 2D array to store pairs of elements from nums1 and nums2
        int[][] numPairs = new int[n][2];
        
        // Populate the numPairs array with elements from nums1 and nums2
        for (int i = 0; i < n; i++) {
            numPairs[i] = new int[] {nums2[i], nums1[i]};
        }

        // Sort the numPairs array based on the elements of nums2 in descending order
        Arrays.sort(numPairs, (a, b) -> b[0] - a[0]);

        // Create a priority queue to store elements from nums1
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Initialize variables to track the maximum score and the total score
        long maxScore = 0, totalScoreTillNow = 0;

        // Iterate through the sorted numPairs array
        for (int[] nump : numPairs) {
            // Add the element from nums1 to the priority queue
            pq.add(nump[1]);
            // Add the element from nums1 to the total score
            totalScoreTillNow += nump[1];
            // If the size of the priority queue exceeds k, remove the smallest element
            if (pq.size() > k) {
                totalScoreTillNow -= pq.poll();
            }
            // If the size of the priority queue reaches k, calculate the score and update the maximum score
            if (pq.size() == k) {
                maxScore = Math.max(maxScore, totalScoreTillNow * nump[0]);
            }
        }

        // Return the maximum score
        return maxScore;
    }

    // Define the main method to execute the program
    public static void main(String[] args) {
        // Create an instance of the Maximum_Subsequence_Score class
        Maximum_Subsequence_Score solution = new Maximum_Subsequence_Score();

        // Define input arrays and k value
        int[] nums1 = {1, 3, 3, 2};
        int[] nums2 = {2, 1, 3, 4};
        int k = 3;

        // Call the maxScore method with the input arrays and k value
        long result = solution.maxScore(nums1, nums2, k);
        
        // Print the result
        System.out.println("Output: " + result);
    }
}
