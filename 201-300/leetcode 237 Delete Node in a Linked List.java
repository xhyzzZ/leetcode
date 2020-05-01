//leetcode 237 Delete Node in a Linked List

/*
time: O(1)
space: O(1)
*/

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
    	node.next = node.next.next;
    }
}