//leetcode 487 Max Consecutive Ones II

/*
time: O(n)
space: O(1)
*/


class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0, zeroLeft = 0, zeroRight = 0;
     	for (int i = 0; i < nums.length; i++) {
        	zeroRight++;
        	if (nums[i] == 0) {
            	zeroLeft = zeroRight;
            	zeroRight = 0;
         	}
         	maxConsecutive = Math.max(maxConsecutive, zeroLeft + zeroRight); 
     	}
     	return maxConsecutive;
    }
}