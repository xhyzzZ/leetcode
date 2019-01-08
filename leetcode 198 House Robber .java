//leetcode 198 House Robber


/*
time: O(n)
space: O(1)
*/
public class Solution {
	public int rob(int[] num) {
		int[][] dp = new int[num.length + 1][2];
		for(int i = 1; i <= num.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			dp[i][1] = num[i - 1] + dp[i - 1][0];
		}
		return Math.max(dp[num.length][0], dp[num.length][1]);
	}
}

public class Solution {
	public int rob(int[] num) {
		    int prevNo = 0;     // No: means we don't rob the current house
		    int prevYes = 0;    // Yes: means we rob the current house
		    for (int n : num) {
		        int temp = prevNo;
		        prevNo = Math.max(prevNo, prevYes);  // not rob current house, current max will depends on previous value: Math.max(prevNo, prevYes)
		        prevYes = n + temp  // rob current one, add current stashed money value
	    }
	    return Math.max(prevNo, prevYes);
	}
}