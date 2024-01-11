package com.rohith.leetcode.hashmapandset;

import java.util.HashMap;
import java.util.Map;

public class Equal_Row_and_Column_Pairs {

    // Method to count the number of equal pairs in rows and columns
    public int countEqualPairs(int[][] matrix) {
        int count = 0;
        Map<String, Integer> rowOccurrences = new HashMap<>();
        Map<String, Integer> colOccurrences = new HashMap<>();

        // Calculate occurrences in rows ex: 3_2_1_ 
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder rowKey = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                rowKey.append(matrix[i][j]).append("_");
            }
            rowOccurrences.put(rowKey.toString(), rowOccurrences.getOrDefault(rowKey.toString(), 0) + 1);
        }

        // Calculate occurrences in columns ex: 3_1_2_
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder colKey = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                colKey.append(matrix[j][i]).append("_");
            }
            colOccurrences.put(colKey.toString(), colOccurrences.getOrDefault(colKey.toString(), 0) + 1);
        }

        // Check for equal pairs 
        for (Map.Entry<String, Integer> entry : rowOccurrences.entrySet()) {
            String key = entry.getKey();
            if (colOccurrences.containsKey(key) && rowOccurrences.containsKey(key)) {
                count += colOccurrences.get(key) * rowOccurrences.get(key);  //frequency of same strings in col * row 
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Equal_Row_and_Column_Pairs solution = new Equal_Row_and_Column_Pairs();
        
        // Example usage with a 2D array
        int[][] matrix = {
            {3, 2, 1},
            {1, 7, 6},
            {2, 7, 7}
        };
        
        // Call the method and print the result
        int result = solution.countEqualPairs(matrix);
        System.out.println("Number of Equal Pairs: " + result);
    }
}
