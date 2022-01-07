// leetcode 1696 Jump Game VI

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        int[] score = new int[len];
        score[0] = nums[0];
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(0);
        for (int i = 1; i < len; i++) {
            // pop the old index
            while (!deque.isEmpty() && deque.peekFirst() < i - k) deque.pollFirst();
            score[i] = score[deque.peek()] + nums[i];
            // pop the smaller value, monotonically decreasing queue
            while (!deque.isEmpty() && score[i] >= score[deque.peekLast()]) deque.pollLast();
            deque.offerLast(i);
        }
        return score[len - 1];
    }
}