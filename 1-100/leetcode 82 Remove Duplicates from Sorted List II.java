//leetcode 82 Remove Duplicates from Sorted List II

/*
time: O(n)
space: O(1)
*/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //use two pointers, slow - track the node before the dup nodes, 
		// fast - to find the last node of dups.
	    ListNode dummy = new ListNode(0), fast = head, slow = dummy;
	    slow.next = fast;
	    while (fast != null) {
	    	while (fast.next != null && fast.val == fast.next.val) {
	     		fast = fast.next;    //while loop to find the last node of the dups.
	    	}
	    	if (slow.next != fast) { //duplicates detected.
	    		slow.next = fast.next; //remove the dups.
	    		fast = slow.next;     //reposition the fast pointer.
	    	} else { //no dup, move down both pointer.
	    		slow = slow.next;
	    		fast = fast.next;
	    	}
	    	
	    }
	    return dummy.next;
    }
}