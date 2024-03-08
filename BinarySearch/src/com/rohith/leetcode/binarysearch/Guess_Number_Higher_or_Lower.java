package com.rohith.leetcode.binarysearch;

import java.util.Arrays;

public class Guess_Number_Higher_or_Lower {
    private int pick;

    public Guess_Number_Higher_or_Lower(int pick) {
        this.pick = pick;
    }

    public int guessNumber(int n) {
        int low = 1, high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = Integer.compare(mid, pick); // Using predefined binarySearch method
            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Example usage
    public static void main(String[] args) {
        int pick = 6; // Picked number
        int upperBound = 10; // Example upper bound
        Guess_Number_Higher_or_Lower solution = new Guess_Number_Higher_or_Lower(pick);

        // Guessing the number
        int result = solution.guessNumber(upperBound);

        System.out.println("Guessed number: " + result);
    }
}
