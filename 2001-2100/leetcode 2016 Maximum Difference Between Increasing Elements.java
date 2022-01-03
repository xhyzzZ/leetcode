// leetcode 2016 Maximum Difference Between Increasing Elements

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int maximumDifference(int[] nums) {
        int diff = -1, i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] < nums[j]) {
                diff = Math.max(diff, nums[j] - nums[i]);
            } else i = j;
        }
        return diff;
    }
}