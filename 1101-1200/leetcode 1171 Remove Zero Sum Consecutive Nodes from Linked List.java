// leetcode 1171 Remove Zero Sum Consecutive Nodes from Linked List

/*
time: O(n)
space: O(1)
*/

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        while (cur != null) {
            sum += cur.val;
            if (map.containsKey(sum)) {
                cur = map.get(sum).next;
                int key = sum + cur.val;
                while (key != sum) {
                    map.remove(key);
                    cur = cur.next;
                    key += cur.val;
                }
                map.get(sum).next = cur.next;
            } else {
                map.put(sum, cur);   
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}