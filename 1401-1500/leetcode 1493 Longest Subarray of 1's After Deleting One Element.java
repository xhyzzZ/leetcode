// leetcode 1493 Longest Subarray of 1's After Deleting One Element

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0, end = 0, maxLen = 0, counter = 0;
        while (end < nums.length) {
            int c1 = nums[end];
            if (c1 == 0) counter++;
            while (counter > 1) {
                int c2 = nums[start];
                if (c2 == 0) counter--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen - 1;
    }
}