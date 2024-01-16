package com.rohith.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2_Senate {
    public static void main(String[] args) {
        Solution solution = new Dota2_Senate().new Solution();

        // Test cases
        System.out.println(solution.predictPartyVictory("RDD"));
        System.out.println(solution.predictPartyVictory("DDRRR"));
    }

    class Solution {
        public String predictPartyVictory(String senate) {
            Queue<Integer> dq = new LinkedList<>();
            Queue<Integer> rq = new LinkedList<>();

            int n = senate.length();
            for (int c = 0; c < senate.length(); c++) {
                if (senate.charAt(c) == 'R') {
                    rq.add(c);
                } else {
                    dq.add(c);
                }
            }
            while (!dq.isEmpty() && !rq.isEmpty()) {
                int dIndex = dq.poll();
                int rIndex = rq.poll();
                if (dIndex < rIndex) {
                    dq.add(++n);

                } else {
                    rq.add(++n);
                }
            }
            if (rq.isEmpty()) {
                return "Dire";
            } else {
                return "Radiant";
            }
        }
    }
}
