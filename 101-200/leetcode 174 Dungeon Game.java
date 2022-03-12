// leetcode 174 Dungeon Game

/*
time: O(mn)
space: O(mn)
*/

// First we need to know what's the min health we need at the princess location?
// The key is assuming we have dp[m - 1][n - 1] health when we reach dungeon[m - 1][n - 1] before fighting, then
// 1.1 we must have at least 1 blood, i.e. dp[m - 1][n - 1] >= 1
// 1.2 after we fight with demons, we need to have at least 1 blood to be alive, i.e. dp[m - 1][n - 1] + dungeon[m - 1][n - 1] >= 1
// With above, we have: dp[m - 1][n - 1] >= 1 and dp[m - 1][n - 1] >= 1 - dungeon[i][j], thus dp[m - 1][n - 1] >= max(1, 1 - dungeon[m - 1][n - 1])
// Then what about the previous min health we should have, let's denote cur min health as cur?
// 2.1 we must have at least 1 blood, i.e. prev >= 1
// 2.2 after we fight with demons, we have cur health, i.e. prev + dungeon[prev] = cur
// From above, we have prev >= 1 and prev >= cur - dungeon[prev], thus prev = max(1, cur - dungeon[prev])
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        // corner case
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        
        // dp[i][j] represents the health when I reach dungeon[i][j]
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        // initialization:
        // dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);  
        // or dp[m - 1][n - 1] = dungeon[i][j] >= 0? 1 : -dungeon[i][j] + 1;
        // induction rule:
        // dp[i][n - 1] = max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1)
        // dp[m - 1][j] = max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1)
        // dp[i][j] = min(max(dp[i][j + 1] - dungeon[i][j], 1), max(dp[i + 1][j] - dungeon[i][j], 1))
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]); 
                } else if (i == m - 1) {
                    dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
                } else if (j == n - 1) {
                    dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
                } else {
                    dp[i][j] = Math.min(Math.max(dp[i + 1][j] - dungeon[i][j], 1), Math.max(dp[i][j + 1] - dungeon[i][j], 1));
                }
            }
        }
        
        return dp[0][0];
    }
}