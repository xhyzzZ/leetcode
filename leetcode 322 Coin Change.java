//leetcode 322 Coin Change

/*
time: O(n * amount)
space: O(n)
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
       	// dp[n] = min number of coins to make amount n;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		// no money no coin
		dp[0] = 0;
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}
		return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
