package com.rohith.leetcode.stack;

public class Removing_Stars_From_a_String {
    
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                sb.append(s.charAt(i));
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Removing_Stars_From_a_String remover = new Removing_Stars_From_a_String();

        // Example usage
        String input = "leet**cod*e";
        String result = remover.removeStars(input);

        System.out.println("Input: " + input);
        System.out.println("Output: " + result);
    }
}
