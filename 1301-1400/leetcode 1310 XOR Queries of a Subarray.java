// leetcode 1310 XOR Queries of a Subarray

/*
time: O(n^2)
space: O(n)
*/

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0], right = queries[i][1];
            int ans = 0;
            for (int j = left; j <= right; j++) {
                ans ^= arr[j];
            }
            res[i] = ans;
        }
        return res;
    }
}

