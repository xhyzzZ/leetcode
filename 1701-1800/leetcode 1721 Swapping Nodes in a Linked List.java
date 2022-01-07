// leetcode 1721 Swapping Nodes in a Linked List

/*
time: O(n)
space: O(1)
*/

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int len = 0;
        ListNode front = null;
        ListNode tail = null;
        ListNode cur = head;
        // find the length of list and set the front node
        while (cur != null) {
            len++;
            if (len == k) front = cur;
            cur = cur.next;
        }
        // set the end node at (len - k)th node
        tail = head;
        for (int i = 1; i <= len - k; i++) {
            tail = tail.next;
        }
        // swap front node and end node values
        int temp = front.val;
        front.val = tail.val;
        tail.val = temp;
        return head;
    }
}