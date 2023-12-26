package com.rohith.leetcode.slidingwindow;

public class Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {

    public int maxVowels(String s, int k) {
        int maxVowelsCount = 0, currentVowelsCount = 0;

        // Calculate the vowel count for the first substring of length k
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currentVowelsCount++;
            }
        }

        maxVowelsCount = currentVowelsCount;

        // Slide the window and update the vowel count
        for (int i = k; i < s.length(); i++) {
            // Update the vowel count by subtracting the first character of the previous substring
            if (isVowel(s.charAt(i - k))) {
                currentVowelsCount--;
            }

            // Update the vowel count by adding the current character
            if (isVowel(s.charAt(i))) {
                currentVowelsCount++;
            }

            // Update maxVowelsCount if necessary
            maxVowelsCount = Math.max(maxVowelsCount, currentVowelsCount);
        }

        return maxVowelsCount;
    }

    public boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    public static void main(String[] args) {
    	Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length solution = new Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length();

        // Example 1
        String s1 = "abciiidef";
        int k1 = 3;
        int result1 = solution.maxVowels(s1, k1);
        System.out.println("Example 1: " + result1);

        // Example 2
        String s2 = "aeiou";
        int k2 = 2;
        int result2 = solution.maxVowels(s2, k2);
        System.out.println("Example 2: " + result2);

        // Example 3
        String s3 = "leetcode";
        int k3 = 3;
        int result3 = solution.maxVowels(s3, k3);
        System.out.println("Example 3: " + result3);
    }
}
