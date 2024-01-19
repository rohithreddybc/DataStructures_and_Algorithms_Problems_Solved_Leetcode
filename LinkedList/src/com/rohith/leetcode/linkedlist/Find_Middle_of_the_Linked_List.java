package com.rohith.leetcode.linkedlist;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Find_Middle_of_the_Linked_List {

    public ListNode middleNode(ListNode head) {
        ListNode slowPointer = head, fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    public static void main(String[] args) {
        // Example usage or additional testing can be done here
        // Instantiate a linked list
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        // Call the middleNode method and print the result
        Find_Middle_of_the_Linked_List solution = new Find_Middle_of_the_Linked_List();
        ListNode middleNode = solution.middleNode(head);

        // Print the middle node's value
        System.out.println("Middle Node Value: " + middleNode.val);
    }
}
