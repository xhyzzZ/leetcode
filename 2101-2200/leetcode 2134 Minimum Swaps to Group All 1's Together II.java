// leetcode 2134 Minimum Swaps to Group All 1's Together II

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0;
        for (int n : nums) ones += n;
        int max = 0;
        for (int left = -1, right = 0, onesInWin = 0, n = nums.length; right < 2 * n; right++) {
            onesInWin += nums[right % n];
            if (right - left > ones) {
            	left++;
                onesInWin -= nums[left % n];
            }
            max = Math.max(max, onesInWin);
        }
        return ones - max;
    }
}