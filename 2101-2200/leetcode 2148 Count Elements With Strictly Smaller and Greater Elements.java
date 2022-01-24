// leetcode 2148 Count Elements With Strictly Smaller and Greater Elements

/*
time: O(n)
space: O(1)
*/ 

class Solution {
    public int countElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min && nums[i] < max) res++;
        }
        
        return res;
    }
}