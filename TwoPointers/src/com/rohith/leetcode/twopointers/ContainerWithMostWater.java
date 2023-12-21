package com.rohith.leetcode.twopointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int a = 0, b = height.length - 1;
        int maxArea = 0;

        // Using two pointers to traverse the array from both ends
        while (a < b) {
            // Calculate the area between the two pointers
            if ((Math.min(height[a], height[b]) * (b - a)) > maxArea) {
                maxArea = (Math.min(height[a], height[b]) * (b - a));
            }

            // Move the pointers based on the height of the walls
            if (height[a] < height[b]) {
                a++;
            } else {
                b--;
            }
        }
        return maxArea;

        // The below code works, but it has O(n^2) time complexity
        // for(a =0; a<height.length-1;a++){
        //     if((Math.min(height[a],height[b]) * (b-a)) > maxArea){
        //         maxArea = (Math.min(height[a],height[b]) * (b-a));
        //     }
        //     if(height[a] < height[b]){
        //         a++;
        //     } else {
        //         b--;
        //     }
        // }
        // return maxArea;
    }

    public static void main(String[] args) {
        // Example usage:
        ContainerWithMostWater container = new ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = container.maxArea(height);
        System.out.println("Maximum water container area: " + result);
    }
}
