// leetcode 1510 Stone Game IV

/*
time: O(n^1.5)
space: O(n)
*/

class Solution {
    public boolean winnerSquareGame(int n) {
        // Let dp[i] represents the result of the game with i stones
        // We can iterate all possible movements, and check if we can move to a False state. 
        // If we can, then we found a must-win strategy, otherwise, we must lose since the opponent has a must-win strategy in this case.
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k * k <= i; k++) {
                if (dp[i - k * k] == false) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}