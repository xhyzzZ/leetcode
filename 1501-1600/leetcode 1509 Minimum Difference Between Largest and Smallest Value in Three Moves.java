// leetcode 1509 Minimum Difference Between Largest and Smallest Value in Three Moves

/*
time: O(nlogn)
space: O(1)
*/

class Solution {
    public int minDifference(int[] nums) {
        if (nums.length < 5) return 0;
        
        Arrays.sort(nums);
        int ans = nums[nums.length - 4] - nums[0];
        ans = Math.min(nums[nums.length - 3] - nums[1], ans);
        ans = Math.min(nums[nums.length - 2] - nums[2], ans);
        ans = Math.min(nums[nums.length - 1] - nums[3], ans);
        
        return ans;
    }
}