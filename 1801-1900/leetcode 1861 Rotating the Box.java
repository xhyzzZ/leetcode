// leetcode 1861 Rotating the Box

/*
time: O(mn)
space: O(mn)
*/


class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] ans = new char[n][m];
        for (int r = 0, j = m - 1; r < m; ++r, --j) {
            for (int c = n - 1, i = n; c >= 0; --c) {
                if (box[r][c] == '#') {
                    swap(box[r], c, --i);
                } else if (box[r][c] == '*') {
                    i = c;
                }
            }
            for (int c = 0; c < n; ++c) {
                ans[c][j] = box[r][c];
            }
        }
        return ans;
    }
    private void swap(char[] charArr, int i, int j) {
        char c = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = c;
    }
}