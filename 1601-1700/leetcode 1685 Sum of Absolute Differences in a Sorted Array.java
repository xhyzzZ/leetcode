// leetcode 1685 Sum of Absolute Differences in a Sorted Array

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int[] prefixSum = new int[len + 1];
        for (int i = 0; i < len; i++) prefixSum[i + 1] = prefixSum[i] + nums[i];
        for (int i = 0; i < len; i++) {
            res[i] = i * nums[i] - prefixSum[i] + (prefixSum[len] -  prefixSum[i] - (len - i) * nums[i]);
        }
        return res;
    }
}
