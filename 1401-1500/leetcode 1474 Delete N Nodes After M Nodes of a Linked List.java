// leetcode 1474 Delete N Nodes After M Nodes of a Linked List

/*
time: O(n)
space: O(1)
*/

class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode cur = head;
        int cnt = 0;
        while (cur.next != null) {
        	cnt++;
        	if (cnt % (m + n) < m) cur = cur.next;
        	else cur.next = cur.next.next;
        }
        return head;
    }
}