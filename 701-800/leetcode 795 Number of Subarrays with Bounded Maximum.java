// leetcode 795 Number of Subarrays with Bounded Maximum

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int start = 0;
        int end = 0;
        int ans = 0;
        int smaller = 0;
        
        while (end < nums.length) {
            if (nums[end] >= left && nums[end] <= right) {
                smaller = end - start + 1;
                ans += smaller;
            } else if (nums[end] < left) {
                ans += smaller;
            } else {
                start = end + 1;
                smaller = 0;
            }
            end++;
        }
        return ans;
    }
}