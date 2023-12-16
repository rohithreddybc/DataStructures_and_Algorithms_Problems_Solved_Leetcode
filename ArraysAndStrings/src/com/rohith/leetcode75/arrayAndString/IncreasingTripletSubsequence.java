package com.rohith.leetcode75.arrayAndString;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int ind = 1,i=1,maxtillNow=0;
        // for(int i=0;i<nums.length-1;i++){
        if(nums.length-1 <3) {
        	return false;
        }
        if(nums[0]<nums[1]) {
        	ind++;
            maxtillNow = nums[1];
        }
        while(i<nums.length-1 && ind<3){
            if(nums[i-1] < nums[i]){
                ind++;
                maxtillNow = nums[i];
            }

            i++;
        }
        
        if(ind<3 && maxtillNow < nums[nums.length-1] ){
            ind++;
        }

        return ind>=3;
    }


    public static void main(String[] args) {
    	IncreasingTripletSubsequence solution = new IncreasingTripletSubsequence();

        // Test case 1
        int[] nums1 = {1, 2, 3, 4, 5};
        boolean result1 = solution.increasingTriplet(nums1);
        System.out.println("Test case 1: " + result1);

        // Test case 2
        int[] nums2 = {5, 4, 3, 2, 1};
        boolean result2 = solution.increasingTriplet(nums2);
        System.out.println("Test case 2: " + result2);

        // Test case 3
        int[] nums3 = {2, 1, 5, 0, 4, 6};
        boolean result3 = solution.increasingTriplet(nums3);
        System.out.println("Test case 3: " + result3);
    }
}
