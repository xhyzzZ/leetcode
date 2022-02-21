// leetcode 1673 Find the Most Competitive Subsequence

/*
time: O(n)
space: O(n)
*/


class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[k];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] < nums[stack.peek()] && nums.length - i + stack.size() > k) stack.pop();
            if (stack.size() < k) stack.push(i);
        }
        for (int i = k - 1; i >= 0; i--) res[i] = nums[stack.pop()];
        return res;
    }
}