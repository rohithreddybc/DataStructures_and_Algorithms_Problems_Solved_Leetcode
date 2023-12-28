package com.rohith.leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, maxLength = 0;
        Set<Character> uniqueChars = new HashSet<>();

        while (end < s.length()) {
            if (!uniqueChars.contains(s.charAt(end))) {
                uniqueChars.add(s.charAt(end++));
                maxLength = Math.max(maxLength, uniqueChars.size());
            } else {
                uniqueChars.remove(s.charAt(start++));
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
    	Longest_Substring_Without_Repeating_Characters solution = new Longest_Substring_Without_Repeating_Characters();
        String input = "abcabcbbccc";
        int result = solution.lengthOfLongestSubstring(input);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
}
