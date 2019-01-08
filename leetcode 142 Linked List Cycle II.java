//leetcode 142 Linked List Cycle II


/*
time: O()
space: O(1)
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;

        	if(fast == slow) {
        		while(head != slow) {
        			slow = slow.next;
        			head = head.next;
        		}
        		return slow;
        	}
        }
        return null;
    }
}