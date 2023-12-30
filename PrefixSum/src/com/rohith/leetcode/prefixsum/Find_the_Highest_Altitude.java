package com.rohith.leetcode.prefixsum;

public class Find_the_Highest_Altitude {
    
    public int findLargestAltitude(int[] altitudeGain) {
        int maxAltitude = 0,currentAltitude = 0;

        for (int gain : altitudeGain) {
            currentAltitude += gain;
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }

    public static void main(String[] args) {
    	Find_the_Highest_Altitude altitudeFinder = new Find_the_Highest_Altitude();
        int[] altitudeGain = { -5,1,5,0,-7};/* Populate with your altitude gain values */ 
        int result = altitudeFinder.findLargestAltitude(altitudeGain);
        System.out.println("The largest altitude is: " + result);
    }
}
