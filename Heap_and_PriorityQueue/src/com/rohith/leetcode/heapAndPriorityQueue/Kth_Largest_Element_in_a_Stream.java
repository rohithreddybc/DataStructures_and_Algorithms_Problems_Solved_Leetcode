package com.rohith.leetcode.heapAndPriorityQueue;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_a_Stream {
    
    class KthLargest {
         PriorityQueue<Integer> pq= new PriorityQueue<>();
         int k;
            public KthLargest(int k, int[] nums) {
                this.k = k;
                for(int num: nums){
                    add(num);
                }
            }
            
            public int add(int val) {
                pq.add(val);
                if(pq.size() > k){
                    pq.remove();
                }
                return pq.peek();
                
            }
        }

        /**
         * Your KthLargest object will be instantiated and called as such:
         * KthLargest obj = new KthLargest(k, nums);
         * int param_1 = obj.add(val);
         */

    public static void main(String[] args) {
        // Given input
        int[] nums = {4, 5, 8, 2}; // Example array of numbers
        System.out.println("Input:");
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i != nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        // Create KthLargest object and perform add operations
        Kth_Largest_Element_in_a_Stream kthLargest = new Kth_Largest_Element_in_a_Stream();
        KthLargest obj = kthLargest.new KthLargest(3, nums);
        
        // Perform add operations and display output
        System.out.println("Output:");
        System.out.println(obj.add(3)); // Output: 4
        System.out.println(obj.add(5)); // Output: 5
        System.out.println(obj.add(10)); // Output: 5
        System.out.println(obj.add(9)); // Output: 8
        System.out.println(obj.add(4)); // Output: 8
    }
}
