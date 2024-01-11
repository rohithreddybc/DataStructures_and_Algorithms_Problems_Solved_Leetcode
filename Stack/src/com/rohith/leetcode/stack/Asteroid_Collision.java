package com.rohith.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class Asteroid_Collision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int dif = 0;
        for (int ast : asteroids) {
            while (!st.empty() && ast < 0 && st.peek() > 0) {
                dif = ast + st.peek();
                if (dif < 0) {
                    st.pop();
                } else if (dif > 0) {
                    ast = 0;
                } else {
                    st.pop();
                    ast = 0;
                }
            }
            if (ast != 0) {
                st.push(ast);
            }
        }
        int[] ar = new int[st.size()];
        for (int i = ar.length - 1; i >= 0; i--) {
            ar[i] = st.pop();
        }
        return ar;
    }

    public static void main(String[] args) {
        Asteroid_Collision asteroidCollision = new Asteroid_Collision();
        
        // Example usage
        int[] asteroids = {5,10,-5};
        int[] result = asteroidCollision.asteroidCollision(asteroids);
        
        // Print the result
        System.out.println("Original Asteroids: " + Arrays.toString(asteroids));
        System.out.println("After Collision: " + Arrays.toString(result));
    }
}
