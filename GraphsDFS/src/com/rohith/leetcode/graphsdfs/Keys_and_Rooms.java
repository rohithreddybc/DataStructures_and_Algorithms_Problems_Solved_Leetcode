package com.rohith.leetcode.graphsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Keys_and_Rooms {
    public static void main(String[] args) {
        // Example 1 input
        List<List<Integer>> rooms1 = new ArrayList<>();
        rooms1.add(Arrays.asList(1));   // Room 0 has key to room 1
        rooms1.add(Arrays.asList(2));   // Room 1 has key to room 2
        rooms1.add(Arrays.asList(3));   // Room 2 has key to room 3
        rooms1.add(Arrays.asList());    // Room 3 has no keys
        
        // Example 2 input
        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(Arrays.asList(1, 3));        // Room 0 has keys to rooms 1 and 3
        rooms2.add(Arrays.asList(3, 0, 1));    // Room 1 has keys to rooms 3, 0, and 1
        rooms2.add(Arrays.asList(2));           // Room 2 has key to room 2
        rooms2.add(Arrays.asList(0));           // Room 3 has key to room 0
        
        // Create an instance of the Keys_and_Rooms class
        Keys_and_Rooms solver = new Keys_and_Rooms();

        // Example 1
        boolean result1 = solver.canVisitAllRooms(rooms1);
        System.out.println("Example 1 Output: " + result1);

        // Example 2
        boolean result2 = solver.canVisitAllRooms(rooms2);
        System.out.println("Example 2 Output: " + result2);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int roomsSize = rooms.size();
        boolean visitedRooms[] = new boolean[roomsSize];

        visitRooms(rooms, rooms.get(0), 0, visitedRooms);
        for(int i=0;i< roomsSize;i++){
            if(!visitedRooms[i]){
                return false;
            }
        }

        return true;
    }

    public void visitRooms(List<List<Integer>> rooms, List<Integer> currentRoomKeys, int roomToVisit, boolean[] visitedRooms){
        visitedRooms[roomToVisit] = true;

        for(Integer i: currentRoomKeys){
            if(!visitedRooms[i]){
                visitRooms(rooms, rooms.get(i), i, visitedRooms);
            }
        }
    }
}
