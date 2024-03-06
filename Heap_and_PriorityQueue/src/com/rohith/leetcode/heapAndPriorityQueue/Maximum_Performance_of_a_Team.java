package com.rohith.leetcode.heapAndPriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Maximum_Performance_of_a_Team {
    // Method to calculate the maximum performance of a team
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        // Create a 2D array to store the pairs of efficiency and speed for each engineer
        int[][] engSet = new int[n][2];
        for(int i = 0; i < n; i++) {
            engSet[i][0] = efficiency[i]; // Store efficiency
            engSet[i][1] = speed[i]; // Store speed
        }

        // Sort the engineers by efficiency in descending order
        Arrays.sort(engSet, (a, b) -> (b[0] - a[0]));

        // Create a priority queue to store the speeds of selected engineers
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        // Initialize variables to track maximum performance and current total speed
        long perf = 0, currPer = 0;

        // Iterate through each engineer
        for(int[] eng : engSet) {
            // If the team size exceeds k, remove the engineer with the lowest speed
            if(pq.size() >= k) {
                currPer -= pq.poll();
            }
            // Add the speed of the current engineer to the total speed
            currPer += eng[1];
            // Add the current engineer's speed to the priority queue
            pq.add(eng[1]);
                
            // Calculate the performance considering the current engineer and update the maximum performance
            perf = Math.max(perf, currPer * eng[0]);
        }
        // Return the maximum performance modulo 10^9 + 7
        return (int) (perf % 1000000007);
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Create an instance of the class
        Maximum_Performance_of_a_Team solution = new Maximum_Performance_of_a_Team();
        
        // Example test cases
        int[] speed1 = {2, 10, 3, 1, 5, 8};
        int[] efficiency1 = {5, 4, 3, 9, 7, 2};
        int k1 = 2;
        // Calculate and print the maximum performance for the first example
        System.out.println("Example 1: " + solution.maxPerformance(6, speed1, efficiency1, k1)); // Output: 60

        int[] speed2 = {1, 3, 3, 2};
        int[] efficiency2 = {2, 1, 3, 4};
        int k2 = 3;
        // Calculate and print the maximum performance for the second example
        System.out.println("Example 2: " + solution.maxPerformance(4, speed2, efficiency2, k2)); // Output: 12
    }
}
