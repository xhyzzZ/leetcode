// leetcode 2181 Merge Nodes in Between Zeros

/*
time: O(n)
space: O(1)
*/

class Solution {
    public ListNode mergeNodes(ListNode head) {
        head = head.next;
        ListNode cur = head, res = head;
        
        int sum = 0;
        
        while (cur != null) {
            // loop to sum the data of nodes till it encounters 0
            if (cur.val != 0) {
                sum += cur.val;
                cur = cur.next;
            } else {
                // If we encounters 0, we need to update next pointers
                res.val = sum;
                res.next = cur.next;
                cur = res.next;
                res = res.next;
                sum = 0;
            }
        }
        
        return head;
    }
}
