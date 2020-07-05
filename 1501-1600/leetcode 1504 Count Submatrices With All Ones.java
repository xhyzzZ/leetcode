// leetcode 1504 Count Submatrices With All Ones

/*
time: O(n^3)
space: O(1)
*/

class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = 1 + ((j == 0) ? 0 : mat[i][j - 1]);
                    int max = mat[i][j];
                    for (int k = i; k >= 0; k--) {
                        max = Math.min(max, mat[k][j]);
                        ans += max;
                    }
                }
            }
        }
        return ans;
    }
}