// leetcode 1340 Jump Game V

/*
time: O(nd)
space: O(n)
*/

class Solution {
    public static int maxJumps(int[] arr, int d) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        for (int i = 0; i < arr.length; i++) {
            helper(i, dp, d, arr);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    private int helper(int i, int[] dp, int d, int[] arr) {
        if (dp[i] != -1) return dp[i];// IF already cal return it.
        boolean canStop = false; // IF between i n j IF arr[i] < arr[k] break it
//      In Forward direction
        for (int j = i + 1, count = 0; count < d && !canStop && j < arr.length; j++, count++) {
            if (arr[i] > arr[j]) {
                dp[i] = Math.max(dp[i], 1 + helper(j, dp, d, arr));
            } else
                canStop = true;
        }
//      In Backward direction
        canStop = false;
        for (int j = i - 1, count = 0; j >= 0 && count < d && !canStop; j--, count++) {
            if (arr[i] > arr[j]) {
                dp[i] = Math.max(dp[i], 1 + helper(j, dp, d, arr));
            } else
                canStop = true;
        }
        dp[i] = Math.max(dp[i], 1);
        return dp[i];
    }
}