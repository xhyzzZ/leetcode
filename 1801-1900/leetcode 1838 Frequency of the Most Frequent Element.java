// leetcode 1838 Frequency of the Most Frequent Element

/*
time: O(nlogn)
space: O(1)
*/

class Solution {
    public int maxFrequency(int[] nums, int k) {
        int res = 1, i = 0;
        long sum = 0;
        Arrays.sort(nums);
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum + k < (long) nums[j] * (j - i + 1)) {
                sum -= nums[i];
                i += 1;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}