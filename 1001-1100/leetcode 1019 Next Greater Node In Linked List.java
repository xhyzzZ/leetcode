// leetcode 1019 Next Greater Node In Linked List

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next)
            list.add(node.val);
        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < list.size(); ++i) {
            int cur = list.get(i);
            while (!stack.isEmpty() && list.get(stack.peek()) < cur) {
                res[stack.pop()] = cur;
            }
            stack.push(i);
        }
        return res;
    }
}