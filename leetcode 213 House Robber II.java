//leetcode 213 House Robber II

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];  
        return Math.max(rob0(nums), rob1(nums));
    }
    
    public int rob0(int[] nums) {
        int preMax = 0, curMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int tmp = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = tmp;  
        }  
        return curMax;
    }
    
    public int rob1(int[] nums) {
        int preMax = 0, curMax = 0;
        for (int i = 1; i < nums.length; i++) {
            int tmp = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = tmp;  
        }  
        return curMax;  
    }
}