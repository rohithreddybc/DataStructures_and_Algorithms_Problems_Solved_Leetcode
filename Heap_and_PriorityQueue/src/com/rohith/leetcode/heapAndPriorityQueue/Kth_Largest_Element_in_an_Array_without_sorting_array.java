package com.rohith.leetcode.heapAndPriorityQueue;

import java.util.PriorityQueue;
import java.util.Arrays;

public class Kth_Largest_Element_in_an_Array_without_sorting_array {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int num: nums){
                pq.add(num);
                if(pq.size() > k){
                    pq.remove();
                }
            }
            return pq.peek();
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        Kth_Largest_Element_in_an_Array_without_sorting_array obj = new Kth_Largest_Element_in_an_Array_without_sorting_array();
        System.out.println("Input nums: " + Arrays.toString(nums));
        System.out.println("k: " + k);
        System.out.println("Kth largest element: " + obj.new Solution().findKthLargest(nums, k));
    }
}
