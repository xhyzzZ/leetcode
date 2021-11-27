// leetcode 713 Subarray Product Less Than K

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int base = 1;
        int start = 0, end = 0, count = 0;
        while (end < nums.length) {
            base *= nums[end];

            while (start <= end && base >= k) {
                base /= nums[start];
                start++;
            }
            count += end - start + 1;
            end++;
        }
        return count; 
    }
}