// leetcode 61 Rotate List


/*
time: O(n)
space: O(1)
*/

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode index = head;
        int len = 1;
        while (index.next != null) {
        	index = index.next;
        	len++; // 计算链表长度
        }

        index.next = head; // 连成环
        for (int i = 1; i < len - k % len; i++) {
        	head = head.next;
        }
        ListNode res = head.next;
        head.next = null; // 断开链表
        return res;
    }
}