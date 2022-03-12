// leetcode 552 Student Attendance Record II

/*
time: O(n)
space: O(n)
*/

class Solution {
    private static int MOD = 1000000007;
    // Top down dp with memoization. Do it as if you were generating the sequences.
    public int checkRecord(int n) {
        return helper(n, 0, 0, new Integer[n + 1][2][3]);
    }

    // Returns the number of ways to create a string of length n with characters 'A', 'L', 'P' 
    // while having <=1 total 'A's and <=2 consecutive 'L's.
    private int helper(int n, int totalA, int continuousL, Integer[][][] cache) {
        if (n == 0) return 1;
        if (cache[n][totalA][continuousL] != null) return cache[n][totalA][continuousL];
        
        int res = 0;
        if (totalA == 0) {
            res += helper(n - 1, totalA + 1, 0, cache);              // Choose 'A'
            res %= MOD;
        }
        
        if (continuousL < 2) {
            res += helper(n - 1, totalA, continuousL + 1, cache);    // Choose 'L'
            res %= MOD;
        }
        
        res += helper(n - 1, totalA, 0, cache);                      // Choose 'P'
        res %= MOD;
        cache[n][totalA][continuousL] = res;
        return res;
    }
}