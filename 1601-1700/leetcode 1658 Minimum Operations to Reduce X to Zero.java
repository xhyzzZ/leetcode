// leetcode 1658 Minimum Operations to Reduce X to Zero

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int num : nums) total += num;
        int target = total - x, cur = 0, max = -1;
        for (int l = 0, r = 0; r < nums.length; r++) {
            cur += nums[r];  
            while (l <= r && target < cur) {
                cur -= nums[l];
                l++;
            }
            if (cur == target) max = Math.max(max, r - l + 1);
        }
        return max == -1 ? -1 : nums.length - max; 
    }
}