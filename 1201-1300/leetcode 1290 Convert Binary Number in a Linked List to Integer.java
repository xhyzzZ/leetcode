// leetcode 1290 Convert Binary Number in a Linked List to Integer

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int getDecimalValue(ListNode head) {
        int num = 0;
        while (head != null) {
            num = num * 2 + head.val;
            head = head.next;
        }
        return num;
    }
}