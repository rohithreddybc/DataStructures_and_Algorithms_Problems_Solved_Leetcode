package com.rohith.leetcode.graphsdfs;

import java.util.ArrayList;
import java.util.List;

public class Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero {
    public static void main(String[] args) {
        Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero solution = new Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero();
        int n = 6;
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int minReorder = solution.minReorder(n, connections);
        System.out.println("Minimum number of reorder routes: " + minReorder);
    }

    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<Integer>());
        }

        for(int[] c: connections){
            int from = c[0];
            int to = c[1];
            g.get(from).add(to);
            g.get(to).add(-from);
        }

        boolean[] isVisited = new boolean[n];

        return dfs(g, isVisited, 0);
    }

    private int dfs(List<List<Integer>> gr, boolean[] isVisited, int from){
        isVisited[from] = true;
        int change = 0;

        for(int neighbor: gr.get(from)){
            if(!isVisited[Math.abs(neighbor)]){
                change += dfs(gr, isVisited, Math.abs(neighbor)) + (neighbor > 0 ? 1 : 0);
            }
        }
        return change;
    }
}
