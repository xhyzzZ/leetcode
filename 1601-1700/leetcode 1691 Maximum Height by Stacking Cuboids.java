// leetcode 1691 Maximum Height by Stacking Cuboids

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public int maxHeight(int[][] cuboids) {
        for (int[] cube : cuboids) Arrays.sort(cube);
        Arrays.sort(cuboids, (a, b) -> (a[0] + a[1] + a[2]) - (b[0] + b[1] + b[2]));
        int len = cuboids.length, res = 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = cuboids[i][2];
            res = Math.max(res, dp[i]);
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
            	if (cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}