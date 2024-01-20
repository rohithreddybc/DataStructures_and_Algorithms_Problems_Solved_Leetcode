package com.rohith.leetcode.linkedlist;

public class Maximum_Twin_Sum_of_a_Linked_List {

	// Definition for singly-linked list
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public int pairSum(ListNode head) {
		// find middle node
		ListNode fast = head.next.next, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// reverse from mid
		ListNode pre = null, next = null;
		while (slow != null) {
			next = slow.next;
			slow.next = pre;
			pre = slow;
			slow = next;
		}

		// calculate max sum
		int maxval = 0;
		while (head != null) {
			maxval = Math.max(maxval, head.val + pre.val);
			head = head.next;
			pre = pre.next;
		}

		return maxval;
	}

	public static void main(String[] args) {
		// Test your pairSum method here
		Maximum_Twin_Sum_of_a_Linked_List solution = new Maximum_Twin_Sum_of_a_Linked_List();

		// Example Usage:
		ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		int result = solution.pairSum(list);
		System.out.println("Maximum Twin Sum: " + result);
	}
}
