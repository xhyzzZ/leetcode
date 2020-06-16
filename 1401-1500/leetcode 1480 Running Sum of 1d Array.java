// leetcode 1480 Running Sum of 1d Array

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] runningSum(int[] nums) {
        int cur = 0;
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            cur += nums[i];
            res[i] = cur;
        }
        return res;
    }
}