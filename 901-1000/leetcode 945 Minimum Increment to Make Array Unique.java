// leetcode 945 Minimum Increment to Make Array Unique

/*
time: O(nlogn)
space: O(1)
*/

class Solution {
    public int minIncrementForUnique(int[] nums) {
    	if (nums.length == 0) return 0;
	    Arrays.sort(nums);
	    int pre = nums[0], res = 0;
	    for (int i = 1; i < nums.length; i++) {
	        pre = Math.max(pre + 1, nums[i]);
	        res += pre - nums[i];
	    }
	    return res;
    }
}