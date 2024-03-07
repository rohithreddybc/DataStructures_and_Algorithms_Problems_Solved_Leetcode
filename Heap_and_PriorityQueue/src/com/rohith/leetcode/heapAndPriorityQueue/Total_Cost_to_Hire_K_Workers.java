package com.rohith.leetcode.heapAndPriorityQueue;

import java.util.Scanner;
import java.util.PriorityQueue;

public class Total_Cost_to_Hire_K_Workers {

    static class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            PriorityQueue<Integer> pq1 = new PriorityQueue<>();
            PriorityQueue<Integer> pq2 = new PriorityQueue<>();
            int i = 0;
            int j = costs.length - 1;
            long totCost = 0;
            while (k-- > 0) {
                while (pq1.size() < candidates && i <= j) {
                    pq1.offer(costs[i++]);
                }
                while (pq2.size() < candidates && j >= i) {
                    pq2.offer(costs[j--]);
                }

                int c1 = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
                int c2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;
                if (c1 <= c2) {
                    totCost += c1;
                    pq1.poll();
                } else {
                    totCost += c2;
                    pq2.poll();
                }
            }
            return totCost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of workers
        System.out.println("Enter the number of workers:");
        int n = scanner.nextInt();

        // Input the costs array
        System.out.println("Enter the costs of workers:");
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = scanner.nextInt();
        }

        // Input the value of k
        System.out.println("Enter the value of k:");
        int k = scanner.nextInt();

        // Input the value of candidates
        System.out.println("Enter the value of candidates:");
        int candidates = scanner.nextInt();

        Solution solution = new Solution();
        long result = solution.totalCost(costs, k, candidates);
        System.out.println("Total cost to hire exactly " + k + " workers: " + result);

        scanner.close();
    }
}
