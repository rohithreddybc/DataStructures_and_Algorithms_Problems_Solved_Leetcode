package com.rohith.leetcode75.arrayAndString;

public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();

        // Example usage:
        String input1 = "the sky is blue";
        String output1 = reverseWords.reverseWords(input1);
        System.out.println("Input: " + input1);
        System.out.println("Output: " + output1);

        String input2 = "  hello world  ";
        String output2 = reverseWords.reverseWords(input2);
        System.out.println("Input: " + input2);
        System.out.println("Output: " + output2);

        String input3 = "a good   example";
        String output3 = reverseWords.reverseWords(input3);
        System.out.println("Input: " + input3);
        System.out.println("Output: " + output3);
    }

    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        s = s.trim(); // Ensure leading and trailing spaces are removed
        String[] words = s.split("\\s+"); // Split by white characters to remove extra spaces

        for (int i = words.length - 1; i > 0; i--) {
            sb.append(words[i]).append(" ");
        }
        sb.append(words[0]);

        return sb.toString().trim();
    }
}
