//leetcode 322 Coin Change

/*
time: O()
space: O(n)
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
       	// dp[n] = min number of coins to make amount n;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int j = 0; j < coins.length; j++) {
			for (int i = coins[j]; i <= amount; i++) {
				dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
			}
		}
		return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
