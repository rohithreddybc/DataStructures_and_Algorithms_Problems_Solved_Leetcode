package com.rohith.leetcode.hashmapandset;

import java.util.HashMap;
import java.util.Map;

public class Equal_Row_and_Column_Pairs {

    public int countEqualPairs(int[][] matrix) {
        int ans = 0;
        Map<String, Integer> rowOccurrences = new HashMap<>();
        Map<String, Integer> colOccurrences = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            StringBuilder rowKey = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                rowKey.append(matrix[i][j]).append("_");
            }
            rowOccurrences.put(rowKey.toString(), rowOccurrences.getOrDefault(rowKey.toString(), 0) + 1);
        }

        for (int i = 0; i < matrix.length; i++) {
            StringBuilder colKey = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                colKey.append(matrix[j][i]).append("_");
            }
            colOccurrences.put(colKey.toString(), colOccurrences.getOrDefault(colKey.toString(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : rowOccurrences.entrySet()) {
            String key = entry.getKey();
            if (colOccurrences.containsKey(key) && rowOccurrences.containsKey(key)) {
                ans += colOccurrences.get(key) * rowOccurrences.get(key);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Equal_Row_and_Column_Pairs solution = new Equal_Row_and_Column_Pairs();
        
        // Example usage with a 2D array
        int[][] matrix = {
            {3, 2, 1},
            {1, 7, 6},
            {2, 7, 7}
        };
        
        int result = solution.countEqualPairs(matrix);
        System.out.println("Result: " + result);
    }
}
