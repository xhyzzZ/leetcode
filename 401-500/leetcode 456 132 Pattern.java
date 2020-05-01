//leetcode 456 132 Pattern

/*
time: O(n)
space: O(1)
*/

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length, top = n, third = Integer.MIN_VALUE;

	    for (int i = n - 1; i >= 0; i--) {
	        if (nums[i] < third) return true;
	        while (top < n && nums[i] > nums[top]) third = nums[top++];
	        nums[--top] = nums[i];
	    }
	    
	    return false;
    }
}