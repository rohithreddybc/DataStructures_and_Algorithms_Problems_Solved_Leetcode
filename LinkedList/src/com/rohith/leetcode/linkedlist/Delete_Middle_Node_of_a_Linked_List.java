package com.rohith.leetcode.linkedlist;

public class Delete_Middle_Node_of_a_Linked_List {
	public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        ListNode slowPointer = head;
        ListNode fastPointer = head.next.next;
        
        while(fastPointer != null && fastPointer.next != null ){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            
        }
        slowPointer.next = slowPointer.next.next;
        return head;
    }

}
