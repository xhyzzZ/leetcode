// leetcode 1283 Find the Smallest Divisor Given a Threshold

/*
time: O(logn)
space: O(1)
*/

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1, end = 0;
        for (int num : nums) end = Math.max(end, num);
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = cal(nums, mid);
            if (sum > threshold) start = mid + 1;
            else end = mid;
        }
        return start;
    }
    
    private int cal(int[] nums, int divisor) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % divisor == 0) sum += nums[i] / divisor;
            else sum += nums[i] / divisor + 1;
        }
        return sum;
    }
}