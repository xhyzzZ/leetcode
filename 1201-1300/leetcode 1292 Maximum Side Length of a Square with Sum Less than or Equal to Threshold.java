// leetcode 1292 Maximum Side Length of a Square with Sum Less than or Equal to Threshold

/*
time: O(mn)
space: O(mn)
*/

class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;
        // sums[i][j] is sum of all elements from rectangle (0,0,n,m)
        int[][] sums = new int[n + 1][m + 1];
        int max = 0;        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sums[i + 1][j + 1] = sums[i + 1][j] + sums[i][j + 1] - sums[i][j] + mat[i][j];
                if (i - max >= 0 && j - max >= 0 && 
                    sums[i + 1][j + 1] - sums[i - max][j + 1] - sums[i + 1][j - max] + sums[i - max][j - max] <= threshold
                   ) {
                    max += 1;
                }
            }
        }
        return max;
    }
}