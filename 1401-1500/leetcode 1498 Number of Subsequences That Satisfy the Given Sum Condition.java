// leetcode 1498 Number of Subsequences That Satisfy the Given Sum Condition

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int l = 0, r = len - 1, mod = (int) 1e9 + 7;
        int[] pows = new int[len];
        pows[0] = 1;
        for (int i = 1 ; i < len; i++) {
            pows[i] = pows[i - 1] * 2 % mod;
        }
        
        int res = 0;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                res = (res + pows[r - l]) % mod;
                l++;
            }
        }
        return res;
    }
}