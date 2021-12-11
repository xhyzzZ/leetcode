// leetcode 198 House Robber

/*
time: O(n)
space: O(n)
*/

// rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )
recursiuon + memo(top-down)
class Solution {
    int[] memo;
	public int rob(int[] nums) {
	    memo = new int[nums.length + 1];
	    Arrays.fill(memo, -1);
	    return rob(nums, nums.length - 1);
	}

	private int rob(int[] nums, int i) {
	    if (i < 0) return 0;
	    if (memo[i] >= 0) {
	        return memo[i];
	    }
	    int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
	    memo[i] = result;
	    return result;
	}
}

iterative + memo(bottom-up)
class Solution {
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

/*
time: O(n)
space: O(1)
*/

iterative + 2 variables(bottom-up)
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