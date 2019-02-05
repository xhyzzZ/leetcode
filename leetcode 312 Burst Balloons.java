//leetcode 312 Burst Balloons

/*
time: O(n^3)
space: O(n^2)
*/

class Solution {
    public int maxCoins(int[] iNums) {
        int n = nums.length;
      	int[] newnums = new int[n + 2];
      	newnums[0] = 1; newnums[n + 1] = 1;
      	for(int i = 0; i < n; i++) {
        newnums[i + 1] = nums[i];  
      	}  
      	int[][] C = new int[n + 2][n + 2];
      	return helper(newnums, C, 1, n);  
    }
    
    int helper(int[] nums, int[][] C, int s, int e) {
        if(s > e) return 0;
        if(C[s][e] > 0) {
           return C[s][e];  
        }
        for(int i = s; i <= e; i++) {
           int v = nums[s - 1] * nums[i] * nums[e + 1] + helper(nums, C, s, i - 1) + helper(nums, C, i + 1, e);  
           C[s][e] = Math.max(C[s][e], v);  
        }
        return C[s][e];
    }
}