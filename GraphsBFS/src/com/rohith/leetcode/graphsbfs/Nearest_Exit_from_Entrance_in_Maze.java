package com.rohith.leetcode.graphsbfs;

import java.util.*;

public class Nearest_Exit_from_Entrance_in_Maze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rl = maze.length;
        int cl = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        maze[entrance[0]][entrance[1]] = '+';
        q.offer(entrance);
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int x, y;
        int steps = 0;
        while (!q.isEmpty()) {
            steps++;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    x = cur[0] + dir[0];
                    y = cur[1] + dir[1];
                    if (x < 0 || y < 0 || x >= rl || y >= cl) {
                        continue;
                    }
                    if (maze[x][y] == '+') {
                        continue;
                    }
                    if (x == 0 || x == rl - 1 || y == 0 || y == cl - 1) {
                        return steps;
                    }
                    maze[x][y] = '+';
                    q.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] maze = {
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '+', '.'}
        };
        int[] entrance = {1, 2};

        Nearest_Exit_from_Entrance_in_Maze solution = new Nearest_Exit_from_Entrance_in_Maze();
        int steps = solution.nearestExit(maze, entrance);
        System.out.println("Output: " + steps);
    }
}
