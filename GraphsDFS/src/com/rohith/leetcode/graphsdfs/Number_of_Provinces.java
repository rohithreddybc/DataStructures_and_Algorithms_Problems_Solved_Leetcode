package com.rohith.leetcode.graphsdfs;

public class Number_of_Provinces {
    public static void main(String[] args) {
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        Number_of_Provinces solution = new Number_of_Provinces();
        int provinces = solution.findCircleNum(isConnected);
        System.out.println("Number of provinces: " + provinces);
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, count = 0;
        boolean[] isVisited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                dfs(isConnected, isVisited, i, n);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, boolean[] isVisited, int i, int n){
        isVisited[i] = true;

        for(int j=0;j<n;j++){
            if(isConnected[i][j] == 1 && !isVisited[j]){
                dfs(isConnected, isVisited, j, n);
            }
        }
    }
}
