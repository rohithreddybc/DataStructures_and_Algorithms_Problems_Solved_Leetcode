package com.rohith.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Number_of_Recent_Calls {

    public static void main(String[] args) {
        // Example usage
        Number_of_Recent_Calls recentCounter = new Number_of_Recent_Calls();
        System.out.println(recentCounter.ping(1));  // Output: 1
        System.out.println(recentCounter.ping(100));  // Output: 2
        System.out.println(recentCounter.ping(3001));  // Output: 3
        System.out.println(recentCounter.ping(3002));  // Output: 3
    }

    Queue<Integer> q;

    public Number_of_Recent_Calls() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000) {
            q.poll();
        }
        return q.size();
    }
}
