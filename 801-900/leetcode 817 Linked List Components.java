// leetcode 817 Linked List Components

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int res = 0;
        while (head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) res++;
            head = head.next;
        }
        return res;
    }
}