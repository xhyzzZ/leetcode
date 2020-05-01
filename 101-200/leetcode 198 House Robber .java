//leetcode 198 House Robber


/*
time: O(n)
space: O(1)
*/
public class Solution {
	public int rob(int[] nums) {
	    if (nums.length == 0) return 0;
	    int[] memo = new int[nums.length + 1];
	    memo[0] = 0;
	    memo[1] = nums[0];
	    for (int i = 1; i < nums.length; i++) {
	        int val = nums[i];
	        memo[i + 1] = Math.max(memo[i], memo[i - 1] + val);
	    }
	    return memo[nums.length];
	}
}


public class Solution {
	public int rob(int[] num) {
		// max monney can get if rob current house
	    int rob = 0; 
	    // max money can get if not rob current house
	    int notrob = 0; 
	    for (int i = 0; i < num.length; i++) {
	    	// if rob current value, previous house must not be robbed
	        int currob = notrob + num[i]; 
	        // if not rob ith house, 
	        // take the max value of robbed (i-1)th house and not rob (i-1)th house
	        notrob = Math.max(notrob, rob); 
	        rob = currob;
	    }
	    return Math.max(rob, notrob);
	}
}