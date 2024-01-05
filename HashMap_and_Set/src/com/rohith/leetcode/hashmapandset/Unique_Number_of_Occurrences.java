package com.rohith.leetcode.hashmapandset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Unique_Number_of_Occurrences {
    public boolean uniqueOccurrences(int[] numbers) {
        HashMap<Integer, Integer> occurrenceCountMap = new HashMap<>();

        for (int number : numbers) {
            occurrenceCountMap.put(number, occurrenceCountMap.getOrDefault(number, 0) + 1);
        }

        Set<Integer> uniqueOccurrencesSet = new HashSet<>(occurrenceCountMap.values());
        return uniqueOccurrencesSet.size() == occurrenceCountMap.size();
    }

    public static void main(String[] args) {
        Unique_Number_of_Occurrences uniqueOccurrencesObj = new Unique_Number_of_Occurrences();

        int[] inputNumbers = {1, 2, 2, 1, 1, 3};
        boolean isUnique = uniqueOccurrencesObj.uniqueOccurrences(inputNumbers);

        System.out.println("Do occurrences have unique counts? " + isUnique);
    }
}
