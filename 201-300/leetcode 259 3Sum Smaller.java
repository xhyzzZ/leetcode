// leetcode 259 3Sum Smaller

/*
time: O(n^2)
space: O(1)
*/

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                if (nums[i] + nums[lo] + nums[hi] < target) {
                    result += hi - lo;
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return result;
    }
}